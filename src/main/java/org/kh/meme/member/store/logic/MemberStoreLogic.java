package org.kh.meme.member.store.logic;

import org.kh.meme.member.domain.Member;
import org.kh.meme.member.store.MemberStore;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberStoreLogic implements MemberStore{

	@Override
	public Member selectLoginMember(SqlSessionTemplate sqlSession, Member member) {
		Member memberOne = sqlSession.selectOne("MemberMapper.selectLoginMember", member);
		return memberOne;
	}

}
