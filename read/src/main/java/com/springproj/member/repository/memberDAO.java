package com.springproj.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springproj.biz.board.repository.Criteria;
import com.springproj.biz.rental.repository.BookRentalVO;

@Repository
public class memberDAO {
	@Autowired
	SqlSessionTemplate mybatis;
	
	
	// CRUD 기능의 메소드 구현
	// 회원 등록
	public void insertmember(memberVO vo) {
		mybatis.insert("memberDAO.insertmember", vo);
	}
	
	// 회원 리스트 조회
	public List<memberVO> getmemberList(Criteria cri){
		
		return mybatis.selectList("memberDAO.allmember", cri);
		
	}
	
	// 회원 상세 조회
	public memberVO getmember(String id) {
		
		return mybatis.selectOne("memberDAO.getmember", id);
	}
	
	
	// 회원 수정
	public void updatemember(memberVO vo) {
		mybatis.update("memberDAO.updatemember", vo);
	}
	
	// 회원 삭제
	public void deletemember(String id) {
		mybatis.delete("memberDAO.deletemember",id);
	}
	
	public int getMemberCount() {
		return mybatis.selectOne("memberDAO.getMemberCount");
	}
	
	public void updateAdminmember(memberVO vo) {
		mybatis.update("memberDAO.updateAdminmember", vo);
	}
	
	// 회원 등급 변경
	public void rankupdatemember(memberVO vo) {
		mybatis.update("memberDAO.rankupdate", vo);
		
	}
	
	// 회원 등급 변경
	public void twrankupdatemember(memberVO vo) {
		mybatis.update("memberDAO.twrankupdate", vo);
		
	}
	
	// 회원 등급 변경
	public void thrankupdatemember(memberVO vo) {
		mybatis.update("memberDAO.thrankupdate", vo);
		
	}
	
	// 블랙리스트 등록
	public void addBlackList(memberVO vo) {
		mybatis.update("memberDAO.addBlackList", vo);
	}
	
	// 블랙리스트 이미 등록여부 체크
	public memberVO checkAlreadyBlackList(memberVO vo) {
		return mybatis.selectOne("memberDAO.checkAlreadyBlackList", vo);
	}
	
	// 블랙리스트 목록
	public List<BookRentalVO> getBlackList() {
		return mybatis.selectList("memberDAO.getBlackList");
	}
	
	// 블랙리스트 삭제
	public void deleteBlackList(memberVO vo) {
		mybatis.update("memberDAO.deleteBlackList", vo);
	}
	


}
