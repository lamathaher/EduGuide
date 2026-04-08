package com.lama.roadmap.repository;

import com.lama.roadmap.model.StepProgress;
import com.lama.roadmap.model.User;
import com.lama.roadmap.model.Roadmap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StepProgressRepository extends JpaRepository<StepProgress, Long> {

    Optional<StepProgress> findByStudentAndRoadmapAndStepTitle(
            User student,
            Roadmap roadmap,
            String stepTitle
    );

}