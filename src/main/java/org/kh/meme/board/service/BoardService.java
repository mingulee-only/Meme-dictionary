package org.kh.meme.board.service;

import java.util.List;

import org.kh.meme.board.domain.Board;
import org.kh.meme.common.PageInfo;


public interface BoardService {
	
	//페이징처리
	public int getListCount();
	
	//게시글 리스트
	public List<Board> printAllBoard(PageInfo pi);
	//게시글 확인
	public Board printBoardOneByNo(Integer boardNo);
	//게시글 추가
	public int registerBoard(Board board);

}
