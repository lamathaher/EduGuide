
package com.lama.roadmap.dto;

public class ProgressSummaryResponse {

    private int completedSteps;
    private int totalSteps;
    private double progressPercentage;

    public ProgressSummaryResponse(
            int completedSteps,
            int totalSteps,
            double progressPercentage) {

        this.completedSteps = completedSteps;
        this.totalSteps = totalSteps;
        this.progressPercentage = progressPercentage;
    }

    public int getCompletedSteps() {
        return completedSteps;
    }

    public void setCompletedSteps(int completedSteps) {
        this.completedSteps = completedSteps;
    }

    public int getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(int totalSteps) {
        this.totalSteps = totalSteps;
    }

    public double getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }
}
