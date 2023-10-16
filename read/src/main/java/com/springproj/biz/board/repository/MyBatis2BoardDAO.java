package com.springproj.biz.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproj.free.repository.FiveCriteria;

@Repository
public class MyBatis2BoardDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	
	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(SpringBoardVO board) {
		mybatis.insert("BoardDAO.insertBoard", board);
	}
	
	// 글 목록 조회
	public List<SpringBoardVO> getBoardList(Criteria cri){
		
		
		return mybatis.selectList("BoardDAO.getBoardList",cri);
		
	}
	
	public int listCount() {
		return mybatis.selectOne("BoardDAO.listCount");
	}
	
	
	// 글 상세 조회
	public SpringBoardVO getBoard(int seq) {
		mybatis.selectOne("BoardDAO.setcnt",seq);
		return mybatis.selectOne("BoardDAO.getBoard", seq);
	}
	
	
	// 글 수정
	public void updateBoard(SpringBoardVO board) {
		mybatis.update("BoardDAO.updateBoard", board);
	}
	
	// 글 삭제
	public void deleteBoard(int seq) {
		mybatis.delete("BoardDAO.deleteBoard", seq);
	}
	
	
}





