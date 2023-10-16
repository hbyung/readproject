package com.springproj.book.service;

import java.util.List;
import java.util.Map;

import com.springproj.biz.rental.repository.Criteria;
import com.springproj.book.repository.BookVO;

public interface BookService {
	
	public void insertService(BookVO book);
	public List<BookVO> getBookList(Criteria cri);
	public List<BookVO> getAllBook(Criteria cri);
	public BookVO getBook(String isbn);
	public void updateService(BookVO book);
	public void deleteService(String isbn);
	public int listCount();
	public void updateBookCount(String isbn);
	public void minusBookCount(String isbn);
	public List<BookVO> getRecommend(String genre);
	List<Map<String, Object>>autocomplete(Map<String, Object> paramMap) throws Exception;
	
}
