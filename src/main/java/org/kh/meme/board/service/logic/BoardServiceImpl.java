package org.kh.meme.board.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.board.domain.Board;
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
	
	
	
	@Override
	public List<Board> printAllBoard(PageInfo pi) {
		List<Board> boardAllList = bStore.selectAllBoard(sqlSession, pi);
		return boardAllList;
	}
	
	@Override
	public Board printBoardOneByNo(Integer boardNo) {
		Board board = bStore.selectBoardOneById(sqlSession, boardNo);
		return board;
	}


	@Override
	public int registerBoard(Board board) {
		int result = bStore.insertBoard(sqlSession, board);
		return result;
	}



}
