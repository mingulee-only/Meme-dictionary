package org.kh.meme.rank.domain;

import java.sql.Date;

public class QuizRank {
	private int memberId;
	private int quizBestScore;
	private Date quizBestDate;
	private int quizRank;
	
	public QuizRank() {
		
	}
	
	public QuizRank(int memberId, int quizBestScore, Date quizBestDate, int quizRank) {
		super();
		this.memberId = memberId;
		this.quizBestScore = quizBestScore;
		this.quizBestDate = quizBestDate;
		this.quizRank = quizRank;
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public int getQuizBestScore() {
		return quizBestScore;
	}


	public void setQuizBestScore(int quizBestScore) {
		this.quizBestScore = quizBestScore;
	}


	public Date getQuizBestDate() {
		return quizBestDate;
	}


	public void setQuizBestDate(Date quizBestDate) {
		this.quizBestDate = quizBestDate;
	}


	public int getQuizRank() {
		return quizRank;
	}


	public void setQuizRank(int quizRank) {
		this.quizRank = quizRank;
	}


	@Override
	public String toString() {
		return "QuizRank [memberId=" + memberId + ", quizBestScore=" + quizBestScore + ", quizBestDate=" + quizBestDate
				+ ", quizRank=" + quizRank + "]";
	}
	
	
}
