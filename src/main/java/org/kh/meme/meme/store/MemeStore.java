package org.kh.meme.meme.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.meme.domain.Meme;

public interface MemeStore {
	public int insertMeme(SqlSession session, Meme meme);
	
}
