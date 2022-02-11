package org.kh.meme.board.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.board.domain.Board;
import org.kh.meme.common.PageInfo;

public interface BoardStore {
	//페이징 처리
	public int selectListCount(SqlSession sqlSession);

	
	//게시판
	public List<Board> selectAllBoard(SqlSession sqlSession, PageInfo pi);
	public Board selectBoardOneById(SqlSession sqlSession, Integer boardNo);
	
	public int insertBoard(SqlSession sqlSession, Board board);
	

}
