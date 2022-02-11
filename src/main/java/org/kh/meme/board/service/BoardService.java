package org.kh.meme.board.service;

import java.util.List;

import org.kh.meme.board.domain.Board;
import org.kh.meme.board.domain.Comment;
import org.kh.meme.board.domain.Recommend;
import org.kh.meme.common.PageInfo;


public interface BoardService {
	
	//페이징처리
	public int getListCount();
	
	//게시글 리스트
	public List<Board> printAllBoard(PageInfo pi);
	
	
	//게시글 상세 페이지
	public Board printBoardOneByNo(Integer boardNo);
	public int boardCount(Integer boardNo);

	//추천 수
	public int addBoardLike(Recommend recommend); //recommend 테이블 insert
	public int updateBoardLike(Recommend recommend); // board 테이블 업데이트

	
	//게시글 추가
	public int registerBoard(Board board);

	//댓글
	public int registerComment(Comment comment); //댓글 등록

	

}
