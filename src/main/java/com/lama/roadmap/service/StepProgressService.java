package com.lama.roadmap.service;

import com.lama.roadmap.dto.StepProgressRequest;
import com.lama.roadmap.model.*;
import com.lama.roadmap.repository.*;
import org.springframework.stereotype.Service;
import com.lama.roadmap.dto.ProgressSummaryResponse;

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

    // ✅ بدل String
    progress.setStatus(StepStatus.COMPLETED);

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


public ProgressSummaryResponse getProgressSummary(
        Long studentId,
        Long roadmapId){

    User student = userRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));

    Roadmap roadmap = roadmapRepository.findById(roadmapId)
            .orElseThrow(() -> new RuntimeException("Roadmap not found"));

    List<StepProgress> completedSteps =
            progressRepository.findByStudentAndRoadmap(student, roadmap);

    int completed = completedSteps.size();

    // مؤقتًا نحط total ثابت
    // بعدين ممكن تجيبيه من roadmap parsing
    int total = 10;

    double percentage = 0;

    if(total > 0){
        percentage = ((double) completed / total) * 100;
    }

    return new ProgressSummaryResponse(
            completed,
            total,
            Math.round(percentage)
    );
}

public ProgressSummaryResponse getLastOpenedRoadmapProgress(Long studentId){

    User student = userRepository.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));

    Long roadmapId = student.getLastOpenedRoadmapId();

    // إذا ما فتح أي roadmap قبل
    if(roadmapId == null){
        return new ProgressSummaryResponse(0, 0, 0);
    }

    // استخدم الدالة الموجودة أصلاً
    return getProgressSummary(studentId, roadmapId);
}


}
