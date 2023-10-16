package com.springproj.biz.rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.biz.rental.repository.BookRentalDAO;
import com.springproj.biz.rental.repository.BookRentalVO;
import com.springproj.biz.rental.repository.Criteria;
import com.springproj.book.repository.BookVO;

@Service("rentalService")
public class BoardRentalServiceImpl implements BookRentalService {
	
	@Autowired
	//private MyBatisBoardDAO boardDAO;
	private BookRentalDAO rentalDAO;

	
	public BoardRentalServiceImpl() { }
	
	@Override
	public int listCount() {
		
		return rentalDAO.getRentalCount();
	}
	
	@Override
	public int getUserRentalCount(String id) {
		
		return rentalDAO.getUserRentalCount(id);
	}
	
	
	@Override
	public void insertService(BookRentalVO board) {

		rentalDAO.insertRental(board);
	}
	
	@Override
	public List<BookRentalVO> getRentalList(Criteria cri) {
		
		
				
		return rentalDAO.getRentalList(cri);
	}
	


	@Override
	public BookRentalVO getRental(String isbn) {
		
		return rentalDAO.getRental(isbn);
		
	}

	@Override
	public void updateService(BookRentalVO vo) {
		
		rentalDAO.updateRental(vo);
	}

	@Override
	public void deleteService(BookRentalVO vo) {
		
		rentalDAO.deleteRental(vo);
	}


	@Override // 책 존재유무 확인
	public BookVO checkBook(BookRentalVO vo) {
		
		return rentalDAO.checkBook(vo);
	}

	@Override // 반납할 도서 목록
	public List<BookRentalVO> deleteRentalList(BookRentalVO vo) {
		return rentalDAO.deleteRentalList(vo);
	}

	@Override
	public BookRentalVO checkAlreadyRental(BookRentalVO vo) {
		
		return rentalDAO.checkAlreadyRental(vo);
	}

	@Override
	public List<BookRentalVO> delayedRentalList(Criteria cri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delayedCount() {
		
		return rentalDAO.delayedCount();
	}

	@Override
	public List<BookRentalVO> delayedIdList() {
		
		return rentalDAO.delayedIdList();
	}

	@Override
	public void deleteAllService(String risbn) {
		
		rentalDAO.deleteAllService(risbn);
		
	}
	
	
	

}









