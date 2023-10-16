package com.springproj.free.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproj.biz.board.repository.SpringBoardVO;

@Repository
public class MybatisFreeDAO {
@Autowired
SqlSessionTemplate mybatis;

//글 등록
	public void insertBoard(FreeBoardVO board) {
		mybatis.insert("FreeDAO.insertfreeBoard", board);
	}
	
	
public List<FreeBoardVO> getBoardList(FreeCriteria cri){
	
	
	return mybatis.selectList("FreeDAO.getfreeboard",cri);
	
}

public List<FreeBoardVO> getcumuBoardList(FiveCriteria cri){
	
	
	return mybatis.selectList("FreeDAO.getcumuboard",cri);
	
}


	
public int listCount() {
	return mybatis.selectOne("FreeDAO.freelistCount");
}

//글 상세 조회
	public FreeBoardVO getBoard(int seq) {
		mybatis.selectOne("FreeDAO.setcnt",seq);
		return mybatis.selectOne("FreeDAO.getBoard", seq);
	}
	
//3개 값 가져오기 
	public List<FreeBoardVO> getThree() {
		return mybatis.selectList("FreeDAO.three");
	}
	
	public List<FreeBoardVO> getrm() {
		return mybatis.selectList("FreeDAO.recommand");
	}
	
	
	// 글 수정
	public void updateBoard(FreeBoardVO board) {
		mybatis.update("FreeDAO.updateBoard", board);
	}
	
	// 글 삭제
	public void deleteBoard(int seq) {
		mybatis.delete("FreeDAO.deleteBoard", seq);
	}
	
	public List<FreeBoardVO> getreplyList(FreeCriteria cri){
		return mybatis.selectList("FreeDAO.getreplyList",cri);
	}
	
	public List<FreeBoardVO> getreply(int seq) {
		
		return mybatis.selectList("FreeDAO.getreply", seq);
	}
	
	public FreeBoardVO getreplyto(int seqs) {
		
		return mybatis.selectOne("FreeDAO.getreplyto", seqs);
	}
	
	public List<FreeBoardVO> getspringList(SixCriteria cri){
		return mybatis.selectList("FreeDAO.getspringList",cri);
	}
	
	public List<FreeBoardVO> getreadBook(FiveCriteria cri){
		return mybatis.selectList("FreeDAO.readBookList",cri);
	}
	
	public List<FreeBoardVO> getallmember(FiveCriteria cri){
		return mybatis.selectList("FreeDAO.allmember",cri);
	}
	
	public List<FreeBoardVO> searchForBook(FreeBoardVO vo){
		return mybatis.selectList("FreeDAO.searchForBook", vo);
	}
	
	
	
	

}
