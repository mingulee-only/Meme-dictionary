package org.kh.meme.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuizController {
	
	@RequestMapping(value = "/quiz/write", method = RequestMethod.GET)
	public String quizWriteView( ) {
		return ".tiles/quiz/write";
	}
}
