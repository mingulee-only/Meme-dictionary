package org.kh.meme.member.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.meme.common.PageInfo;
import org.kh.meme.member.domain.Member;
import org.kh.meme.member.store.AdminStore;
import org.springframework.stereotype.Repository;

@Repository
public class AdminStoreLogic implements AdminStore{

	@Override
	public int allMemberListCount(SqlSession sqlSession) {
		int totalCount = sqlSession.selectOne("MemberMapper.selectAllMemberCount");
		return totalCount;
	}

	@Override
	public List<Member> selectAllMember(SqlSession sqlSession, PageInfo pi) {
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1 ) * limit;

		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<Member> allMemberList = sqlSession.selectList("MemberMapper.selectAllMember", pi, rowBounds);
		return allMemberList;
	}

}
