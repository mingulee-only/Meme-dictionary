package org.kh.meme.member.store;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.kh.meme.board.domain.Board;
import org.kh.meme.common.PageInfo;
import org.kh.meme.member.domain.Member;
import org.mybatis.spring.SqlSessionTemplate;


public interface MemberStore {
	
	public Member selectLoginMember(SqlSession sqlSession, Member member);

	public Member selectById(SqlSession sqlSession, String memberId);

	public Member selectMemberByNameEmail(SqlSession sqlSession, Member member);

	public Member selectMemberByIdNameEmail(SqlSession sqlSession, Member member);

	public List<Board> selectMyBoard(SqlSession sqlSession, PageInfo pi, String memberId);
	
	public int myPageListCount(SqlSession sqlSession);
	
	public int insertMember(SqlSession sqlSession, Member member);

	public int updateMemberPw(SqlSession sqlSession, Member member);

	public int updateMember(SqlSession sqlSession, Member member);
	
	public int memberDelete(SqlSession sqlSession, String memberId);






}
