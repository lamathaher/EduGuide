package com.lama.roadmap.repository;

import com.lama.roadmap.model.Notification;
import com.lama.roadmap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long>{

    List<Notification> findByUserOrderByCreatedAtDesc(User user);

    long countByUserAndIsReadFalse(User user);

}