package com.springproj.relpy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.relpy.repository.replyCriteria;
import com.springproj.relpy.repository.replyDAO;
import com.springproj.relpy.repository.replyVO;

@Service("replyservice")
public class replyServiceimply implements replyService {
	
	@Autowired
	private replyDAO rpdao;

	@Override
	public void insertreply(replyVO board) {
		rpdao.insertreply(board);
		
	}

	@Override
	public List<replyVO> getreplyList(replyCriteria cri) {
		
		return rpdao.getreplyList(cri);
	}

	@Override
	public int listCount() {
		
		return rpdao.listCount();
	}

	@Override
	public void updatereply(replyVO board) {
		rpdao.updatereply(board);
		
	}

	@Override
	public void deletereply(replyVO board) {
		rpdao.deletereply(board);
		
	}
	
	@Override
	public void deleteAllReply(int seq) {
		rpdao.deleteAllReply(seq);
		
	}
	
	@Override
	public replyVO getreply(int seqs){
		return rpdao.getreply(seqs);
	}




}
