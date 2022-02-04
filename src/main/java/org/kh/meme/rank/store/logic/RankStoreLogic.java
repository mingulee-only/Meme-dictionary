package org.kh.meme.rank.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.rank.domain.QuizRank;
import org.kh.meme.rank.store.RankStore;
import org.springframework.stereotype.Repository;


@Repository
public class RankStoreLogic implements RankStore{

	@Override
	public List<QuizRank> selectQuizRank(SqlSession sqlSession) {
		List<QuizRank> quizRankList = sqlSession.selectList("RankMapper.selectQuizRank");
		//만약에 pi 필요 없으면 null 이렇게 해도 되긴 한데 우선 넣어주겠음.
		
		return quizRankList;
	}

}
