package org.kh.meme.board.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.board.domain.Board;
import org.kh.meme.board.domain.Comment;
import org.kh.meme.board.domain.Recommend;
import org.kh.meme.common.PageInfo;

public interface BoardStore {
	//페이징 처리
	public int selectListCount(SqlSession sqlSession);

	
	//게시판
	public List<Board> selectAllBoard(SqlSession sqlSession, PageInfo pi);
	public Board selectBoardOneById(SqlSession sqlSession, Integer boardNo);
	
	//조회수
	public int updateBoardCount(SqlSession sqlSession, Integer boardNo);

	//추천 수
	public int insertBoardLike(SqlSession sqlSession, Recommend recommend);
	public int updateBoardLike(SqlSession sqlSession, Recommend recommend);
	
	
	//게시글 추가
	public int insertBoard(SqlSession sqlSession, Board board);

	//댓글
	public int insertComment(SqlSession sqlSession, Comment comment);

	public List<Comment> selectAllComment(SqlSession sqlSession, int boardNo);

	public int updateComment(SqlSession sqlSession, Comment comment);

	public int deleteComment(SqlSession sqlSession, int commentNo);



}
