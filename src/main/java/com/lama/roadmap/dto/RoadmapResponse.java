package com.lama.roadmap.dto;

import java.time.LocalDateTime;

public class RoadmapResponse {

    private Long id;
    private Long userId;

    private String learningPath;
    private String roadmapLength;
    private String learningStyle;
    private String weeklyStudyTime;
    private String mainGoal;
    private String confidenceLevel;

    private String roadmapContent;
    private LocalDateTime createdAt;

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}