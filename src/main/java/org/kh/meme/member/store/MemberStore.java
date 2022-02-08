package org.kh.meme.member.store;

import org.kh.meme.member.domain.Member;
import org.mybatis.spring.SqlSessionTemplate;


public interface MemberStore {
	
	public Member selectLoginMember(SqlSessionTemplate sqlSession, Member member);

}
