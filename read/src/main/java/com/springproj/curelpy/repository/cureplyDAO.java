package com.springproj.curelpy.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class cureplyDAO {
@Autowired
SqlSessionTemplate mybatis;

//글 등록
	public void insertcureply(cureplyVO board) {
		mybatis.insert("cureplyDAO.insertcureply", board);

	}
	
	
	public List<cureplyVO> getcureplyList(cureplyCriteria cri){
		
		
		return mybatis.selectList("cureplyDAO.getcureply",cri);
		
	}
		
	public int culistCount() {
		return mybatis.selectOne("cureplyDAO.cureplylistCount");
	}

	// 글 수정
	public void updatecureply(cureplyVO board) {
		mybatis.update("cureplyDAO.updatereply", board);
	}
	

	// 글 삭제
	public void deletecureply(cureplyVO board) {
		mybatis.delete("cureplyDAO.deletereply", board);
	}
	
	public void deleteAllcureply(int cuseq) {
		mybatis.delete("cureplyDAO.deleteAllcuReply", cuseq);
	}


}
