package org.kh.meme.board.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.board.domain.Board;
import org.kh.meme.board.domain.Recommend;
import org.kh.meme.board.service.BoardService;
import org.kh.meme.board.store.BoardStore;
import org.kh.meme.common.PageInfo;
import org.kh.meme.rank.store.RankStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardStore bStore;
	
	@Autowired
	private SqlSession sqlSession;

	
	//페이징 처리
	@Override
	public int getListCount() {
		int totalCount = bStore.selectListCount(sqlSession);
		
		return totalCount;
	}
	
	
	//게시물 리스트
	@Override
	public List<Board> printAllBoard(PageInfo pi) {
		List<Board> boardAllList = bStore.selectAllBoard(sqlSession, pi);
		return boardAllList;
	}
	
	//게시물 디테일 페이지 확인
	@Override
	public Board printBoardOneByNo(Integer boardNo) {
		Board board = bStore.selectBoardOneById(sqlSession, boardNo);
		return board;
	}
	

	//게시물 조회수 증가
	@Override
	public int boardCount(Integer boardNo) {
		int result = bStore.updateBoardCount(sqlSession, boardNo);
		return result;
	}

	//게시물 추천 수
	
	@Override
	public int addBoardLike(Recommend recommend) {
		int result = bStore.insertBoardLike(sqlSession, recommend);
		return result;
	}


	@Override
	public int updateBoardLike(Recommend recommend) {
		int result = bStore.updateBoardLike(sqlSession, recommend);
		return result;
	}

	
	//게시글 추가
	@Override
	public int registerBoard(Board board) {
		int result = bStore.insertBoard(sqlSession, board);
		return result;
	}








}
