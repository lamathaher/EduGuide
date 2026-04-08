package com.lama.roadmap.repository;

import com.lama.roadmap.model.Message;
import com.lama.roadmap.model.InstructorAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByAssignmentOrderByCreatedAtAsc(InstructorAssignment assignment);

}