package com.springproj.curelpy.service;

import java.util.List;

import com.springproj.curelpy.repository.cureplyCriteria;
import com.springproj.curelpy.repository.cureplyVO;

public interface cureplyService {
	public void insertcureply(cureplyVO board);
	public List<cureplyVO> getcureplyList(cureplyCriteria cri);
	public int culistCount();
	public void updatecureply(cureplyVO board);
	public void deletecureply(cureplyVO board);
	public void deleteAllcureply(int cuseq);


}
