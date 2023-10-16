package com.springproj.relpy.service;

import java.util.List;

import com.springproj.relpy.repository.replyCriteria;
import com.springproj.relpy.repository.replyVO;

public interface replyService {
	public void insertreply(replyVO board);
	public List<replyVO> getreplyList(replyCriteria cri);
	public int listCount();
	public void updatereply(replyVO board);
	public void deletereply(replyVO board);
	public void deleteAllReply(int seq);
	public replyVO getreply(int seqs);


}
