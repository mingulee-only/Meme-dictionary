package org.kh.meme.member.service;

import java.util.List;

import org.kh.meme.common.PageInfo;
import org.kh.meme.member.domain.Member;
import org.kh.meme.meme.domain.Meme;
import org.kh.meme.meme.domain.MemeRequest;

public interface AdminService {

	int getAllMemberListCount();
	int getAllMemeListCount();
	int getAllMemeRequestListCount();

	List<Member> printAllMember(PageInfo pi);
	List<Meme> printAllMeme(PageInfo pi);
	List<MemeRequest> printAllMemeRequest(PageInfo pi);



}
