package com.springproj.book.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproj.biz.rental.repository.Criteria;

@Repository
public class MyBatisBookDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	// CRUD 기능의 메소드 구현
	// 책 등록
	public void insertBook(BookVO book) {
		mybatis.insert("BookDAO.insertBook", book);
	}
	
	// 책 개수
		public int listCount() {
			return mybatis.selectOne("BookDAO.listCount");
		}
	
	// 책 목록 조회
	public List<BookVO> getBookList(Criteria cri){
		return mybatis.selectList("BookDAO.getBookList", cri);
	}
	
	public List<BookVO> getAllBook(Criteria cri){
		return mybatis.selectList("BookDAO.getAllBook", cri);
	}
	
	// 책 상세 조회
	public BookVO getBook(String isbn) {
		return mybatis.selectOne("BookDAO.getBook", isbn);
	}
	
	// 책 수정
	public void updateBoard(BookVO vo) {
		mybatis.update("BookDAO.updateBook", vo);
	}
	
	// 책 삭제
	public void deleteBook(String isbn) {
		mybatis.delete("BookDAO.deleteBook", isbn);
	}
	
	// 책 반납
	public void updateBookCount(String isbn) {
		mybatis.update("BookDAO.updateBookCount", isbn);
	}
		
	// 책 대출 시 개수 증가
	public void minusBookCount(String isbn) {
		mybatis.update("BookDAO.minusBookCount", isbn);
	}
	
	// 추천 도서
	public List<BookVO> getRecommend(String genre){
		return mybatis.selectList("BookDAO.getRecommend", genre);
	}
	
	public interface AutoComMapper {
		List<Map<String, Object>>autocomplete(Map<String, Object> paramMap) throws Exception;
	}

	public List<Map<String, Object>>autocomplete(Map<String, Object> paramMap) throws Exception{
		return ((AutoComMapper) mybatis).autocomplete(paramMap);
	}

}
