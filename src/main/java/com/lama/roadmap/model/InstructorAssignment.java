package com.lama.roadmap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "instructor_assignments")
public class InstructorAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private User instructor;

    // PENDING | APPROVED | dropped_by_instructor | dropped_by_student
    private String status;

    @Column(name = "is_active")
    private Boolean isActive;

    private LocalDateTime assignedAt;
    private LocalDateTime endedAt;
    private LocalDateTime updatedAt;

    private String note;

    public InstructorAssignment() {}

    // =========================
    // LIFECYCLE
    // =========================
    @PrePersist
    public void prePersist(){
        assignedAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        status = "PENDING";
        isActive = false; // لسا ما انقبل
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = LocalDateTime.now();
        // ❌ شلنا أي logic يغير isActive
    }

    // =========================
    // BUSINESS LOGIC (SINGLE SOURCE OF TRUTH)
    // =========================
    public void setStatus(String status) {
        this.status = status;

        // 🔥 المصدر الوحيد لتحديد active
        this.isActive = "APPROVED".equals(status);
    }

    // =========================
    // GETTERS & SETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    public String getStatus() {
        return status;
    }

    // ❗ ما بنحط setActive لحاله → ممنوع تضارب
    public Boolean isActive() {
        return isActive;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}