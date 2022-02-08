package org.kh.meme.quiz.controller;

import org.kh.meme.quiz.domain.Quiz;
import org.kh.meme.quiz.domain.QuizCh;
import org.kh.meme.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {
	
	@Autowired
	private QuizService qService;
	
	@RequestMapping(value = "/quiz/writeView.me", method = RequestMethod.GET)
	public String quizWriteView() {
		return ".tiles/quiz/write";
	}
	
	@RequestMapping(value = "/quiz/write.me", method = RequestMethod.GET)
	public String quizWrite(
			Model model
			,@ModelAttribute Quiz quiz
			,@ModelAttribute QuizCh quizCh) {
		try {
			quiz.setMemberId("khuser01");
			int result = qService.writeQuiz(quiz);
			if(quiz.getQuizType().equals("M")) {
				qService.writeQuizM(quizCh);
			}
			if(result>0) {
				return ".tiles/quiz/write";
			} else {
				model.addAttribute("msg", "퀴즈등록 실패");
				return "common/errorPage";
			}
		}catch (Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
}
