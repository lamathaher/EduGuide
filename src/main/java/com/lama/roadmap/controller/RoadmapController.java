package com.lama.roadmap.controller;

import com.lama.roadmap.dto.SaveRoadmapRequest;
import com.lama.roadmap.model.Roadmap;
import com.lama.roadmap.service.RoadmapService;
import jakarta.validation.Valid;
import com.lama.roadmap.model.User;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lama.roadmap.dto.RoadmapResponse;
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
        return roadmapService.generateRoadmap(body.get("question"), body.get("userId"));
    }
    
    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody Map<String,String> request){

        String question = request.get("message");

        String response = roadmapService.callFlowise(question);

        return ResponseEntity.ok(response);
    }
    @PutMapping("/open/{roadmapId}/user/{userId}")
    public void setLastOpenedRoadmap(
            @PathVariable Long roadmapId,
            @PathVariable Long userId) {

        roadmapService.setLastOpenedRoadmap(roadmapId, userId);
    }
}