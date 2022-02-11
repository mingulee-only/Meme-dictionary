package org.kh.meme.quiz.service.logic;

import java.util.List;

import org.kh.meme.quiz.domain.Quiz;
import org.kh.meme.quiz.domain.QuizBest;
import org.kh.meme.quiz.domain.QuizCh;
import org.kh.meme.quiz.domain.QuizFile;
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
	public List<Quiz> printAll(int quizNo) {
		List<Quiz> qList = qStore.selectAll(sqlSession, quizNo);
		return qList;
	}
	
	@Override
	public int writeQuiz(Quiz quiz, QuizFile quizFile) {
		int result = qStore.insertQuiz(sqlSession, quiz);
		if(result > 0) {
			qStore.insertQuizFile(sqlSession, quizFile);
		}
		return result;
	}

	@Override
	public int writeQuizM(QuizCh quizCh) {
		int result = qStore.insertQuizM(sqlSession, quizCh);
		return result;
	}

	@Override
	public int ScoreOne(String memberId) {
			int result = qStore.selectScore(sqlSession, memberId);
			return result;
	}

	@Override
	public int updateScore(QuizBest qBest) {
		int result = qStore.updateScore(sqlSession, qBest);
		return result;
	}





}
