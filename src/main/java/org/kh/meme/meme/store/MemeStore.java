package org.kh.meme.meme.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.meme.domain.Meme;
import org.kh.meme.meme.domain.PageInfo;

public interface MemeStore {
	
	public int selectListCount(SqlSession sqlSession);
	public List<Meme> selectAll(SqlSession sqlSession, PageInfo pi);
	public int insertMeme(SqlSession session, Meme meme);
	public Meme selectOneByMeme(SqlSession session, String MemeName);
	
}
