package org.kh.meme.board.controller;

import java.util.List;

import org.kh.meme.board.domain.Board;
import org.kh.meme.board.service.BoardService;
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
public class BoardController {

	@Autowired
	private BoardService bService;
	
	@Autowired
	private RankService rService;

	@RequestMapping(value="/boardtest", method=RequestMethod.GET)
	public String boardTestList() {
		return "/board/boardlist";
	}
	
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public String boardranklist(Model model) {
		model.addAttribute("page", "board");
		//게시판
		List<Board> boardAllList = bService.printAllBoard();
		
		//랭킹
		List<MemeRank> memeRankList = rService.printMemeRank();
		List<BoardRank> boardPushRankList = rService.printBoardPushRank();
		List<BoardRank> boardFreeRankList = rService.printBoardFreeRank();
		List<QuizRank> quizRankList = rService.printQuizRank();
		
		if(!boardAllList.isEmpty() && !memeRankList.isEmpty() && !boardPushRankList.isEmpty() && !boardFreeRankList.isEmpty() && !quizRankList.isEmpty()) {
			//게시판
			model.addAttribute("boardAllList", boardAllList);
			
			//랭킹
			model.addAttribute("memeRankList", memeRankList);
			model.addAttribute("boardPushRankList", boardPushRankList);
			model.addAttribute("boardFreeRankList", boardFreeRankList);
			model.addAttribute("quizRankList", quizRankList);
			return ".tiles/board/list";
		} else {
			//일단 error 나누어서 안 적음, 필요하면 적기
			model.addAttribute("msg", "랭킹 조회 실패");
			return "error";
		}
		
	}
}
