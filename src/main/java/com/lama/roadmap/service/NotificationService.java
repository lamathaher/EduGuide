package com.lama.roadmap.service;

import com.lama.roadmap.model.Notification;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.NotificationRepository;
import com.lama.roadmap.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationService(NotificationRepository notificationRepository,
                               UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    // ✅ إنشاء إشعار (موحد)
    public Notification createNotification(Long userId,
                                           String title,
                                           String message,
                                           String type,
                                           Long relatedId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Notification notification = new Notification();

        notification.setUser(user);
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setType(type);
        notification.setRelatedId(relatedId);
        notification.setIsRead(false);
        notification.setCreatedAt(LocalDateTime.now());

        return notificationRepository.save(notification);
    }

    // ✅ جلب الإشعارات
    public List<Notification> getUserNotifications(Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return notificationRepository.findByUserOrderByCreatedAtDesc(user);
    }

    // ✅ عدد غير المقروء
    public long getUnreadCount(Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return notificationRepository.countByUserAndIsReadFalse(user);
    }

    // ✅ تعليم إشعار واحد كمقروء
    public Notification markAsRead(Long notificationId){

        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        if(Boolean.TRUE.equals(notification.getIsRead())){
            return notification;
        }

        notification.setIsRead(true);
        return notificationRepository.save(notification);
    }

    // ✅ 🔥 أهم إضافة: تعليم كل إشعارات الشات كمقروءة
    public void markChatNotificationsAsRead(Long userId, Long assignmentId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Notification> notifications =
                notificationRepository.findByUserAndTypeAndRelatedIdAndIsReadFalse(
                        user, "CHAT", assignmentId
                );

        for(Notification n : notifications){
            n.setIsRead(true);
        }

        notificationRepository.saveAll(notifications);
    }
}