package org.kh.meme.quiz.controller;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.meme.quiz.domain.Quiz;
import org.kh.meme.quiz.domain.QuizCh;
import org.kh.meme.quiz.service.QuizService;
import org.kh.meme.rank.domain.BoardRank;
import org.kh.meme.rank.domain.MemeRank;
import org.kh.meme.rank.domain.QuizRank;
import org.kh.meme.rank.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;


@Controller
public class QuizController {
	
	@Autowired
	private QuizService qService;
	
	@Autowired
	private RankService rService;
	
	
	//퀴즈 랜덤으로 가져오기
	@ResponseBody
	@RequestMapping(value = "/quiz/getList.me", method = RequestMethod.GET)
	public void getMList(
			@RequestParam("quizNo") int quizNo
			,HttpServletResponse response) throws Exception {
		
		List<Quiz> qList = qService.printAll(quizNo);
		response.setCharacterEncoding("utf-8");
		if(!qList.isEmpty()) {
			Gson gson = new Gson();
			gson.toJson(qList, response.getWriter());
		}
	}
	
	//퀴즈 결과
	@RequestMapping(value = "/quiz/result.me", method = RequestMethod.POST)
	public String result(Model model
			,@RequestParam("userAnswer")String[] userAnswer
			,@RequestParam("quizQuest")String[] quizQuest
			,@RequestParam("quizAnswer")String[] quizAnswer
			,@RequestParam("quizCh1")String[] quizCh1
			,@RequestParam("quizCh2")String[] quizCh2
			,@RequestParam("quizCh3")String[] quizCh3
			,@RequestParam("quizCh4")String[] quizCh4
			,@RequestParam("quizNo")String[] quizNo
			,@RequestParam("score")String score) {
		

		//랭킹
		model.addAttribute("rankmain", "quiz");
		List<MemeRank> memeRankList = rService.printMemeRank();
		List<BoardRank> boardPushRankList = rService.printBoardPushRank();
		List<BoardRank> boardFreeRankList = rService.printBoardFreeRank();
		List<QuizRank> quizRankList = rService.printQuizRank();
 
		
		
		model.addAttribute("quizQuest", quizQuest);
		model.addAttribute("userAnswer", userAnswer);
		model.addAttribute("quizAnswer", quizAnswer);
		model.addAttribute("quizCh1", quizCh1);
		model.addAttribute("quizCh2", quizCh2);
		model.addAttribute("quizCh3", quizCh3);
		model.addAttribute("quizCh4", quizCh4);
		model.addAttribute("quizNo", quizNo);
		model.addAttribute("score", score);

		//랭킹
		model.addAttribute("memeRankList", memeRankList);
		model.addAttribute("boardPushRankList", boardPushRankList);
		model.addAttribute("boardFreeRankList", boardFreeRankList);
		model.addAttribute("quizRankList", quizRankList);
		
		return ".tiles/quiz/result";
	}
	
	//랜덤 퀴즈
	@RequestMapping(value = "/quiz/random.me", method = RequestMethod.GET)
	public String random( Model model ) {
		
		//랭킹
		model.addAttribute("rankmain", "quiz");
		List<MemeRank> memeRankList = rService.printMemeRank();
		List<BoardRank> boardPushRankList = rService.printBoardPushRank();
		List<BoardRank> boardFreeRankList = rService.printBoardFreeRank();
		List<QuizRank> quizRankList = rService.printQuizRank();
		
				
				
		//랭킹
		model.addAttribute("memeRankList", memeRankList);
		model.addAttribute("boardPushRankList", boardPushRankList);
		model.addAttribute("boardFreeRankList", boardFreeRankList);
		model.addAttribute("quizRankList", quizRankList);
		
		return ".tiles/quiz/random";
	}
	
	@ResponseBody
	@RequestMapping(value = "/quiz/getRandom.me", method = RequestMethod.GET)
	public String randomQuiz() {
		List<Quiz> qList = qService.random();
		if(!qList.isEmpty()) {
			Gson gson = new Gson();
			return gson.toJson(qList);
		}else {
			return "fail";
		}
	}
	
	
	//퀴즈만들기
	@RequestMapping(value = "/quiz/writeView.me", method = RequestMethod.GET)
	public String quizWriteView(Model model) {

		//랭킹
		model.addAttribute("rankmain", "quiz");
		List<MemeRank> memeRankList = rService.printMemeRank();
		List<BoardRank> boardPushRankList = rService.printBoardPushRank();
		List<BoardRank> boardFreeRankList = rService.printBoardFreeRank();
		List<QuizRank> quizRankList = rService.printQuizRank();
		

		//랭킹
		model.addAttribute("memeRankList", memeRankList);
		model.addAttribute("boardPushRankList", boardPushRankList);
		model.addAttribute("boardFreeRankList", boardFreeRankList);
		model.addAttribute("quizRankList", quizRankList);
		
		
		return ".tiles/quiz/write";
	}
	
	@RequestMapping(value = "/quiz/write.me", method = RequestMethod.POST)
	public String quizWrite(
			Model model
			,@ModelAttribute Quiz quiz
			,@ModelAttribute QuizCh quizCh
			,@RequestParam(value = "uploadFile", required = false) MultipartFile uploadFile
			, HttpServletRequest request) {
		
				
		try {
//			if(!uploadFile.getOriginalFilename().equals("")) {
//				// 실제 파일 저장
//				String renameFileName = saveFile(uploadFile, request);
//				
//				if(renameFileName != null) {
//					
//				}
//			}
			
			
			quiz.setMemberId("khuser01");
			int result = qService.writeQuiz(quiz);
			if(quiz.getQuizType().equals("M")) {
				qService.writeQuizM(quizCh);
			}
			if(result>0) {
				return "redirect:/quiz/writeView.me";
			} else {
				model.addAttribute("msg", "퀴즈등록 실패");
				return "common/errorPage";
			}
		}catch (Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	public String saveFile(MultipartFile uploadFile, HttpServletRequest request) {
		// 파일 경로
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\buploadFiles";
		// 폴더 선택
		File folder = new File(savePath);
		// 폴더 없으면 자동 생성
		if(!folder.exists()) {
			folder.mkdir();
		}
		// 파일명 변경(중복 되지 않도록, 년도 월 일 시 분 초)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String originalFileName = uploadFile.getOriginalFilename();
		String renameFileName = sdf.format(new Date(System.currentTimeMillis()))
				+"."+originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		String filePath = folder +"\\" + renameFileName;
		// 파일 저장
		try {
			uploadFile.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 파일명 리턴!
		return renameFileName;
	}
	
}
