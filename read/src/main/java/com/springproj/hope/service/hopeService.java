package com.springproj.hope.service;

import java.util.List;

import com.springproj.hope.repository.hopeCriteria;
import com.springproj.hope.repository.hopeVO;

public interface hopeService {
	public void insertBoard(hopeVO board);
	public List<hopeVO> getBoardList(hopeCriteria cri);
	public int listCount();
	public hopeVO getBoard(int seq);
	public void updateBoard(hopeVO board);
	public void deleteBoard(int seq);
	public void setCnt(int seq);
}
