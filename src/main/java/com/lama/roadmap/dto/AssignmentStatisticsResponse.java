package com.lama.roadmap.dto;

public class AssignmentStatisticsResponse {
	private long activeMentorships;
	private long pendingRequests;
	private long droppedMentorships;
	private long instructorCapacityUsage;
	public AssignmentStatisticsResponse(long activeMentorships, long pendingRequests, long droppedMentorships,
			long instructorCapacityUsage) {
		super();
		this.activeMentorships = activeMentorships;
		this.pendingRequests = pendingRequests;
		this.droppedMentorships = droppedMentorships;
		this.instructorCapacityUsage = instructorCapacityUsage;
	}
	public long getActiveMentorships() {
		return activeMentorships;
	}
	public void setActiveMentorships(long activeMentorships) {
		this.activeMentorships = activeMentorships;
	}
	public long getPendingRequests() {
		return pendingRequests;
	}
	public void setPendingRequests(long pendingRequests) {
		this.pendingRequests = pendingRequests;
	}
	public long getDroppedMentorships() {
		return droppedMentorships;
	}
	public void setDroppedMentorships(long droppedMentorships) {
		this.droppedMentorships = droppedMentorships;
	}
	public long getInstructorCapacityUsage() {
		return instructorCapacityUsage;
	}
	public void setInstructorCapacityUsage(long instructorCapacityUsage) {
		this.instructorCapacityUsage = instructorCapacityUsage;
	}
	
	
}
