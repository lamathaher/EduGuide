package com.lama.roadmap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "roadmaps")
public class Roadmap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many roadmaps belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String learningPath;
    private String roadmapLength;
    private String learningStyle;
    private String weeklyStudyTime;
    private String mainGoal;
    private String confidenceLevel;

    @Column(columnDefinition = "TEXT")
    private String roadmapContent; // JSON stored as String

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLearningPath() {
        return learningPath;
    }

    public void setLearningPath(String learningPath) {
        this.learningPath = learningPath;
    }

    public String getRoadmapLength() {
        return roadmapLength;
    }

    public void setRoadmapLength(String roadmapLength) {
        this.roadmapLength = roadmapLength;
    }

    public String getLearningStyle() {
        return learningStyle;
    }

    public void setLearningStyle(String learningStyle) {
        this.learningStyle = learningStyle;
    }

    public String getWeeklyStudyTime() {
        return weeklyStudyTime;
    }

    public void setWeeklyStudyTime(String weeklyStudyTime) {
        this.weeklyStudyTime = weeklyStudyTime;
    }

    public String getMainGoal() {
        return mainGoal;
    }

    public void setMainGoal(String mainGoal) {
        this.mainGoal = mainGoal;
    }

    public String getConfidenceLevel() {
        return confidenceLevel;
    }

    public void setConfidenceLevel(String confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }

    public String getRoadmapContent() {
        return roadmapContent;
    }

    public void setRoadmapContent(String roadmapContent) {
        this.roadmapContent = roadmapContent;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}