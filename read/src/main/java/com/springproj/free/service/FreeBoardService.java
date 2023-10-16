package com.springproj.free.service;

import java.util.List;

import com.springproj.free.repository.FiveCriteria;
import com.springproj.free.repository.FreeBoardVO;
import com.springproj.free.repository.FreeCriteria;
import com.springproj.free.repository.SixCriteria;

public interface FreeBoardService {
	
	public void insertBoard(FreeBoardVO board);
	public List<FreeBoardVO> getBoardList(FreeCriteria cri);
	public List<FreeBoardVO> getrelpyList(FreeCriteria cri);
	public int listCount();
	public FreeBoardVO getBoard(int seq);
	public void updateBoard(FreeBoardVO board);
	public void deleteBoard(int seqs);
	public List<FreeBoardVO> getThree();
	public List<FreeBoardVO> getrm();
	public List<FreeBoardVO> getreply(int seq);
	public FreeBoardVO getreplyto(int seq);
	public List<FreeBoardVO> getspringList(SixCriteria cri);
	public List<FreeBoardVO> getreadBook(FiveCriteria cri);
	public List<FreeBoardVO> getallmember(FiveCriteria cri);
	public List<FreeBoardVO> getcumuBoardList(FiveCriteria cri);
	public List<FreeBoardVO> searchForBook(FreeBoardVO vo);
}
