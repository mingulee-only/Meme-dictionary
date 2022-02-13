package org.kh.meme.member.service;

import java.util.List;

import org.kh.meme.common.PageInfo;
import org.kh.meme.member.domain.Member;

public interface AdminService {

	int getAllMemberListCount();

	List<Member> printAllMember(PageInfo pi);

}
