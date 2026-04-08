package com.lama.roadmap.repository;

import com.lama.roadmap.model.PerformanceNote;
import com.lama.roadmap.model.InstructorAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformanceNoteRepository extends JpaRepository<PerformanceNote, Long> {

    List<PerformanceNote> findByAssignment(InstructorAssignment assignment);
    List<PerformanceNote> findByAssignmentOrderByCreatedAtDesc(InstructorAssignment assignment);

}