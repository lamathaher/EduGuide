package com.lama.roadmap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "step_progress")
public class StepProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="roadmap_id")
    private Roadmap roadmap;

    @ManyToOne
    @JoinColumn(name="student_id")
    private User student;

    private String phaseTitle;

    private String stepTitle;

    private String status; // completed

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Roadmap getRoadmap() {
		return roadmap;
	}

	public void setRoadmap(Roadmap roadmap) {
		this.roadmap = roadmap;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public String getPhaseTitle() {
		return phaseTitle;
	}

	public void setPhaseTitle(String phaseTitle) {
		this.phaseTitle = phaseTitle;
	}

	public String getStepTitle() {
		return stepTitle;
	}

	public void setStepTitle(String stepTitle) {
		this.stepTitle = stepTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}