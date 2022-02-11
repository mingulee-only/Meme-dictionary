package org.kh.meme.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.kh.meme.member.domain.Member;
import org.kh.meme.member.store.MemberStore;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberStoreLogic implements MemberStore{

	@Override
	public Member selectLoginMember(SqlSession sqlSession, Member member) {
		Member memberOne = sqlSession.selectOne("MemberMapper.selectLoginMember", member);
		return memberOne;
	}
	
	@Override
	public Member selectById(SqlSession sqlSession, String memberId) {
		Member member = sqlSession.selectOne("MemberMapper.selectById", memberId);
		return member;
	}
	
	@Override
	public Member selectMemberByNameEmail(SqlSession sqlSession, Member member) {
		Member memberOne = sqlSession.selectOne("MemberMapper.selectMemberByNameEmail", member);
		return memberOne;
	}
	
	@Override
	public Member selectMemberByIdNameEmail(SqlSession sqlSession, Member member) {
		Member memberOne = sqlSession.selectOne("MemberMapper.selectMemberByIdNameEmail", member);
		return memberOne;
	}
	
	@Override
	public int insertMember(SqlSession sqlSession, Member member) {
		int result = sqlSession.insert("MemberMapper.insertMember", member);
		return result;
	}

	@Override
	public int updateMemberPw(SqlSession sqlSession, Member member) {
		int result = sqlSession.update("MemberMapper.updateMemberPw", member);
		return result;
	}

	@Override
	public int updateMember(SqlSession sqlSession, Member member) {
		int result = sqlSession.update("MemberMapper.updateMember", member);
		return result;
	}
	
	@Override
	public int memberDelete(SqlSession sqlSession, String memberId) {
		int result = sqlSession.delete("MemberMapper.deleteMember", memberId);
		return result;
	}





}
