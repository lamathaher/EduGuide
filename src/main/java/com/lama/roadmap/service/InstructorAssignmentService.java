package com.lama.roadmap.service;

import com.lama.roadmap.model.InstructorAssignment;
import com.lama.roadmap.model.User;
import com.lama.roadmap.repository.InstructorAssignmentRepository;
import com.lama.roadmap.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorAssignmentService {

    private final InstructorAssignmentRepository assignmentRepository;
    private final UserRepository userRepository;
    private final NotificationService notificationService;

    public InstructorAssignmentService(InstructorAssignmentRepository assignmentRepository,
                                       UserRepository userRepository,
                                       NotificationService notificationService) {

        this.assignmentRepository = assignmentRepository;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public InstructorAssignment assignInstructor(Long studentId, Long instructorId){

        User student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        User instructor = userRepository.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        InstructorAssignment assignment = new InstructorAssignment();

        assignment.setStudent(student);
        assignment.setInstructor(instructor);

        InstructorAssignment savedAssignment = assignmentRepository.save(assignment);

        // إنشاء Notification للطالب
        notificationService.createNotification(
                student.getId(),
                "Instructor Assigned",
                "You have been assigned to instructor " + instructor.getFullName(),
                "assignment",
                savedAssignment.getId()
        );

        return savedAssignment;
    }

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

    public InstructorAssignment dropAssignment(Long assignmentId, String droppedBy) {

        InstructorAssignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        if(droppedBy.equals("instructor")){
            assignment.setStatus("dropped_by_instructor");
        } else {
            assignment.setStatus("dropped_by_student");
        }

        assignment.setEndedAt(java.time.LocalDateTime.now());

        InstructorAssignment updated = assignmentRepository.save(assignment);

        // إنشاء Notification للطرف الآخر
        User receiver;

        if(droppedBy.equals("instructor")){
            receiver = assignment.getStudent();
        } else {
            receiver = assignment.getInstructor();
        }

        notificationService.createNotification(
                receiver.getId(),
                "Assignment Ended",
                "The mentorship assignment has been ended.",
                "assignment",
                updated.getId()
        );

        return updated;
    }

}