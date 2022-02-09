package org.kh.meme.board.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.board.domain.Board;
import org.kh.meme.board.service.BoardService;
import org.kh.meme.board.store.BoardStore;
import org.kh.meme.rank.store.RankStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardStore bStore;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Board> printAllBoard() {
		List<Board> boardAllList = bStore.selectAllBoard(sqlSession);
		return boardAllList;
	}

}
