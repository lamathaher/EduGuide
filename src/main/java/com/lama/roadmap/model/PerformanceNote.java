package com.lama.roadmap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "performance_notes")
public class PerformanceNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private InstructorAssignment assignment;

    @ManyToOne
    @JoinColumn(name = "step_progress_id", nullable = true)
    private StepProgress stepProgress;

    private String type; // GENERAL / PROGRESS / QUIZ_FEEDBACK

    @Column(columnDefinition = "TEXT")
    private String noteText;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // getters & setters
    public Long getId() { return id; }

    public InstructorAssignment getAssignment() { return assignment; }
    public void setAssignment(InstructorAssignment assignment) { this.assignment = assignment; }

    public StepProgress getStepProgress() { return stepProgress; }
    public void setStepProgress(StepProgress stepProgress) { this.stepProgress = stepProgress; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getNoteText() { return noteText; }
    public void setNoteText(String noteText) { this.noteText = noteText; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}