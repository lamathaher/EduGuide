package com.lama.roadmap.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SaveRoadmapRequest {

    @NotNull
    private Long userId;

    @NotBlank
    private String learningPath;

    @NotBlank
    private String roadmapLength;

    @NotBlank
    private String learningStyle;

    @NotBlank
    private String weeklyStudyTime;

    @NotBlank
    private String mainGoal;

    @NotBlank
    private String confidenceLevel;

    @NotBlank
    private String roadmapContent;

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

    // getters & setters
}