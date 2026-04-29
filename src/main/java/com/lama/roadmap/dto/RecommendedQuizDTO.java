package com.lama.roadmap.dto;

public class RecommendedQuizDTO {

    private Long id;
    private String title;
    private String description;
    private String path;
    private String level;
    private int progress;

    // ✅ Constructor
    public RecommendedQuizDTO(Long id, String title, String description,
                              String path, String level, int progress) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.path = path;
        this.level = level;
        this.progress = progress;
    }	

    // ✅ Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPath() {
        return path;
    }

    public String getLevel() {
        return level;
    }

    public int getProgress() {
        return progress;
    }

    // (اختياري) Setters إذا احتجتيهم
}