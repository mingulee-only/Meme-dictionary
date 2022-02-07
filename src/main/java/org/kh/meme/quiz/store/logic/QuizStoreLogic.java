package org.kh.meme.quiz.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.quiz.domain.Quiz;
import org.kh.meme.quiz.domain.QuizCh;
import org.kh.meme.quiz.store.QuizStore;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuizStoreLogic implements QuizStore {

	@Override
	public int insertQuiz(SqlSession session, Quiz quiz) {
		int result = session.insert("QuizMapper.insertQuiz", quiz);
		return result;
	}

	@Override
	public int insertQuizM(SqlSession session, QuizCh quizCh) {
		int result = session.insert("QuizMapper.insertQuizM", quizCh);
		return result;
	}

}
