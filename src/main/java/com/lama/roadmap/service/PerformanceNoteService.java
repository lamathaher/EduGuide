package com.lama.roadmap.service;

import com.lama.roadmap.dto.PerformanceNoteRequest;
import com.lama.roadmap.model.*;
import com.lama.roadmap.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PerformanceNoteService {

    private final PerformanceNoteRepository noteRepository;
    private final InstructorAssignmentRepository assignmentRepository;
    private final NotificationService notificationService; // 🔥 جديد

    public PerformanceNoteService(PerformanceNoteRepository noteRepository,
                                  InstructorAssignmentRepository assignmentRepository,
                                  NotificationService notificationService) {
        this.noteRepository = noteRepository;
        this.assignmentRepository = assignmentRepository;
        this.notificationService = notificationService;
    }

    // ADD NOTE
    public PerformanceNote addNote(PerformanceNoteRequest request) {

        InstructorAssignment assignment = assignmentRepository.findById(request.getAssignmentId())
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        PerformanceNote note = new PerformanceNote();
        note.setAssignment(assignment);
        note.setType(request.getType());
        note.setNoteText(request.getNoteText());
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());

        PerformanceNote savedNote = noteRepository.save(note);

        // =========================
        // 🔔 NOTIFICATION
        // =========================

        User student = assignment.getStudent();

        String message = "New note from your instructor: " + request.getNoteText();

        notificationService.sendNotification(
                student.getId(),
                "New Performance Note",
                message,
                "NOTE",
                savedNote.getId()
        );

        return savedNote;
    }

    // GET NOTES
    public List<PerformanceNote> getNotes(Long assignmentId) {

        InstructorAssignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        return noteRepository.findByAssignmentOrderByCreatedAtDesc(assignment); // 🔥 مرتب
    }
}