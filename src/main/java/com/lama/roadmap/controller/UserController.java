package com.lama.roadmap.controller;

import jakarta.validation.Valid;

import com.lama.roadmap.dto.LoginRequest;
import com.lama.roadmap.dto.RoadmapResponse;
import com.lama.roadmap.dto.UserRequest;
import com.lama.roadmap.dto.UserResponse;
import com.lama.roadmap.model.ExpertiseField;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.UserRepository;
import com.lama.roadmap.service.UserService;
import com.lama.roadmap.service.RoadmapService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final RoadmapService roadmapService;

    public UserController(UserService userService,
                          UserRepository userRepository,
                          RoadmapService roadmapService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roadmapService = roadmapService;
    }

    // =========================
    // CREATE USER
    // =========================
    @PostMapping
    public ResponseEntity<Map<String, Object>> createUser(@Valid @RequestBody UserRequest request) {

        UserResponse user = userService.createUser(request);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "User created successfully");
        response.put("id", user.getId());
        response.put("fullName", user.getFullName());
        response.put("email", user.getEmail());
        response.put("role", user.getRole());

        return ResponseEntity.ok(response);
    }

    // =========================
    // LOGIN (FIXED 🔥)
    // =========================
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody LoginRequest request) {

        User user = userService.login(request);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("id", user.getId());
        response.put("fullName", user.getFullName()); // 🔥 ا
        response.put("email", user.getEmail());
        response.put("role", user.getRole());

        return ResponseEntity.ok(response);
    }

    // =========================
    // CONTINUE LEARNING
    // =========================
    @GetMapping("/{userId}/continue")
    public RoadmapResponse getContinueLearning(@PathVariable Long userId){

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Long roadmapId = user.getLastOpenedRoadmapId();

        if(roadmapId == null){
            throw new RuntimeException("No roadmap opened yet");
        }

        return roadmapService.getRoadmapById(roadmapId);
    }
    
    @GetMapping("/instructors")
    public List<UserResponse> getByField(@RequestParam String field){

        ExpertiseField f = ExpertiseField.valueOf(field.toUpperCase());

        return userService.getInstructorsByField(f);
    }
    
    @GetMapping("/instructors/top")
    public List<UserResponse> getTopInstructors(){
        return userService.getTopInstructors();
    }
    
    @GetMapping("/instructors/all")
    public List<UserResponse> getAllInstructors(){
        return userService.getAllInstructors();
    }
    
    
}