package com.springproj.hope.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class hopeDAO {
	@Autowired
	SqlSessionTemplate mybatis;
	
	
	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(hopeVO board) {
		mybatis.insert("hopeDAO.insertBoard", board);
	}
	
	// 글 목록 조회
	public List<hopeVO> getBoardList(hopeCriteria cri){
		
		
		return mybatis.selectList("hopeDAO.getBoardList",cri);
		
	}
	
	public int listCount() {
		return mybatis.selectOne("hopeDAO.listCount");
	}
	
	
	// 글 상세 조회
	public hopeVO getBoard(int seq) {
		mybatis.selectOne("BoardDAO.setcnt",seq);
		return mybatis.selectOne("hopeDAO.getBoard", seq);
	}
	
	
	// 글 수정
	public void updateBoard(hopeVO board) {
		mybatis.update("hopeDAO.updateBoard", board);
	}
	
	// 글 삭제
	public void deleteBoard(int seq) {
		mybatis.delete("hopeDAO.deleteBoard", seq);
	}
	
	public void setCnt(int seq) {
		mybatis.update("hopeDAO.setcnt", seq);
	}
}
