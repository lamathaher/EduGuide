package com.lama.roadmap.dto;

public class PerformanceNoteRequest {

    private Long assignmentId;
    private String type;
    private String noteText;

    public Long getAssignmentId() { return assignmentId; }
    public void setAssignmentId(Long assignmentId) { this.assignmentId = assignmentId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getNoteText() { return noteText; }
    public void setNoteText(String noteText) { this.noteText = noteText; }
}