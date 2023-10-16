package com.springproj.cumu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.cumu.repository.CumuboardDAO;
import com.springproj.cumu.repository.CumuboardVO;
import com.springproj.free.repository.FreeCriteria;

@Service("CuboardService")
public class CuboardServiceimpy implements CuboardService {

	@Autowired
	private CumuboardDAO cumuDAO;
	
	@Override
	public void insertBoard(CumuboardVO board) {
		cumuDAO.insertBoard(board);
		
	}

	@Override
	public List<CumuboardVO> getBoardList(FreeCriteria cri) {

		return cumuDAO.getBoardList(cri);
	}

	@Override
	public int listCount() {

		return cumuDAO.listCount();
	}

	@Override
	public CumuboardVO getBoard(int cuseq) {
		// TODO Auto-generated method stub
		return cumuDAO.getBoard(cuseq);
	}

	@Override
	public void updateBoard(CumuboardVO board) {
		cumuDAO.updateBoard(board);
		
	}

	@Override
	public void deleteBoard(int cuseq) {
		cumuDAO.deleteBoard(cuseq);
		
	}
	
	@Override
	public List<CumuboardVO> getcureply(int cuseq){
		return cumuDAO.getcureply(cuseq);
		
	}
	
	@Override
	public CumuboardVO getcureplyto(int cuseqs) {
		return cumuDAO.getcureplyto(cuseqs);
	}
	
	@Override
	public List<CumuboardVO> getcureplyList(FreeCriteria cri){
		return cumuDAO.getcureplyList(cri);
		
	}
	
}
