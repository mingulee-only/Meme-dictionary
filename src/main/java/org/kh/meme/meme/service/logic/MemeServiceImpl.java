package org.kh.meme.meme.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.meme.domain.Meme;
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
	public int registerMeme(Meme meme) {
		int result = mStore.insertMeme(sqlSession, meme);
		return result;
	}

}
