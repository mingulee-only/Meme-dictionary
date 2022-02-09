package org.kh.meme.quiz.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.quiz.domain.Quiz;
import org.kh.meme.quiz.domain.QuizCh;

public interface QuizStore {

	public List<Quiz> selectRandom(SqlSession sqlSession);
	public int insertQuiz(SqlSession session, Quiz quiz);
	
	public int insertQuizM(SqlSession session, QuizCh quizCh);
	public List<QuizCh> selectAllM(SqlSession sqlSession, int quizNo);

}
