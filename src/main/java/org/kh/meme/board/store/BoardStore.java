package org.kh.meme.board.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.board.domain.Board;

public interface BoardStore {

	List<Board> selectAllBoard(SqlSession sqlSession);

}
