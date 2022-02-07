package org.kh.meme.rank.service;

import java.util.List;

import org.kh.meme.rank.domain.BoardRank;
import org.kh.meme.rank.domain.QuizRank;

public interface RankService {


	//게시판 랭킹
	public List<BoardRank> printBoardPushRank();
	public List<BoardRank> printBoardFreeRank();
	
	//퀴즈 랭킹
	public List<QuizRank> printQuizRank();


}
