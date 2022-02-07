package org.kh.meme.quiz.domain;

import java.sql.Date;

public class Quiz {
	private int quizNo;
	private String quizType;
	private String quizQuest;
	private String quizAnswer;
	private String memberId;
	private Date quizDate;
	
	public Quiz() {}
	
	public int getQuizNo() {
		return quizNo;
	}
	public void setQuizNo(int quizNo) {
		this.quizNo = quizNo;
	}
	public String getQuizType() {
		return quizType;
	}
	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}
	public String getQuizQuest() {
		return quizQuest;
	}
	public void setQuizQuest(String quizQuest) {
		this.quizQuest = quizQuest;
	}
	public String getQuizAnswer() {
		return quizAnswer;
	}
	public void setQuizAnswer(String quizAnswer) {
		this.quizAnswer = quizAnswer;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getQuizDate() {
		return quizDate;
	}
	public void setQuizDate(Date quizDate) {
		this.quizDate = quizDate;
	}

	@Override
	public String toString() {
		return "Quiz [quizNo=" + quizNo + ", quizType=" + quizType + ", quizQuest=" + quizQuest + ", quizAnswer="
				+ quizAnswer + ", memberId=" + memberId + ", quizDate=" + quizDate + "]";
	}
	
	
}
