package com.lama.roadmap.controller;

import com.lama.roadmap.dto.SaveRoadmapRequest;
import com.lama.roadmap.dto.ChatRequest;
import com.lama.roadmap.dto.RoadmapResponse;
import com.lama.roadmap.model.Roadmap;
import com.lama.roadmap.service.RoadmapService;

import jakarta.validation.Valid;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roadmaps")
public class RoadmapController {

    private final RoadmapService roadmapService;

    public RoadmapController(RoadmapService roadmapService) {
        this.roadmapService = roadmapService;
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
    public RoadmapResponse generateRoadmap(@RequestBody Map<String, String> body) {

        String question = body.get("question");
        String userId = body.get("userId");

        if (question == null || userId == null) {
            throw new RuntimeException("Missing question or userId");
        }

        return roadmapService.generateRoadmap(question, userId);
    }

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@Valid @RequestBody ChatRequest request){

        String question = request.getMessage();
        String sessionId = request.getSessionId();

        if (sessionId == null || sessionId.isBlank()) {
            sessionId = "session-" + java.util.UUID.randomUUID();
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
}