package org.kh.meme.meme.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.meme.domain.Meme;
import org.kh.meme.meme.domain.PageInfo;
import org.kh.meme.meme.service.MemeService;
import org.kh.meme.meme.store.MemeStore;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeServiceImpl implements MemeService{

	@Autowired
	private MemeStore mStore;
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getListCount() {
		int totalCount = mStore.selectListCount(sqlSession);
		return totalCount;
	}
	
	//게시물을 가져오기
	@Override
	public List<Meme> printAll(PageInfo pi) {
		List<Meme> mList = mStore.selectAll(sqlSession, pi);
		return mList;
	}
	
	@Override
	public int registerMeme(Meme meme) {
		int result = mStore.insertMeme(sqlSession, meme);
		return result;
	}


	@Override
	public Meme printOneByMeme(String memeName) {
		Meme meme = mStore.selectOneByMeme(sqlSession, memeName);
		return meme;
	}




}
