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

    private String status; // active | dropped_by_instructor | dropped_by_student

    private LocalDateTime assignedAt;

    private LocalDateTime endedAt;

    private LocalDateTime updatedAt;

    public InstructorAssignment() {}

    @PrePersist
    public void prePersist(){
        assignedAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        status = "active";
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = LocalDateTime.now();
    }

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

	public void setStatus(String status) {
		this.status = status;
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

}