package com.springproj.free.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.free.repository.FiveCriteria;
import com.springproj.free.repository.FreeBoardVO;
import com.springproj.free.repository.FreeCriteria;
import com.springproj.free.repository.MybatisFreeDAO;
import com.springproj.free.repository.SixCriteria;

@Service("freeBoardService")
public class FreeBoardServiceimply implements FreeBoardService{

	@Autowired
	private MybatisFreeDAO freedao;
	
	@Override
	public List<FreeBoardVO> getBoardList(FreeCriteria cri) {
		
		return freedao.getBoardList(cri);
	}
	
	@Override
	public List<FreeBoardVO> getcumuBoardList(FiveCriteria cri){
		
		return freedao.getcumuBoardList(cri);
	}
	@Override
	public int listCount() {
		return freedao.listCount();
	}
	@Override
	public void insertBoard(FreeBoardVO board) {
		freedao.insertBoard(board);
		
	}
	@Override
	public FreeBoardVO getBoard(int seq) {
		// TODO Auto-generated method stub
		return freedao.getBoard(seq);
	}
	@Override
	public void updateBoard(FreeBoardVO board) {
		freedao.updateBoard(board);
		
	}
	@Override
	public void deleteBoard(int seq) {
		freedao.deleteBoard(seq);
		
	};
	
	@Override
	public List<FreeBoardVO> getThree(){
		return freedao.getThree();
	}
	
	@Override
	public List<FreeBoardVO> getrelpyList(FreeCriteria cri){
		return freedao.getreplyList(cri);
	}
	
	@Override
	public List<FreeBoardVO> getrm(){
		return freedao.getrm();
	}
	
	@Override
	public List<FreeBoardVO> getreply(int seq) {
		return freedao.getreply(seq);
	}
	
	@Override
	public FreeBoardVO getreplyto(int seqs){
		return freedao.getreplyto(seqs);
	}
	
	@Override
	public List<FreeBoardVO> getspringList(SixCriteria cri){
		return freedao.getspringList(cri);
	}
	
	@Override
	public List<FreeBoardVO> getreadBook(FiveCriteria cri){
		return freedao.getreadBook(cri);
	}
	
	@Override
	public List<FreeBoardVO> getallmember(FiveCriteria cri){
		return freedao.getallmember(cri);
	}
	
	@Override
	public List<FreeBoardVO> searchForBook(FreeBoardVO vo) {
		
		return freedao.searchForBook(vo);
	}
}
