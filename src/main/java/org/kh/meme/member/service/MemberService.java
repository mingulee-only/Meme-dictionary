package org.kh.meme.member.service;

import org.kh.meme.member.domain.Member;

public interface MemberService {

	Member loginMember(Member member);

	Member selectById(String memberId);
	
	Member findMemberId(Member member);

	Member findMemberPw(Member member);

	int registerMember(Member member);

	int memberPwReset(Member member);

	int modifyMember(Member member);

	int memberRemove(String memberId);





}
