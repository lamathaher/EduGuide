package com.lama.roadmap.dto;

public class QuizCardDTO {

    private Long id;
    private String title;
    private String path;
    private String level;
    private int bestScore;
    private int attempts;
    private boolean completed;

    // Constructor
    public QuizCardDTO(Long id, String title, String path, String level,
                       int bestScore, int attempts, boolean completed) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.level = level;
        this.bestScore = bestScore;
        this.attempts = attempts;
        this.completed = completed;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getPath() { return path; }
    public String getLevel() { return level; }
    public int getBestScore() { return bestScore; }
    public int getAttempts() { return attempts; }
    public boolean isCompleted() { return completed; }
}