package com.springproj.hope.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.hope.repository.hopeCriteria;
import com.springproj.hope.repository.hopeDAO;
import com.springproj.hope.repository.hopeVO;

@Service("hopeService")
public class hopeServiceimpy implements hopeService {
	@Autowired
	private hopeDAO hope;
	
	@Override
	public void insertBoard(hopeVO board) {
		hope.insertBoard(board);
		
	}

	@Override
	public List<hopeVO> getBoardList(hopeCriteria cri) {
		
		return hope.getBoardList(cri);
	}

	@Override
	public int listCount() {
		
		return hope.listCount();
	}

	@Override
	public hopeVO getBoard(int seq) {
	
		return hope.getBoard(seq);
	}

	@Override
	public void updateBoard(hopeVO board) {
		hope.updateBoard(board);
		
	}

	@Override
	public void deleteBoard(int seq) {
		hope.deleteBoard(seq);
		
	}
	

	@Override
	public void setCnt(int seq) {
		hope.setCnt(seq);
		
	}

}
