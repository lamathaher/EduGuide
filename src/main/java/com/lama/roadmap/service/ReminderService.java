package com.lama.roadmap.service;

import com.lama.roadmap.model.User;
import com.lama.roadmap.model.StepProgress;
import com.lama.roadmap.repository.UserRepository;
import com.lama.roadmap.repository.StepProgressRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReminderService {

    private final UserRepository userRepository;
    private final NotificationService notificationService;
    private final StepProgressRepository progressRepository; // ✅ جديد

    public ReminderService(UserRepository userRepository,
                           NotificationService notificationService,
                           StepProgressRepository progressRepository) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
        this.progressRepository = progressRepository;
    }

    // 🔥 كل ساعة
    @Scheduled(fixedRate = 1000 * 60 * 60)
    public void sendReminders() {

        List<User> users = userRepository.findAll();

        for (User user : users) {

            if (user.getLastActivityAt() == null) continue;

            boolean inactive24h =
                    user.getLastActivityAt().isBefore(LocalDateTime.now().minusHours(24));

            boolean alreadyNotified =
                    user.getLastReminderSentAt() != null &&
                    user.getLastReminderSentAt().isAfter(LocalDateTime.now().minusHours(24));

            if (inactive24h && !alreadyNotified) {

                // 🔥 نجيب آخر خطوة
                StepProgress lastStep = progressRepository
                        .findTopByStudentOrderByCreatedAtDesc(user)
                        .orElse(null);

                String message = "Continue your roadmap 🚀";

                if (lastStep != null) {
                    message = "You stopped at: " + lastStep.getStepTitle() + " 📍";
                }

                notificationService.createNotification(
                        user.getId(),
                        "We miss you 📍",
                        message,
                        "REMINDER",
                        user.getLastOpenedRoadmapId()
                );

                user.setLastReminderSentAt(LocalDateTime.now());
                userRepository.save(user);
            }
        }
    }
}