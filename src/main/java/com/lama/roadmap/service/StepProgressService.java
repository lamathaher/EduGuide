package com.lama.roadmap.service;

import com.lama.roadmap.dto.StepProgressRequest;
import com.lama.roadmap.model.*;
import com.lama.roadmap.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StepProgressService {

    private final StepProgressRepository progressRepository;
    private final UserRepository userRepository;
    private final RoadmapRepository roadmapRepository;
    private final NotificationService notificationService; // ✅ مهم

    public StepProgressService(
            StepProgressRepository progressRepository,
            UserRepository userRepository,
            RoadmapRepository roadmapRepository,
            NotificationService notificationService){

        this.progressRepository = progressRepository;
        this.userRepository = userRepository;
        this.roadmapRepository = roadmapRepository;
        this.notificationService = notificationService;
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

        StepProgress saved = progressRepository.save(progress);

        // ✅ تحديث النشاط (مهم للـ reminder)
        student.setLastActivityAt(LocalDateTime.now());
        userRepository.save(student);

        // 🔔 إشعار تقدم
        notificationService.createNotification(
                student.getId(),
                "Nice progress 📈",
                "You completed: " + request.getStepTitle(),
                "PROGRESS",
                roadmap.getId()
        );

        return saved;
    }
    
    public List<StepProgress> getStudentProgress(Long studentId, Long roadmapId){

        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new RuntimeException("Roadmap not found"));

        return progressRepository.findByStudentAndRoadmap(student, roadmap);
    }
}