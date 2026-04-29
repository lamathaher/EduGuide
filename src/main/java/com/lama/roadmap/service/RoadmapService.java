package com.lama.roadmap.service;

import com.lama.roadmap.dto.RoadmapResponse;
import com.lama.roadmap.dto.SaveRoadmapRequest;
import com.lama.roadmap.model.Roadmap;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.RoadmapRepository;
import com.lama.roadmap.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.*;

@Service
public class RoadmapService {

    private final RoadmapRepository roadmapRepository;
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public RoadmapService(RoadmapRepository roadmapRepository,
                          UserRepository userRepository,
                          NotificationService notificationService) {
        this.roadmapRepository = roadmapRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    // =========================
    // CONVERT TO DTO
    // =========================
    private RoadmapResponse convertToResponse(Roadmap roadmap) {

        RoadmapResponse response = new RoadmapResponse();

        response.setId(roadmap.getId());
        response.setUserId(roadmap.getUser().getId());
        response.setLearningPath(roadmap.getLearningPath());
        response.setRoadmapLength(roadmap.getRoadmapLength());
        response.setLearningStyle(roadmap.getLearningStyle());
        response.setWeeklyStudyTime(roadmap.getWeeklyStudyTime());
        response.setMainGoal(roadmap.getMainGoal());
        response.setConfidenceLevel(roadmap.getConfidenceLevel());
        response.setRoadmapContent(roadmap.getRoadmapContent());
        response.setCreatedAt(roadmap.getCreatedAt());

        return response;
    }

    // =========================
    // SAVE ROADMAP
    // =========================
    public Roadmap saveRoadmap(SaveRoadmapRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Roadmap roadmap = new Roadmap();

        roadmap.setUser(user);
        roadmap.setLearningPath(request.getLearningPath());
        roadmap.setRoadmapLength(request.getRoadmapLength());
        roadmap.setLearningStyle(request.getLearningStyle());
        roadmap.setWeeklyStudyTime(request.getWeeklyStudyTime());
        roadmap.setMainGoal(request.getMainGoal());
        roadmap.setConfidenceLevel(request.getConfidenceLevel());
        roadmap.setRoadmapContent(request.getRoadmapContent());

        Roadmap saved = roadmapRepository.save(roadmap);

        notificationService.createNotification(
                user.getId(),
                "Your roadmap is ready 🎯",
                "Start learning now and track your progress!",
                "ROADMAP",
                saved.getId()
        );

        return saved;
    }

    // =========================
    // BUILD QUESTION FOR AI
    // =========================
    private String buildPersonalizedQuestion(Roadmap roadmap) {

        if (roadmap == null) return "generate roadmap";

        return String.format(
                "generate roadmap\n\n" +
                "USER ANSWERS:\n" +
                "- Learning Path: %s\n" +
                "- Roadmap Length: %s\n" +
                "- Learning Style: %s\n" +
                "- Weekly Study Time: %s\n" +
                "- Main Goal: %s\n" +
                "- Confidence Level: %s\n\n" +
                "YOU MUST apply ALL personalization rules strictly based on these answers.",
                roadmap.getLearningPath() != null ? roadmap.getLearningPath() : "Not specified",
                roadmap.getRoadmapLength() != null ? roadmap.getRoadmapLength() : "Not specified",
                roadmap.getLearningStyle() != null ? roadmap.getLearningStyle() : "Not specified",
                roadmap.getWeeklyStudyTime() != null ? roadmap.getWeeklyStudyTime() : "Not specified",
                roadmap.getMainGoal() != null ? roadmap.getMainGoal() : "Not specified",
                roadmap.getConfidenceLevel() != null ? roadmap.getConfidenceLevel() : "Not specified"
        );
    }

    // =========================
    // GET USER ROADMAPS
    // =========================
    public java.util.List<RoadmapResponse> getUserRoadmaps(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return roadmapRepository.findByUser(user)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // =========================
    // GET BY ID
    // =========================
    public RoadmapResponse getRoadmapById(Long roadmapId) {

        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new RuntimeException("Roadmap not found"));

        return convertToResponse(roadmap);
    }

    // =========================
    // DELETE
    // =========================
    public void deleteRoadmap(Long roadmapId) {

        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new RuntimeException("Roadmap not found"));

        roadmapRepository.delete(roadmap);
    }

    // =========================
    // UPDATE
    // =========================
    public RoadmapResponse updateRoadmap(Long roadmapId, SaveRoadmapRequest request) {

        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new RuntimeException("Roadmap not found"));

        roadmap.setLearningPath(request.getLearningPath());
        roadmap.setRoadmapLength(request.getRoadmapLength());
        roadmap.setLearningStyle(request.getLearningStyle());
        roadmap.setWeeklyStudyTime(request.getWeeklyStudyTime());
        roadmap.setMainGoal(request.getMainGoal());
        roadmap.setConfidenceLevel(request.getConfidenceLevel());
        roadmap.setRoadmapContent(request.getRoadmapContent());

        Roadmap updated = roadmapRepository.save(roadmap);

        notificationService.createNotification(
                updated.getUser().getId(),
                "Roadmap updated 🔄",
                "Your roadmap has been updated successfully!",
                "ROADMAP",
                updated.getId()
        );

        return convertToResponse(updated);
    }

    // =========================
    // GENERATE ROADMAP (AI)
    // =========================
    public RoadmapResponse generateRoadmap(String question, String userId) {

        String flowId = "c6a24e7c-50a8-49db-9705-1bbaac5119fe";
        String url = "http://localhost:3000/api/v1/prediction/" + flowId;

        User user = userRepository.findById(Long.parseLong(userId))
                .orElseThrow(() -> new RuntimeException("User not found"));

        Roadmap lastRoadmap = roadmapRepository
                .findTopByUserOrderByCreatedAtDesc(user)
                .orElse(null);

        String personalizedQuestion =
                question + "\n\n" + buildPersonalizedQuestion(lastRoadmap);

        String aiText = callFlowise(personalizedQuestion, "user-" + userId);

        Roadmap roadmap = new Roadmap();
        roadmap.setUser(user);
        roadmap.setLearningPath("Generated Roadmap");
        roadmap.setRoadmapContent(aiText);

        Roadmap saved = roadmapRepository.save(roadmap);

        notificationService.createNotification(
                user.getId(),
                "AI Roadmap Generated 🤖",
                "Your personalized roadmap is ready!",
                "ROADMAP",
                saved.getId()
        );

        return convertToResponse(saved);
    }

    // =========================
    // CALL AI
    // =========================
    public String callFlowise(String question, String sessionId) {

        String flowId = "c6a24e7c-50a8-49db-9705-1bbaac5119fe";
        String url = "http://localhost:3000/api/v1/prediction/" + flowId;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("question", question);

        Map<String, String> config = new HashMap<>();
        config.put("sessionId", sessionId);

        body.put("overrideConfig", config);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response =
                restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

        Map<String, Object> responseBody = response.getBody();

        if (responseBody == null || responseBody.get("text") == null) {
            throw new RuntimeException("Flowise returned empty response");
        }

        return (String) responseBody.get("text");
    }

    // =========================
    // CONTINUE LEARNING
    // =========================
    public void setLastOpenedRoadmap(Long roadmapId, Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setLastOpenedRoadmapId(roadmapId);
        userRepository.save(user);
    }
}