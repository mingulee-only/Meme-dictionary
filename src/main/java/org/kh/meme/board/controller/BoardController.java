package org.kh.meme.board.controller;

import java.util.List;

import org.kh.meme.board.domain.Board;
import org.kh.meme.board.service.BoardService;
import org.kh.meme.common.PageInfo;
import org.kh.meme.common.Pagination;
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
	
	@RequestMapping(value="/boarderror", method=RequestMethod.GET)
	public String boarderror() {
		return "/board/error";
	}
	

	@RequestMapping(value="/boardwrite", method=RequestMethod.GET)
	public String boardwritetest() {
		return "/board/write";
	}
	
	@RequestMapping(value="/boarddetail", method=RequestMethod.GET)
	public String boarddetailtest() {
		return "/board/boardDetailView";
	}
	

	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public String boardDetail( Model model
			, @RequestParam("boardNo") Integer boardNo) {
		

		//게시글 보기
		Board oneBoard = bService.printBoardOneByNo(boardNo);
		
		
		//랭킹
		model.addAttribute("rankmain", "board");
		List<MemeRank> memeRankList = rService.printMemeRank();
		List<BoardRank> boardPushRankList = rService.printBoardPushRank();
		List<BoardRank> boardFreeRankList = rService.printBoardFreeRank();
		List<QuizRank> quizRankList = rService.printQuizRank();
 
		
		if(oneBoard != null && !memeRankList.isEmpty() && !boardPushRankList.isEmpty() && !boardFreeRankList.isEmpty() && !quizRankList.isEmpty()) {
			//게시물
			model.addAttribute("oneBoard", oneBoard);
			
			//랭킹
			model.addAttribute("memeRankList", memeRankList);
			model.addAttribute("boardPushRankList", boardPushRankList);
			model.addAttribute("boardFreeRankList", boardFreeRankList);
			model.addAttribute("quizRankList", quizRankList);
			return ".tiles/board/detail";
		} else {
			//일단 error 나누어서 안 적음, 필요하면 적기
			model.addAttribute("msg", "게시글 조회 실패");
			return "error";
		}
		
		
	}
	
	
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String boardwrite( Model model) {
		

		//랭킹
		model.addAttribute("rankmain", "board");
		List<MemeRank> memeRankList = rService.printMemeRank();
		List<BoardRank> boardPushRankList = rService.printBoardPushRank();
		List<BoardRank> boardFreeRankList = rService.printBoardFreeRank();
		List<QuizRank> quizRankList = rService.printQuizRank();
 
		
		if(!memeRankList.isEmpty() && !boardPushRankList.isEmpty() && !boardFreeRankList.isEmpty() && !quizRankList.isEmpty()) {
		
			//랭킹
			model.addAttribute("memeRankList", memeRankList);
			model.addAttribute("boardPushRankList", boardPushRankList);
			model.addAttribute("boardFreeRankList", boardFreeRankList);
			model.addAttribute("quizRankList", quizRankList);
			return ".tiles/board/write";
		} else {
			//일단 error 나누어서 안 적음, 필요하면 적기
			model.addAttribute("msg", "랭킹 조회 실패");
			return "error";
		}
		
		
	}
	
	@RequestMapping(value="/board/register", method=RequestMethod.POST)
	public String boardRegister( Model model
			, @ModelAttribute Board board) {
		
		System.out.println(board);
		int result = bService.registerBoard(board);
		
		
		//랭킹
		model.addAttribute("rankmain", "board");
		List<MemeRank> memeRankList = rService.printMemeRank();
		List<BoardRank> boardPushRankList = rService.printBoardPushRank();
		List<BoardRank> boardFreeRankList = rService.printBoardFreeRank();
		List<QuizRank> quizRankList = rService.printQuizRank();
		
		
		if(result > 0 && !memeRankList.isEmpty() && !boardPushRankList.isEmpty() && !boardFreeRankList.isEmpty() && !quizRankList.isEmpty()) {
		
			//랭킹
			model.addAttribute("memeRankList", memeRankList);
			model.addAttribute("boardPushRankList", boardPushRankList);
			model.addAttribute("boardFreeRankList", boardFreeRankList);
			model.addAttribute("quizRankList", quizRankList);
			return "redirect:/board";
		} else {
			//일단 error 나누어서 안 적음, 필요하면 적기
			model.addAttribute("msg", "랭킹 조회 실패");
			return "error";
		}
		
		
	}
	
	
	@RequestMapping(value="/board", method = RequestMethod.GET, produces="application/text;charset=utf-8")
	public String boardranklist(
			Model model
			, @RequestParam(value="page", required=false) Integer page) {
		
		int currentPage = (page != null) ? page : 1;
		
		int totalCount = bService.getListCount();

		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		
		model.addAttribute("pi", pi);
		//비즈니스 로직 -> DB에서 전체 게시물 갯수 가져옴
		
		//게시판
		List<Board> boardAllList = bService.printAllBoard(pi);
		
		
		//랭킹
		model.addAttribute("rankmain", "board");
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
