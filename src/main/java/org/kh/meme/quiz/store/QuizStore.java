package org.kh.meme.quiz.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.quiz.domain.Quiz;
import org.kh.meme.quiz.domain.QuizCh;
import org.mybatis.spring.SqlSessionTemplate;

public interface QuizStore {

	int insertQuiz(SqlSession session, Quiz quiz);

	int insertQuizM(SqlSession session, QuizCh quizCh);

}
