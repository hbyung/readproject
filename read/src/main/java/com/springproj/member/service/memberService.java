package com.springproj.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springproj.biz.board.repository.Criteria;
import com.springproj.biz.rental.repository.BookRentalVO;
import com.springproj.member.repository.memberVO;

public interface memberService {
	
	public void insertmember(memberVO vo);
	public List<memberVO> getmemberList(Criteria cri);
	public memberVO getmember(String id);
	public void updatemember(memberVO vo);
	public void deletemember(String id);
	public int getMemberCount();
	public void updateAdminmember(memberVO vo);
	public void rankupdatemember(memberVO vo);
	public void twrankupdatemember(memberVO vo);
	public void thrankupdatemember(memberVO vo);
	public void addBlackList(memberVO vo);
	public memberVO checkAlreadyBlackList(memberVO vo);
	public List<BookRentalVO> getBlackList();
	public void deleteBlackList(memberVO vo);
	public void sendEmail(String toAddress, String fromAddress,String subject, String msgBody);
	public void findPw(HttpServletResponse response, memberVO vo, HttpServletRequest request) throws Exception;
}
