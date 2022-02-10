package org.kh.meme.board.service;

import java.util.List;

import org.kh.meme.board.domain.Board;
import org.kh.meme.board.domain.PageInfo;


public interface BoardService {

	List<Board> printAllBoard(PageInfo pi);

	int getListCount();

	int registerBoard(Board board);

}
