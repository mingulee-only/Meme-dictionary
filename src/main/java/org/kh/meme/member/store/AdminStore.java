package org.kh.meme.member.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.common.PageInfo;
import org.kh.meme.member.domain.Member;

public interface AdminStore {

	int allMemberListCount(SqlSession sqlSession);

	List<Member> selectAllMember(SqlSession sqlSession, PageInfo pi);

}
