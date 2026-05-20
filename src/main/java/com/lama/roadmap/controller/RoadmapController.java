package com.lama.roadmap.controller;

import com.lama.roadmap.dto.SaveRoadmapRequest;
import com.lama.roadmap.dto.ChatRequest;
import com.lama.roadmap.dto.GenerateRoadmapRequest;
import com.lama.roadmap.dto.RoadmapAnalyticsResponse;
import com.lama.roadmap.dto.RoadmapResponse;
import com.lama.roadmap.model.Roadmap;
import com.lama.roadmap.service.RoadmapService;
import com.lama.roadmap.service.ResourceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roadmaps")
public class RoadmapController {

    private final RoadmapService roadmapService;
    private final ResourceService resourceService;

    public RoadmapController(RoadmapService roadmapService,
                             ResourceService resourceService) {
        this.roadmapService = roadmapService;
        this.resourceService = resourceService;
    }

    @PostMapping
    public Roadmap saveRoadmap(@Valid @RequestBody SaveRoadmapRequest request) {
        return roadmapService.saveRoadmap(request);
    }

    @GetMapping("/user/{userId}")
    public java.util.List<RoadmapResponse> getUserRoadmaps(@PathVariable Long userId) {
        return roadmapService.getUserRoadmaps(userId);
    }

    @GetMapping("/{roadmapId}")
    public RoadmapResponse getRoadmapById(@PathVariable Long roadmapId) {
        return roadmapService.getRoadmapById(roadmapId);
    }

    @DeleteMapping("/{roadmapId}")
    public void deleteRoadmap(@PathVariable Long roadmapId) {
        roadmapService.deleteRoadmap(roadmapId);
    }

    @PutMapping("/{roadmapId}")
    public RoadmapResponse updateRoadmap(
            @PathVariable Long roadmapId,
            @Valid @RequestBody SaveRoadmapRequest request) {
        return roadmapService.updateRoadmap(roadmapId, request);
    }

    @PostMapping("/generate")
    public RoadmapResponse generateRoadmap(
            @RequestBody GenerateRoadmapRequest request) {
        if (request.getUserId() == null || request.getLearningPath() == null) {
            throw new RuntimeException("Missing required fields");
        }
        return roadmapService.generateRoadmap(request);
    }

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody ChatRequest request) {

        String question = request.getMessage();

        String sessionId = request.getSessionId();
        if (sessionId == null || sessionId.isBlank()) {
            sessionId = "session-" + java.util.UUID.randomUUID();
        }

        // 🔥 لو في learningPath يعني هاي الرسالة الأخيرة — أضيفي الـ RAG
        if (request.getLearningPath() != null
                && !request.getLearningPath().isBlank()) {

            String resourcesText = resourceService
                    .getResourcesAsText(request.getLearningPath());

            question = "CONTEXT:\n\n" + resourcesText + "\n\n" + question;

            System.out.println("====== RAG INJECTED IN CHAT ======");
            System.out.println(resourcesText);
            System.out.println("==================================");
        }

        String response = roadmapService.callFlowise(question, sessionId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/open/{roadmapId}/user/{userId}")
    public void setLastOpenedRoadmap(
            @PathVariable Long roadmapId,
            @PathVariable Long userId) {
        roadmapService.setLastOpenedRoadmap(roadmapId, userId);
    }
    
    @GetMapping("/analytics")
    public RoadmapAnalyticsResponse getAnalytics() {
        return roadmapService.getRoadmapAnalytics();
    }
}