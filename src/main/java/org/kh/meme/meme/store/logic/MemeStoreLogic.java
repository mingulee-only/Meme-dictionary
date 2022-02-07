package org.kh.meme.meme.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.meme.domain.Meme;
import org.kh.meme.meme.store.MemeStore;
import org.springframework.stereotype.Repository;

@Repository
public class MemeStoreLogic implements MemeStore{

	@Override
	public int insertMeme(SqlSession session, Meme meme) {
		int result = session.insert("MemeMapper.insertMeme", meme);
		return result;
	}

}
 