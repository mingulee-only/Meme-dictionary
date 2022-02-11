package org.kh.meme.member.store;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.member.domain.Member;
import org.mybatis.spring.SqlSessionTemplate;


public interface MemberStore {
	
	public Member selectLoginMember(SqlSession sqlSession, Member member);

	public Member selectMemberByNameEmail(SqlSession sqlSession, Member member);

	public Member selectMemberByIdNameEmail(SqlSession sqlSession, Member member);

	public int insertMember(SqlSession sqlSession, Member member);

	public int updateMemberPw(SqlSession sqlSession, Member member);

	public int memberDelete(SqlSession sqlSession, String memberId);



}
