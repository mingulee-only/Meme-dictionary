package org.kh.meme.meme.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.meme.meme.domain.Meme;
import org.kh.meme.meme.domain.PageInfo;
import org.kh.meme.meme.store.MemeStore;
import org.springframework.stereotype.Repository;

@Repository
public class MemeStoreLogic implements MemeStore{

	@Override
	public int selectListCount(SqlSession sqlSession) {
		int totalCount = sqlSession.selectOne("MemeMapper.selectListCount");
		return totalCount;
	}
	
	@Override
	public List<Meme> selectAll(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset=(currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Meme> mList = sqlSession.selectList("MemeMapper.selectAllList",pi,rowBounds);
		return mList;
	}

	@Override
	public int insertMeme(SqlSession session, Meme meme) {
		int result = session.insert("MemeMapper.insertMeme", meme);
		return result;
	}

	@Override
	public Meme selectOneByMeme(SqlSession sqlSession, String memeName) {
		Meme meme = sqlSession.selectOne("MemeMapper.selectOneByMeme", memeName);
		return meme;
	}




}
 