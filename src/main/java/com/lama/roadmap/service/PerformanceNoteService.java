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
    private final NotificationService notificationService;

    public PerformanceNoteService(PerformanceNoteRepository noteRepository,
                                  InstructorAssignmentRepository assignmentRepository,
                                  NotificationService notificationService) {
        this.noteRepository = noteRepository;
        this.assignmentRepository = assignmentRepository;
        this.notificationService = notificationService;
    }

    // ✅ ADD NOTE
    public PerformanceNote addNote(PerformanceNoteRequest request) {

        InstructorAssignment assignment = assignmentRepository.findById(request.getAssignmentId())
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        User student = assignment.getStudent(); // ✅ لازم قبل الإشعار

        // ✨ تجهيز النص
        String content = request.getNoteText() != null ? request.getNoteText() : "";
        String preview = content.length() > 40 ? content.substring(0, 40) + "..." : content;

        // ✨ تحديد نوع النوت
        String noteType = request.getType();

        String label;
        switch (noteType) {
            case "QUIZ_FEEDBACK":
                label = "Quiz Feedback 📝";
                break;
            case "PROGRESS":
                label = "Progress Update 📈";
                break;
            default:
                label = "Instructor Note 💬";
        }

        // ✅ إنشاء النوت
        PerformanceNote note = new PerformanceNote();
        note.setAssignment(assignment);
        note.setType(request.getType());
        note.setNoteText(request.getNoteText());
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());

        PerformanceNote savedNote = noteRepository.save(note);

        // 🔔 إشعار واحد فقط (صح)
        notificationService.createNotification(
                student.getId(),
                label,                  // 👈 العنوان حسب النوع
                preview,                // 👈 نص مختصر
                "NOTE",                 // 👈 نوع الإشعار
                assignment.getId()      // 👈 مهم: يفتح صفحة النوت/الشات
        );

        return savedNote;
    }

    // ✅ GET NOTES
    public List<PerformanceNote> getNotes(Long assignmentId) {

        InstructorAssignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        return noteRepository.findByAssignmentOrderByCreatedAtDesc(assignment);
    }
}