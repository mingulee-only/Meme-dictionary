package org.kh.meme.member.service;

import java.util.List;

import org.kh.meme.board.domain.Board;
import org.kh.meme.common.PageInfo;
import org.kh.meme.member.domain.Member;

public interface MemberService {

	Member loginMember(Member member);

	Member selectById(String memberId);
	
	Member findMemberId(Member member);

	Member findMemberPw(Member member);

	List<Board> printMyBoard(PageInfo pi, String memberId);

	int getMyPageListCount();
	
	int registerMember(Member member);

	int memberPwReset(Member member);

	int modifyMember(Member member);

	int memberRemove(String memberId);







}
