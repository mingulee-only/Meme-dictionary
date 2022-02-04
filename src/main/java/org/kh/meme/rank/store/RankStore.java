package org.kh.meme.rank.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.rank.domain.QuizRank;

public interface RankStore {

	public List<QuizRank> selectQuizRank(SqlSession sqlSession);

}
