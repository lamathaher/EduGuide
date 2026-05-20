package com.lama.roadmap.controller;

import com.lama.roadmap.dto.ProgressSummaryResponse;
import com.lama.roadmap.dto.StepProgressRequest;
import com.lama.roadmap.model.StepProgress;
import com.lama.roadmap.service.StepProgressService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progress")
public class StepProgressController {

    private final StepProgressService progressService;

    public StepProgressController(StepProgressService progressService){
        this.progressService = progressService;
    }

    @PostMapping
    public StepProgress markCompleted(@RequestBody StepProgressRequest request){
        return progressService.markStepCompleted(request);
    }
    
    @GetMapping("/student/{studentId}/roadmap/{roadmapId}")
    public List<StepProgress> getProgress(
            @PathVariable Long studentId,
            @PathVariable Long roadmapId){

        return progressService.getStudentProgress(studentId, roadmapId);
    }
    
  
    @GetMapping("/summary/student/{studentId}/roadmap/{roadmapId}")
    public ProgressSummaryResponse getProgressSummary(
            @PathVariable Long studentId,
            @PathVariable Long roadmapId){

        return progressService.getProgressSummary(
                studentId,
                roadmapId
        );
    }
    
    @GetMapping("/last-opened/{studentId}")
    public ProgressSummaryResponse getLastOpenedRoadmapProgress(
            @PathVariable Long studentId){

        return progressService.getLastOpenedRoadmapProgress(studentId);
    }
   

}