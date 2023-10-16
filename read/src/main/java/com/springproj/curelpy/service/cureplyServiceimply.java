package com.springproj.curelpy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.curelpy.repository.cureplyCriteria;
import com.springproj.curelpy.repository.cureplyDAO;
import com.springproj.curelpy.repository.cureplyVO;


@Service("cureplyservice")
public class cureplyServiceimply implements cureplyService {
	
	@Autowired
	private cureplyDAO rpdao;

	@Override
	public void insertcureply(cureplyVO board) {
		rpdao.insertcureply(board);
		
	}

	@Override
	public List<cureplyVO> getcureplyList(cureplyCriteria cri) {
		
		return rpdao.getcureplyList(cri);
	}

	@Override
	public int culistCount() {
		
		return rpdao.culistCount();
	}

	@Override
	public void updatecureply(cureplyVO board) {
		rpdao.updatecureply(board);
		
	}

	@Override
	public void deletecureply(cureplyVO board) {
		rpdao.deletecureply(board);
		
	}
	
	@Override
	public void deleteAllcureply(int cuseq) {
		rpdao.deleteAllcureply(cuseq);
		
	}


}
