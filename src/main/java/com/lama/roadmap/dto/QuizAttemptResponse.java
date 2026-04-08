package com.lama.roadmap.dto;

public class QuizAttemptResponse {

    private int score;
    private int totalQuestions;
    private int attemptNumber;
    private String date;

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public int getTotalQuestions() { return totalQuestions; }
    public void setTotalQuestions(int totalQuestions) { this.totalQuestions = totalQuestions; }

    public int getAttemptNumber() { return attemptNumber; }
    public void setAttemptNumber(int attemptNumber) { this.attemptNumber = attemptNumber; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}