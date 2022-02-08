package org.kh.meme.member.service.logic;

import org.kh.meme.member.domain.Member;
import org.kh.meme.member.service.MemberService;
import org.kh.meme.member.store.MemberStore;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberStore mStore;
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Member loginMember(Member member) {
		Member memberOne = mStore.selectLoginMember(sqlSession, member);
		return memberOne;
	}

}
