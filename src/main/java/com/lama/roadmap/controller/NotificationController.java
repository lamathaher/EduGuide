package com.lama.roadmap.controller;

import com.lama.roadmap.model.Notification;
import com.lama.roadmap.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/user/{id}")
    public List<Notification> getUserNotifications(@PathVariable Long id){
        return notificationService.getUserNotifications(id);
    }

    @GetMapping("/user/{id}/unread-count")
    public long getUnreadCount(@PathVariable Long id){
        return notificationService.getUnreadCount(id);
    }

    @PutMapping("/{id}/read")
    public Notification markAsRead(@PathVariable Long id){
        return notificationService.markAsRead(id);
    }

}