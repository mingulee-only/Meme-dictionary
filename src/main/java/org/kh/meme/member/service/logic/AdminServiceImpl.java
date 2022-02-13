package org.kh.meme.member.service.logic;

import java.util.List;

import org.kh.meme.common.PageInfo;
import org.kh.meme.member.domain.Member;
import org.kh.meme.member.service.AdminService;
import org.kh.meme.member.store.AdminStore;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminStore aStore;
	@Autowired
	private SqlSessionTemplate sqlSession;
	@Override
	public int getAllMemberListCount() {
		int totalCount = aStore.allMemberListCount(sqlSession);
		return totalCount;
	}
	@Override
	public List<Member> printAllMember(PageInfo pi) {
		List<Member> allMemberList = aStore.selectAllMember(sqlSession, pi);
		return allMemberList;
	}

}
