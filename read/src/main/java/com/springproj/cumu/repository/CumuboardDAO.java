package com.springproj.cumu.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproj.free.repository.FreeBoardVO;
import com.springproj.free.repository.FreeCriteria;

@Repository
public class CumuboardDAO {
	
	@Autowired
	SqlSessionTemplate mybatis;

	//글 등록
		public void insertBoard(CumuboardVO board) {
			mybatis.insert("CumuDAO.insertCumuBoard", board);
		}
		
		
	public List<CumuboardVO> getBoardList(FreeCriteria cri){
		
		
		return mybatis.selectList("CumuDAO.getCumuBoard",cri);
		
	}
		
	public int listCount() {
		return mybatis.selectOne("CumuDAO.cumulistCount");
	}

	//글 상세 조회
		public CumuboardVO getBoard(int cuseq) {
			mybatis.selectOne("CumuDAO.setcnt",cuseq);
			return mybatis.selectOne("CumuDAO.getBoard", cuseq);
		}
		
		// 글 수정
		public void updateBoard(CumuboardVO board) {
			mybatis.update("CumuDAO.updateBoard", board);
		}
		
		// 글 삭제
		public void deleteBoard(int cuseq) {
			mybatis.delete("CumuDAO.deleteBoard", cuseq);
		}
		
		public List<CumuboardVO> getcureply(int cuseq) {
			
			return mybatis.selectList("CumuDAO.getcureply", cuseq);
		}
		
		public List<CumuboardVO> getcureplyList(FreeCriteria cri){
			
			
			return mybatis.selectList("CumuDAO.getcureplyList",cri);
			
		}
		
		public CumuboardVO getcureplyto(int cuseqs) {
			
			return mybatis.selectOne("CumuDAO.getcureplyto", cuseqs);
		}


		
}
