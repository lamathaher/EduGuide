package com.lama.roadmap.dto;

public class ResumeQuizDTO {

    private Long quizId;
    private int progress;
    private int nextQuestionIndex;

    public ResumeQuizDTO(Long quizId, int progress, int nextQuestionIndex) {
        this.quizId = quizId;
        this.progress = progress;
        this.nextQuestionIndex = nextQuestionIndex;
    }

    public Long getQuizId() { return quizId; }
    public int getProgress() { return progress; }
    public int getNextQuestionIndex() { return nextQuestionIndex; }
}