package com.lama.roadmap.controller;

import com.lama.roadmap.model.InstructorAssignment;
import com.lama.roadmap.service.InstructorAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    private final InstructorAssignmentService assignmentService;

    public AssignmentController(InstructorAssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public InstructorAssignment createRequest(
            @RequestParam Long studentId,
            @RequestParam Long instructorId) {

        return assignmentService.createRequest(studentId, instructorId);
    }

    @GetMapping("/instructor/{id}")
    public List<InstructorAssignment> getInstructorStudents(@PathVariable Long id) {
        return assignmentService.getInstructorStudents(id);
    }

    @GetMapping("/student/{id}")
    public List<InstructorAssignment> getStudentInstructor(@PathVariable Long id) {
        return assignmentService.getStudentInstructor(id);
    }
    
    @PutMapping("/{id}/drop")
    public InstructorAssignment dropAssignment(
            @PathVariable Long id,
            @RequestParam String droppedBy){

        return assignmentService.dropAssignment(id, droppedBy);
    }

}