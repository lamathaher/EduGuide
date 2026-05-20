package com.lama.roadmap.dto;

public class AdminStatisticsResponse {

    private long totalUsers;
    private long activeStudents;
    private long activeInstructors;
    private long pendingInstructorApprovals;

    public AdminStatisticsResponse(
            long totalUsers,
            long activeStudents,
            long activeInstructors,
            long pendingInstructorApprovals) {

        this.totalUsers = totalUsers;
        this.activeStudents = activeStudents;
        this.activeInstructors = activeInstructors;
        this.pendingInstructorApprovals =
                pendingInstructorApprovals;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public long getActiveStudents() {
        return activeStudents;
    }

    public long getActiveInstructors() {
        return activeInstructors;
    }

    public long getPendingInstructorApprovals() {
        return pendingInstructorApprovals;
    }
}