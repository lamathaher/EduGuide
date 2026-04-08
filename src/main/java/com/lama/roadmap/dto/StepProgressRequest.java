package com.lama.roadmap.dto;

public class StepProgressRequest {

    private Long studentId;

    private Long roadmapId;

    private String phaseTitle;

    private String stepTitle;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Long getRoadmapId() {
		return roadmapId;
	}

	public void setRoadmapId(Long roadmapId) {
		this.roadmapId = roadmapId;
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
    

}