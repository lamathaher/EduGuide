package com.lama.roadmap.controller;
import jakarta.validation.Valid;

import com.lama.roadmap.dto.LoginRequest;
import com.lama.roadmap.dto.RoadmapResponse;
import com.lama.roadmap.dto.UserRequest;
import com.lama.roadmap.dto.UserResponse;
import com.lama.roadmap.model.Role;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.UserRepository;
import com.lama.roadmap.service.UserService;
import com.lama.roadmap.service.RoadmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lama.roadmap.repository.RoadmapRepository;

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

    @PostMapping
    public UserResponse createUser(@Valid @RequestBody UserRequest request) {
        return userService.createUser(request);
    }
    
    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request) {
        return userService.login(request);
    }
    
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
}
