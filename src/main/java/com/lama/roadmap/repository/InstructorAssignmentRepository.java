package com.lama.roadmap.repository;

import com.lama.roadmap.model.InstructorAssignment;
import com.lama.roadmap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstructorAssignmentRepository extends JpaRepository<InstructorAssignment, Long> {

    List<InstructorAssignment> findByStudent(User student);

    List<InstructorAssignment> findByInstructor(User instructor);
    
    Optional<InstructorAssignment> findByStudentAndStatus(User student, String status);
    

        Optional<InstructorAssignment> findByStudentIdAndStatus(Long studentId, String status);
    

}