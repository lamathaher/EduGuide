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

    // active | dropped_by_instructor | dropped_by_student
    private String status;

    @Column(name = "is_active")
    private Boolean isActive = true; // ✅ مهم

    private LocalDateTime assignedAt;
    private LocalDateTime endedAt;
    private LocalDateTime updatedAt;

    
    public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAssignedAt(LocalDateTime assignedAt) {
		this.assignedAt = assignedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	private String note;
    public InstructorAssignment() {}

    @PrePersist
    public void prePersist(){
        assignedAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        // ❌ كان active
        // status = "active";

        // ✅ خليها PENDING
        status = "PENDING";

        isActive = false; // لسا ما انقبل
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = LocalDateTime.now();

        // ✅ sync بين status و isActive
        if(status != null && !status.equals("active")){
            isActive = false;
        }
    }

    // ===== getters & setters =====

    public Long getId() {
        return id;
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

        // ✅ بس لما يكون APPROVED يصير active
        if("APPROVED".equals(status)){
            this.isActive = true;
        } else {
            this.isActive = false;
        }
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
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
}