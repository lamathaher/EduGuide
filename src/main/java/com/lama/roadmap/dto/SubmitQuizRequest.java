package com.lama.roadmap.dto;

import lombok.Data;

import java.util.List;

@Data
public class SubmitQuizRequest {
    private Long quizId;
    private Long studentId;
    private List<AnswerDTO> answers;
	public Long getQuizId() {
		return quizId;
	}
	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public List<AnswerDTO> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerDTO> answers) {
		this.answers = answers;
	}
}