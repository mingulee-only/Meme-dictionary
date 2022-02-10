package org.kh.meme.meme.controller;

import java.util.List;

import org.kh.meme.rank.domain.BoardRank;
import org.kh.meme.rank.domain.MemeRank;
import org.kh.meme.rank.domain.QuizRank;
import org.kh.meme.rank.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemeController {

	@Autowired
	private RankService rService;
	
//	@RequestMapping(value="/meme", method = RequestMethod.GET)
//	public String memelist(Model model) {
//		model.addAttribute("page", "meme");
//		return ".tiles/meme/list";
//	}
	
	@RequestMapping(value="/meme", method = RequestMethod.GET)
	public String memeranklist(Model model) {
		model.addAttribute("rankmain", "meme");
		List<MemeRank> memeRankList = rService.printMemeRank();
		List<BoardRank> boardPushRankList = rService.printBoardPushRank();
		List<BoardRank> boardFreeRankList = rService.printBoardFreeRank();
		
		List<QuizRank> quizRankList = rService.printQuizRank();
		if(!memeRankList.isEmpty() && !boardPushRankList.isEmpty() && !boardFreeRankList.isEmpty() && !quizRankList.isEmpty()) {
			model.addAttribute("memeRankList", memeRankList);
			model.addAttribute("boardPushRankList", boardPushRankList);
			model.addAttribute("boardFreeRankList", boardFreeRankList);
			model.addAttribute("quizRankList", quizRankList);
			return ".tiles/meme/list";
		} else {
			//일단 error 나누어서 안 적음, 필요하면 적기
			model.addAttribute("msg", "랭킹 조회 실패");
			return "error";
		}
		
	}
}
