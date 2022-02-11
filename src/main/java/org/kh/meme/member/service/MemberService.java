package org.kh.meme.member.service;

import org.kh.meme.member.domain.Member;

public interface MemberService {

	Member loginMember(Member member);

	Member findMemberId(Member member);

	Member findMemberPw(Member member);

	int registerMember(Member member);

	int memberPwReset(Member member);

	int memberRemove(String memberId);



}
