package com.lama.roadmap.service;

import com.lama.roadmap.model.Notification;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.NotificationRepository;
import com.lama.roadmap.repository.UserRepository;
import org.springframework.stereotype.Service;

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

    public Notification createNotification(Long userId,String title,String message,String type,Long relatedId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Notification notification = new Notification();

        notification.setUser(user);
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setType(type);
        notification.setRelatedId(relatedId);

        return notificationRepository.save(notification);
    }

    public List<Notification> getUserNotifications(Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return notificationRepository.findByUserOrderByCreatedAtDesc(user);
    }

    public long getUnreadCount(Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return notificationRepository.countByUserAndIsReadFalse(user);
    }

    public Notification markAsRead(Long notificationId){

        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notification.setIsRead(true);

        return notificationRepository.save(notification);
    }
    
    public void sendNotification(Long userId, String title, String message, String type, Long relatedId) {

        Notification notification = new Notification();

        // نجيب المستخدم عن طريق ID
        User user = new User();
        user.setId(userId);

        notification.setUser(user);
        notification.setTitle(title);
        notification.setMessage(message);
        notification.setType(type);
        notification.setRelatedId(relatedId);
        notification.setIsRead(false);
        notification.setCreatedAt(java.time.LocalDateTime.now());

        notificationRepository.save(notification);
    }

}