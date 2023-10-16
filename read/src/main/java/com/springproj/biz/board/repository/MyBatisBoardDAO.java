package com.springproj.biz.board.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisBoardDAO extends SqlSessionDaoSupport {
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	
	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(SpringBoardVO board) {
		getSqlSession().insert("BoardDAO.insertBoard", board);
	}
	
	// 글 목록 조회
	public List<SpringBoardVO> getBoardList(SpringBoardVO vo){
		
		if(vo.getSearchCondition().equals("TITLE")) {
			return getSqlSession().selectList("BoardDAO.getBoardList_T", vo);
		} else if(vo.getSearchCondition().equals("CONTENT")) {
			return getSqlSession().selectList("BoardDAO.getBoardList_C", vo);
		} else {
			return getSqlSession().selectList("BoardDAO.getBoardList_T", vo);
		}
		
	}
	
	// 글 상세 조회
	public SpringBoardVO getBoard(int seq) {
		
		return getSqlSession().selectOne("BoardDAO.getBoard", seq);
	}
	
	// 글 수정
	public void updateBoard(SpringBoardVO board) {
		getSqlSession().update("BoardDAO.updateBoard", board);
	}
	
	// 글 삭제
	public void deleteBoard(int seq) {
		getSqlSession().delete("BoardDAO.deleteBoard", seq);
	}
	
}





