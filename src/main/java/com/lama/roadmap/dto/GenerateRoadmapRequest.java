package com.lama.roadmap.dto;

//dto/GenerateRoadmapRequest.java
public class GenerateRoadmapRequest {

 private String userId;
 private String learningPath;
 private String roadmapLength;
 private String learningStyle;
 private String weeklyStudyTime;
 private String mainGoal;
 private String confidenceLevel;

 // Getters & Setters
 public String getUserId() { return userId; }
 public void setUserId(String userId) { this.userId = userId; }

 public String getLearningPath() { return learningPath; }
 public void setLearningPath(String learningPath) { this.learningPath = learningPath; }

 public String getRoadmapLength() { return roadmapLength; }
 public void setRoadmapLength(String roadmapLength) { this.roadmapLength = roadmapLength; }

 public String getLearningStyle() { return learningStyle; }
 public void setLearningStyle(String learningStyle) { this.learningStyle = learningStyle; }

 public String getWeeklyStudyTime() { return weeklyStudyTime; }
 public void setWeeklyStudyTime(String weeklyStudyTime) { this.weeklyStudyTime = weeklyStudyTime; }

 public String getMainGoal() { return mainGoal; }
 public void setMainGoal(String mainGoal) { this.mainGoal = mainGoal; }

 public String getConfidenceLevel() { return confidenceLevel; }
 public void setConfidenceLevel(String confidenceLevel) { this.confidenceLevel = confidenceLevel; }
}