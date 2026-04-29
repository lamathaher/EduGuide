package com.lama.roadmap.repository;

import com.lama.roadmap.model.StepProgress;
import com.lama.roadmap.model.User;
import com.lama.roadmap.model.Roadmap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StepProgressRepository extends JpaRepository<StepProgress, Long> {
	List<StepProgress> findByStudentAndRoadmap(User student, Roadmap roadmap);
	
	Optional<StepProgress> findTopByStudentOrderByCreatedAtDesc(User student);
	

    Optional<StepProgress> findByStudentAndRoadmapAndStepTitle(
            User student,
            Roadmap roadmap,
            String stepTitle
    );
    
    

}