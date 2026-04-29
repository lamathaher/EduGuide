package com.lama.roadmap.repository;

import com.lama.roadmap.model.Message;
import com.lama.roadmap.model.InstructorAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByAssignmentOrderByCreatedAtAsc(InstructorAssignment assignment);

    @Modifying
    @Query("""
        UPDATE Message m 
        SET m.isRead = true 
        WHERE m.assignment.id = :assignmentId 
        AND m.sender.id != :userId 
        AND m.isRead = false
    """)
    int markAllAsRead(
            @Param("assignmentId") Long assignmentId,
            @Param("userId") Long userId
    );
}