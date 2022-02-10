package org.kh.meme.board.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.board.domain.Board;
import org.kh.meme.board.domain.PageInfo;

public interface BoardStore {

	List<Board> selectAllBoard(SqlSession sqlSession, PageInfo pi);

	int selectListCount(SqlSession sqlSession);

}
