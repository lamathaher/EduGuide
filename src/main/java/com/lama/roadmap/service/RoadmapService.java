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

    public RoadmapService(RoadmapRepository roadmapRepository,
                           UserRepository userRepository) {
        this.roadmapRepository = roadmapRepository;
        this.userRepository = userRepository;
    }
    
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

    public Roadmap saveRoadmap(SaveRoadmapRequest request) {

        // 1️⃣ نجيب اليوزر
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2️⃣ ننشئ roadmap جديدة
        Roadmap roadmap = new Roadmap();

        roadmap.setUser(user);
        roadmap.setLearningPath(request.getLearningPath());
        roadmap.setRoadmapLength(request.getRoadmapLength());
        roadmap.setLearningStyle(request.getLearningStyle());
        roadmap.setWeeklyStudyTime(request.getWeeklyStudyTime());
        roadmap.setMainGoal(request.getMainGoal());
        roadmap.setConfidenceLevel(request.getConfidenceLevel());
        roadmap.setRoadmapContent(request.getRoadmapContent());

        // 3️⃣ نحفظها
        return roadmapRepository.save(roadmap);
    }
    
    public java.util.List<RoadmapResponse> getUserRoadmaps(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return roadmapRepository.findByUser(user)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }
    
    public RoadmapResponse getRoadmapById(Long roadmapId) {

        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new RuntimeException("Roadmap not found"));

        return convertToResponse(roadmap);
    }
    
    
    public void deleteRoadmap(Long roadmapId) {

        Roadmap roadmap = roadmapRepository.findById(roadmapId)
                .orElseThrow(() -> new RuntimeException("Roadmap not found"));

        roadmapRepository.delete(roadmap);
    }
    
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

        return convertToResponse(updated);
    }
    
    public RoadmapResponse generateRoadmap(String question, String userId) {

        String flowId = "c6a24e7c-50a8-49db-9705-1bbaac5119fe";
        String url = "http://localhost:3000/api/v1/prediction/" + flowId;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = """
            {
                "question": "%s",
                "overrideConfig": { "sessionId": "user-%s" }
            }
            """.formatted(question, userId);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response =
                restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

        String aiText = (String) response.getBody().get("text");

        // هون منخزن بالـ DB
        User user = userRepository.findById(Long.parseLong(userId))
                .orElseThrow(() -> new RuntimeException("User not found"));

        Roadmap roadmap = new Roadmap();
        roadmap.setUser(user);
        roadmap.setLearningPath("AI Generated");
        roadmap.setRoadmapContent(aiText);

        Roadmap saved = roadmapRepository.save(roadmap);

        return convertToResponse(saved);
    }
    public String callFlowise(String question) {

        String url = "http://localhost:3000/api/v1/prediction/c6a24e7c-50a8-49db-9705-1bbaac5119fe";

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> body = new HashMap<>();
        body.put("question", question);

        Map<String, Object> override = new HashMap<>();
        override.put("sessionId", "user-1");

        body.put("overrideConfig", override);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);

        return response.getBody().get("text").toString();
    }
    public void setLastOpenedRoadmap(Long roadmapId, Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setLastOpenedRoadmapId(roadmapId);

        userRepository.save(user);
    }
    
}