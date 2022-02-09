package org.kh.meme.quiz.service.logic;

import java.util.List;

import org.kh.meme.quiz.domain.Quiz;
import org.kh.meme.quiz.domain.QuizCh;
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
	public List<Quiz> random() {
		List<Quiz> qList = qStore.selectRandom(sqlSession);
		return qList;
	}
	
	@Override
	public int writeQuiz(Quiz quiz) {
		int result = qStore.insertQuiz(sqlSession, quiz);
		return result;
	}

	@Override
	public int writeQuizM(QuizCh quizCh) {
		int result = qStore.insertQuizM(sqlSession, quizCh);
		return result;
	}

	@Override
	public List<QuizCh> printAll(int quizNo) {
		List<QuizCh> chList = qStore.selectAllM(sqlSession, quizNo);
		return chList;
	}


}
