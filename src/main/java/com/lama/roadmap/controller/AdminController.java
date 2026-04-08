package com.lama.roadmap.controller;
import jakarta.validation.Valid;

import com.lama.roadmap.dto.LoginRequest;
import com.lama.roadmap.dto.UserRequest;
import com.lama.roadmap.dto.UserResponse;
import com.lama.roadmap.model.Role;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.UserRepository;
import com.lama.roadmap.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/pending-instructors")
    public List<UserResponse> getPendingInstructors() {
        return userService.getPendingInstructors();
    }

    @PutMapping("/users/{id}/approve")
    public UserResponse approveInstructor(@PathVariable Long id) {
        return userService.approveInstructor(id);
    }
}

