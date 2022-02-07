package org.kh.meme.quiz.service;

import org.kh.meme.quiz.domain.Quiz;
import org.kh.meme.quiz.domain.QuizCh;

public interface QuizService {

	int writeQuiz(Quiz quiz);
	int writeQuizM(QuizCh quizCh);

}
