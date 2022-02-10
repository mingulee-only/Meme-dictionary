package org.kh.meme.quiz.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class QuizController {
	
	@Autowired
	private QuizService qService;
	
	@ResponseBody
	@RequestMapping(value = "/quiz/getList.me", method = RequestMethod.GET)
	public String getMList(
			@RequestParam("quizNo") int quizNo) {
		List<Quiz> qList = qService.printAll(quizNo);
		if(!qList.isEmpty()) {
			Gson gson = new Gson();
			return gson.toJson(qList);
		}
		return null;
	}
	
	@RequestMapping(value = "/quiz/result.me", method = RequestMethod.POST)
	public String result(
			Model model,
			@RequestParam("quizNo")String[] quizNo
			,@RequestParam("userAnswer")String[] userAnswer
			,@RequestParam("score")int score
			) {
		
		model.addAttribute("quizNo", quizNo);
		model.addAttribute("userAnswer", userAnswer);
		model.addAttribute("score", score);
		
		return ".tiles/quiz/result";
	}
	
	@RequestMapping(value = "/quiz/random.me", method = RequestMethod.GET)
	public String random() {
		return ".tiles/quiz/random";
	}
	
	@ResponseBody
	@RequestMapping(value = "/quiz/getRandom.me", method = RequestMethod.GET
			)
	public String randomQuiz() {
		List<Quiz> qList = qService.random();
		if(!qList.isEmpty()) {
			Gson gson = new Gson();
			return gson.toJson(qList);
		}else {
			return "fail";
		}
	}
	
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
