package com.lama.roadmap.service;

import com.lama.roadmap.dto.StepProgressRequest;
import com.lama.roadmap.model.*;
import com.lama.roadmap.repository.*;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StepProgressService {

    private final StepProgressRepository progressRepository;
    private final UserRepository userRepository;
    private final RoadmapRepository roadmapRepository;

    public StepProgressService(
            StepProgressRepository progressRepository,
            UserRepository userRepository,
            RoadmapRepository roadmapRepository){

        this.progressRepository = progressRepository;
        this.userRepository = userRepository;
        this.roadmapRepository = roadmapRepository;
    }

    public StepProgress markStepCompleted(StepProgressRequest request){

        User student = userRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Roadmap roadmap = roadmapRepository.findById(request.getRoadmapId())
                .orElseThrow(() -> new RuntimeException("Roadmap not found"));

        Optional<StepProgress> existing =
                progressRepository.findByStudentAndRoadmapAndStepTitle(
                        student,
                        roadmap,
                        request.getStepTitle()
                );

        if(existing.isPresent()){
            return existing.get();
        }

        StepProgress progress = new StepProgress();

        progress.setStudent(student);
        progress.setRoadmap(roadmap);
        progress.setPhaseTitle(request.getPhaseTitle());
        progress.setStepTitle(request.getStepTitle());
        progress.setStatus("completed");

        return progressRepository.save(progress);
    }
}