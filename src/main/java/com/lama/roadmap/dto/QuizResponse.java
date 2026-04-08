package com.lama.roadmap.dto;

import java.util.List;

public class QuizResponse {

    private Long id;
    private String title;
    private String path;
    private String level;
    private List<QuestionDTO> questions;

    // 🔥 constructor فاضي
    public QuizResponse() {
    }

    // 🔥 constructor كامل
    public QuizResponse(Long id, String title, String path,
                        String level, List<QuestionDTO> questions) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.level = level;
        this.questions = questions;
    }

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}