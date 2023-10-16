package com.springproj.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.springproj.biz.board.repository.Criteria;
import com.springproj.biz.rental.repository.BookRentalVO;
import com.springproj.member.repository.memberDAO;
import com.springproj.member.repository.memberVO;


@Service("memberService")
public class memberServiceimply implements memberService {
	private JavaMailSender javaMailSender;
	
	@Autowired
	private memberDAO mdao;
	
	@Autowired
	private MailSender mailSender;
	
	public void sendEmail(String toAddress, String fromAddress,String subject, String msgBody) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(fromAddress);
		smm.setTo(toAddress);
		smm.setSubject(subject);
		smm.setText(msgBody);
		
		mailSender.send(smm);
	}
	
	public void findPw(HttpServletResponse response, memberVO vo, HttpServletRequest request) throws Exception {

		}
	
	
	public void insertmember(memberVO vo) {
		mdao.insertmember(vo);
		
	}

	
	public List<memberVO> getmemberList(Criteria cri) {
		
		return mdao.getmemberList(cri);
	}

	
	public memberVO getmember(String id) {
		
		return mdao.getmember(id);
	}

	
	public void updatemember(memberVO vo) {
		mdao.updatemember(vo);
		
	}

	
	public void deletemember(String id) {
		mdao.deletemember(id);
		
	}
	
	public int getMemberCount() {
		return mdao.getMemberCount();
	}


	@Override
	public void updateAdminmember(memberVO vo) {
		mdao.updateAdminmember(vo);
		
	}
	
	@Override
	public void rankupdatemember(memberVO vo) {
		mdao.rankupdatemember(vo);
	}
	
	@Override
	public void twrankupdatemember(memberVO vo) {
		mdao.twrankupdatemember(vo);
	}
	
	@Override
	public void thrankupdatemember(memberVO vo) {
		mdao.thrankupdatemember(vo);
	}
	
	public void addBlackList(memberVO vo) {
		mdao.addBlackList(vo);
	}


	@Override
	public memberVO checkAlreadyBlackList(memberVO vo) {

		return mdao.checkAlreadyBlackList(vo);
		
	}
	
	public List<BookRentalVO> getBlackList(){
		return mdao.getBlackList();
	}


	@Override
	public void deleteBlackList(memberVO vo) {
		mdao.deleteBlackList(vo);
		
	}
	

}
