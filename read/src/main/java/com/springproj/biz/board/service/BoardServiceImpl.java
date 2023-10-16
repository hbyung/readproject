package com.springproj.biz.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.biz.board.repository.Criteria;
import com.springproj.biz.board.repository.MyBatis2BoardDAO;
import com.springproj.biz.board.repository.SpringBoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	//private MyBatisBoardDAO boardDAO;
	private MyBatis2BoardDAO boardDAO;

	
	public BoardServiceImpl() { }
	
	
	@Override
	public void insertService(SpringBoardVO board) {

		boardDAO.insertBoard(board);
	}
	
	@Override
	public List<SpringBoardVO> getBoardList(Criteria cri){
		
		return boardDAO.getBoardList(cri);
	}
	
	@Override
	public int listCount() {
		return boardDAO.listCount();
	}
	


	@Override
	public SpringBoardVO getBoard(int seq) {
		
		return boardDAO.getBoard(seq);
	}

	@Override
	public void updateService(SpringBoardVO board) {
		
		boardDAO.updateBoard(board);
	}

	@Override
	public void deleteService(int seq) {
		
		boardDAO.deleteBoard(seq);
	}
	
	

}








