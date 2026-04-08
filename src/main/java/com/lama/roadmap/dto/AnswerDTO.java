package com.lama.roadmap.dto;

import lombok.Data;

@Data
public class AnswerDTO {
    private Long questionId;
    private String answer;
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
    
    
}