package com.lama.roadmap.controller;

import com.lama.roadmap.dto.UserResponse;
import com.lama.roadmap.model.InstructorAssignment;
import com.lama.roadmap.service.UserService;
import com.lama.roadmap.service.InstructorAssignmentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;
    private final InstructorAssignmentService assignmentService;

    public AdminController(UserService userService,
                           InstructorAssignmentService assignmentService) {
        this.userService = userService;
        this.assignmentService = assignmentService;
    }

    // =========================
    // INSTRUCTOR APPROVAL
    // =========================
    @GetMapping("/pending-instructors")
    public List<UserResponse> getPendingInstructors() {
        return userService.getPendingInstructors();
    }

    @PutMapping("/users/{id}/approve")
    public UserResponse approveInstructor(@PathVariable Long id) {
        return userService.approveInstructor(id);
    }

    // =========================
    // ASSIGNMENT APPROVAL 🔥
    // =========================
    @PutMapping("/assignments/{id}/approve")
    public InstructorAssignment approveAssignment(@PathVariable Long id) {
        return assignmentService.approveRequest(id);
    }

    @PutMapping("/assignments/{id}/reject")
    public InstructorAssignment rejectAssignment(
            @PathVariable Long id,
            @RequestParam String note) {

        return assignmentService.rejectRequest(id, note);
        
    }
    
    
}