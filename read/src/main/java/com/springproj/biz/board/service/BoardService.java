package com.springproj.biz.board.service;

import java.util.List;

import com.springproj.biz.board.repository.Criteria;
import com.springproj.biz.board.repository.SpringBoardVO;

public interface BoardService {

	public void insertService(SpringBoardVO board);
	public List<SpringBoardVO> getBoardList(Criteria cri);
	public int listCount();
	public SpringBoardVO getBoard(int seq);
	public void updateService(SpringBoardVO board);
	public void deleteService(int seq);

}