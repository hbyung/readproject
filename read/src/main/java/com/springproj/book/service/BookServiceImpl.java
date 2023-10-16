package com.springproj.book.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproj.biz.rental.repository.Criteria;
import com.springproj.book.repository.BookVO;
import com.springproj.book.repository.MyBatisBookDAO;

@Service("bookService")
public class BookServiceImpl implements BookService{
	
	@Autowired
	private MyBatisBookDAO bookDAO;
	
	@Override
	public void insertService(BookVO book) {
		// 책 등록
		bookDAO.insertBook(book);
	}
	
	@Override
	public List<BookVO> getBookList(Criteria cri) {
		// 책 목록
		return bookDAO.getBookList(cri);
	}

	@Override
	public BookVO getBook(String isbn) {
		// 책 상세 정보
		return bookDAO.getBook(isbn);
	}

	@Override
	public void updateService(BookVO vo) {
		// 책 수정
		bookDAO.updateBoard(vo);
	}

	@Override
	public void deleteService(String isbn) {
		// 책 삭제
		bookDAO.deleteBook(isbn);
	}
	
	@Override // 책 개수
	public int listCount() {
		return bookDAO.listCount();
	}
	
	@Override // 책 반납
	public void updateBookCount(String isbn) {
		bookDAO.updateBookCount(isbn);
	}
	
	@Override // 책 대출 시 개수 감소
	public void minusBookCount(String isbn) {
		bookDAO.minusBookCount(isbn);
	}
	
	@Override // 추천 도서
	public List<BookVO> getRecommend(String genre){
		return bookDAO.getRecommend(genre);
	}

	@Override
	public List<Map<String, Object>>autocomplete(Map<String, Object> paramMap) throws Exception{
		return bookDAO.autocomplete(paramMap);
	}

	@Override
	public List<BookVO> getAllBook(Criteria cri) {
		return bookDAO.getAllBook(cri);
	}

	
	
}
