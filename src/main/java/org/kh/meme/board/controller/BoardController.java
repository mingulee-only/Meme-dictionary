package org.kh.meme.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kh.meme.board.domain.Board;
import org.kh.meme.board.domain.Comment;
import org.kh.meme.board.domain.Recommend;
import org.kh.meme.board.service.BoardService;
import org.kh.meme.common.PageInfo;
import org.kh.meme.common.Pagination;
import org.kh.meme.member.domain.Member;
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
	
	@ResponseBody
	@RequestMapping(value="/board/commentAdd", method=RequestMethod.POST)
	public String boardCommentAdd(
			@ModelAttribute Comment comment) {
		System.out.println(comment);
		String commentWriter = "어쩔티비";
		comment.setMemberNickname(commentWriter);
		int result = bService.registerComment(comment);
		
		//후속조치
		if(result > 0 ) {
			return "success";
		} else {
			return "fail";
		}

	}
	
	@RequestMapping(value="/board/detail_like", method=RequestMethod.POST)
	public String boardDetailLike( HttpServletRequest request 
			, @RequestParam("boardNo") Integer boardNo) {
		
		//추천 수
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginMember");
		System.out.println(member);
		
		Recommend recommend = new Recommend();
		recommend.setBoardNo(boardNo);
		recommend.setRecommendId(member.getMemberId());
		
		String referer = request.getHeader("Referer");
		
		//추천 수
		//게시물 recommend 추가
		int boardLikeData = bService.addBoardLike(recommend);
		
		if(boardLikeData > 0) {
			//게시물 추천수
			//board_tbl boardLike update
			int boardLike = bService.updateBoardLike(recommend);
			System.out.println("board에 게시물 추천수 반영!");
			return "redirect:"+referer;
		} else {
			System.out.println("board에 게시물 추천수 반영 안됨!");
			return "redirect:"+referer;
		}
		
	}

	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public String boardDetail( HttpServletRequest request
			, Model model
			, @RequestParam("boardNo") Integer boardNo) {
		
		//memberId session에서 가져오기
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("loginMember");
		System.out.println(member);
		
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
			
			//게시물 조회수 ++
//			bService.boardCount(oneBoard.getBoardNo());
			bService.boardCount(boardNo);
			
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
