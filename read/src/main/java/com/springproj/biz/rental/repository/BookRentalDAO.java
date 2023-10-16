package com.springproj.biz.rental.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproj.book.repository.BookVO;

@Repository
public class BookRentalDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	
	// CRUD 기능의 메소드 구현
	// 대여 도서 등록
	public void insertRental(BookRentalVO vo) {
		mybatis.insert("RentalDAO.insertRental", vo);
	}
	
	// 대여 도서 총 개수
	public int getRentalCount() {
		
		return mybatis.selectOne("RentalDAO.getRentalCount");
	}
	
	// 유저가 대여한 도서 개수 불러오기
	public int getUserRentalCount(String id) {
		return mybatis.selectOne("RentalDAO.getUserRentalCount", id);
	}
	
	
	// 대여 도서 목록 조회
	public List<BookRentalVO> getRentalList(Criteria cri){
		
		
		return mybatis.selectList("RentalDAO.getRentalList", cri);
		
	}
	
	// 연체 도서 목록 조회
	public List<BookRentalVO> delayedRentalList(BookRentalVO vo){
		
		return mybatis.selectList("RentalDAO.delayedRentalList",vo);
		
	}
	
	// 대여 도서 상세 조회
	public BookRentalVO getRental(String isbn) {
		
		return mybatis.selectOne("RentalDAO.getRental", isbn);
	}
	
	// 대여 도서 대출일 수정
	public void updateRental(BookRentalVO vo) {
		mybatis.update("RentalDAO.updateRental", vo);
	}
	
	// 대여 도서 반납
	public void deleteRental(BookRentalVO vo) {
		mybatis.delete("RentalDAO.deleteRental", vo);
	}
	
	// 도서 존재 여부 확인
	public BookVO checkBook(BookRentalVO vo) {
		return mybatis.selectOne("RentalDAO.checkBook", vo);
	}
	
	// 반납 도서 목록 불러오기
	public List<BookRentalVO> deleteRentalList(BookRentalVO vo){
		return mybatis.selectList("RentalDAO.deleteRentalList", vo);
	}
	
	public BookRentalVO checkAlreadyRental(BookRentalVO vo) {
		return mybatis.selectOne("RentalDAO.checkAlreadyRental", vo);
	}
	
	public int delayedCount() {
		return mybatis.selectOne("RentalDAO.delayedCount");
	}
	
	public List<BookRentalVO> delayedIdList() {
		return mybatis.selectList("RentalDAO.delayedIdList");
	}
	
	public void deleteAllService(String risbn) {
		mybatis.delete("RentalDAO.deleteAllService", risbn);
	}
	
}





