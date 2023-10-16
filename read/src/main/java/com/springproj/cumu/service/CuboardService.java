package com.springproj.cumu.service;

import java.util.List;

import com.springproj.cumu.repository.CumuboardVO;
import com.springproj.free.repository.FreeCriteria;

public interface CuboardService {
	public void insertBoard(CumuboardVO board);
	public List<CumuboardVO> getBoardList(FreeCriteria cri);
	public int listCount();
	public CumuboardVO getBoard(int cuseq);
	public void updateBoard(CumuboardVO board);
	public void deleteBoard(int cuseq);
	public List<CumuboardVO> getcureply(int cuseq);
	public CumuboardVO getcureplyto(int cuseqs);
	public List<CumuboardVO> getcureplyList(FreeCriteria cri);
}
