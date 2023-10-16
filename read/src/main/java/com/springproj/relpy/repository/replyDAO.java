package com.springproj.relpy.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class replyDAO {
@Autowired
SqlSessionTemplate mybatis;

//글 등록
	public void insertreply(replyVO board) {
		mybatis.insert("replyDAO.insertreply", board);

	}
	
	
	public List<replyVO> getreplyList(replyCriteria cri){
		
		
		return mybatis.selectList("replyDAO.getreply",cri);
		
	}
	
	public replyVO getreply(int seqs){
		
		
		return mybatis.selectOne("replyDAO.replydetail",seqs);
		
	}
		
	public int listCount() {
		return mybatis.selectOne("replyDAO.replylistCount");
	}

	// 글 수정
	public void updatereply(replyVO board) {
		mybatis.update("replyDAO.updatereply", board);
	}
	

	// 글 삭제
	public void deletereply(replyVO board) {
		mybatis.delete("replyDAO.deletereply", board);
	}
	
	public void deleteAllReply(int seq) {
		mybatis.delete("replyDAO.deleteAllReply", seq);
			
	}
	


}
