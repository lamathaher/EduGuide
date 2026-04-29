package com.lama.roadmap.service;

import com.lama.roadmap.model.InstructorAssignment;
import com.lama.roadmap.model.Message;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.InstructorAssignmentRepository;
import com.lama.roadmap.repository.MessageRepository;
import com.lama.roadmap.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorAssignmentService {

    private final InstructorAssignmentRepository assignmentRepository;
    private final UserRepository userRepository;
    private final NotificationService notificationService;
    private final MessageRepository messageRepository;

    public InstructorAssignmentService(
            InstructorAssignmentRepository assignmentRepository,
            UserRepository userRepository,
            NotificationService notificationService,
            MessageRepository messageRepository) {

        this.assignmentRepository = assignmentRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
        this.messageRepository = messageRepository;
    }

    // =========================
    // CREATE REQUEST (PENDING)
    // =========================
    public InstructorAssignment createRequest(Long studentId, Long instructorId){

        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        User instructor = userRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        InstructorAssignment assignment = new InstructorAssignment();
        assignment.setStudent(student);
        assignment.setInstructor(instructor);

        // ✅ أهم تعديل
        assignment.setStatus("PENDING");
        assignment.setActive(false);

        return assignmentRepository.save(assignment);
    }

    // =========================
    // APPROVE REQUEST
    // =========================
    public InstructorAssignment approveRequest(Long assignmentId){

        InstructorAssignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        User instructor = assignment.getInstructor();

        // ✅ 1. check max students
        int MAX_STUDENTS = 5;

        long currentStudents = assignmentRepository
                .findByInstructor(instructor)
                .stream()
                .filter(InstructorAssignment::isActive)
                .count();

        if(currentStudents >= MAX_STUDENTS){
            throw new RuntimeException("Instructor already has maximum students");
        }

        // ✅ 2. approve
        assignment.setStatus("APPROVED");
        assignment.setActive(true);

        return assignmentRepository.save(assignment);
    }

    // =========================
    // REJECT REQUEST
    // =========================
    public InstructorAssignment rejectRequest(Long assignmentId, String note){

        InstructorAssignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        assignment.setStatus("REJECTED");
        assignment.setActive(false);
        assignment.setNote(note); // لازم يكون موجود بالموديل

        return assignmentRepository.save(assignment);
    }

    // =========================
    // GET DATA
    // =========================
    public List<InstructorAssignment> getInstructorStudents(Long instructorId) {
        User instructor = userRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        return assignmentRepository.findByInstructor(instructor);
    }

    public List<InstructorAssignment> getStudentInstructor(Long studentId) {
        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return assignmentRepository.findByStudent(student);
    }

    // =========================
    // DROP ASSIGNMENT
    // =========================
    public InstructorAssignment dropAssignment(Long assignmentId, String droppedBy) {

        InstructorAssignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        if(droppedBy.equals("instructor")){
            assignment.setStatus("dropped_by_instructor");
        } else {
            assignment.setStatus("dropped_by_student");
        }

        assignment.setEndedAt(java.time.LocalDateTime.now());
        assignment.setActive(false);

        InstructorAssignment updated = assignmentRepository.save(assignment);

        // system message
        Message systemMessage = new Message();
        systemMessage.setAssignment(updated);
        systemMessage.setContent("This conversation has been closed");
        systemMessage.setType(Message.MessageType.SYSTEM);

        messageRepository.save(systemMessage);

        // receiver
        User receiver = droppedBy.equals("instructor")
                ? assignment.getStudent()
                : assignment.getInstructor();

        // 🔔 Notification
        notificationService.createNotification(
                receiver.getId(),
                "Mentorship ended ⚠️",
                "The mentorship assignment has been closed.",
                "INSTRUCTOR",
                updated.getId()
        );

        return updated;
    }
}