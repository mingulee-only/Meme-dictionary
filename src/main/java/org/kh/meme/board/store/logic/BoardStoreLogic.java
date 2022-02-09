package org.kh.meme.board.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.board.domain.Board;
import org.kh.meme.board.store.BoardStore;
import org.springframework.stereotype.Repository;

@Repository
public class BoardStoreLogic implements BoardStore{

	@Override
	public List<Board> selectAllBoard(SqlSession sqlSession) {
		List<Board> boardAllList = sqlSession.selectList("BoardMapper.selectBoardAllList");
		return boardAllList;
	}

}
