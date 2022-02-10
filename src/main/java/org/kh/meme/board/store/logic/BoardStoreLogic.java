package org.kh.meme.board.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.kh.meme.board.domain.Board;
import org.kh.meme.board.domain.PageInfo;
import org.kh.meme.board.store.BoardStore;
import org.springframework.stereotype.Repository;

@Repository
public class BoardStoreLogic implements BoardStore{

	@Override
	public List<Board> selectAllBoard(SqlSession sqlSession, PageInfo pi) {
		/**
		 *  RowBounds는 쿼리문을 변경하지 않고도 페이징을 처리할 수 있게 해주는 클래스
		 *  RowBounds의 동작은 offset값과 limit값을 이용해서 동작함
		 *  offset값은 변하는 값이고 limit값은 고정값
		 *  limit값이 한 페이지당 보여주고 싶은 게시물의 갯수이고
		 *  offset은 건너뛰어야 할 값임
		 *  ex) limit 10, offset 0,  1~10
		 *  			  offset 10, 11~20
		 *  offset값은 currentPage에 의해서 변경됨
		 */

		
		//1 -> 1~10
		//2 -> 11~20
		//일 때 1, 11이 offset, limit은 몇개를 가져오는지
		//(지금 여기선 limit =10인 격)
		
		int limit = pi.getBoardLimit();
		int currentPage = pi.getCurrentPage();
		int offset = (currentPage - 1 ) * limit;
		//currentpage에 따라 달라짐.
		
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		//sql문 수정하지 않고 페이징 처리 해서 게시물 나누어 가져올 수 있음.
		
		
		List<Board> boardAllList = sqlSession.selectList("BoardMapper.selectBoardAllList", pi, rowBounds);
		return boardAllList;
	}

	//게시판
	@Override
	public int selectListCount(SqlSession sqlSession) {
		int totalCount = sqlSession.selectOne("BoardMapper.selectListCount");
		return totalCount;
	}
	
	@Override
	public Board selectBoardOneById(SqlSession sqlSession, Integer boardNo) {
		Board board = sqlSession.selectOne("BoardMapper.selectBoardOneById", boardNo);
		return board;
	}
	
	@Override
	public int insertBoard(SqlSession sqlSession, Board board) {
		int result = sqlSession.insert("BoardMapper.insertBoard", board);
		return result;
	}



}
