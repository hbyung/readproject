package com.springproj.biz.rental.service;

import java.util.List;

import com.springproj.biz.rental.repository.BookRentalVO;
import com.springproj.biz.rental.repository.Criteria;
import com.springproj.book.repository.BookVO;

public interface BookRentalService {

	public void insertService(BookRentalVO board);
	public int listCount();
	public List<BookRentalVO> getRentalList(Criteria cri);
	public BookRentalVO getRental(String isbn);
	public void updateService(BookRentalVO vo);
	public void deleteService(BookRentalVO vo);
	public List<BookRentalVO> delayedRentalList(Criteria cri);
	public BookVO checkBook(BookRentalVO vo);
	public List<BookRentalVO> deleteRentalList(BookRentalVO vo);
	public int getUserRentalCount(String id);
	public BookRentalVO checkAlreadyRental(BookRentalVO vo);
	public int delayedCount();
	public List<BookRentalVO> delayedIdList();
	public void deleteAllService(String risbn);
	
}