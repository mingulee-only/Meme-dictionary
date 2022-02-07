package org.kh.meme.quiz.service.logic;

import org.kh.meme.quiz.domain.Quiz;
import org.kh.meme.quiz.service.QuizService;
import org.kh.meme.quiz.store.QuizStore;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizStore qStore;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int writeQuiz(Quiz quiz) {
		int result = qStore.insertQuiz(sqlSession, quiz);
		return result;
	}

}
