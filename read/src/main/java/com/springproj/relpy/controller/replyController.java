package com.springproj.relpy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproj.relpy.repository.replyVO;
import com.springproj.relpy.service.replyService;

@Controller
public class replyController {
	
	@Autowired
	replyService rpservice;
	
	
			// 글 등록 처리
			@RequestMapping(value="/reply.do")
			public String insertBoardProc(replyVO vo, HttpServletResponse response, HttpServletRequest request) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out;
				String contents = request.getParameter("contents");
				int seq = 0;
				
				try {
					out = response.getWriter();
					if(contents.equals("")) {
						out.println("<script>alert('아이디를 정확하게 입력해주세여!.');</script>");
						out.println("<script>history.go(-1);</script>");
						out.flush();
						}else {
						seq = Integer.parseInt(request.getParameter("seq"));	
						vo.setSeq(seq);	
						rpservice.insertreply(vo);
						return "redirect:getfreeBoard.do?seq="+vo.getSeq();
						}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				return "redirect:getfreeBoard.do?seq="+vo.getSeq();
		
			}
			
			
			// 글 수정
			@RequestMapping("/updatereply.do")
			public String updatereply(replyVO vo,HttpServletRequest request, HttpSession session, HttpServletResponse response) { //@SessionAttributes("board")와 연동.
				String pw = request.getParameter("password");
				String id = request.getParameter("id");
				vo.setId(id);
				replyVO getreply = rpservice.getreply(vo.getSeqs());
				response.setContentType("text/html; charset=UTF-8");
				
				if(getreply.getPassword().equals(pw)) {
					int seq = 0;
					seq = Integer.parseInt(request.getParameter("seq"));	
					vo.setSeq(seq);			
					rpservice.updatereply(vo);
				}
				
				else {
				PrintWriter out;
				try {
					out = response.getWriter();
					
					out.println("<script>alert('패스워드를 확인하세요.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
					
					
				} catch (IOException e) {
					e.printStackTrace();

				}
				}
				
				return "redirect:getfreeBoard.do?seq="+vo.getSeq();
			}
			
			// 글 수정(관리자)
						@RequestMapping("/updateadminreply.do")
						public String updateadminreply(replyVO vo,HttpServletRequest request, HttpSession session, HttpServletResponse response) { //@SessionAttributes("board")와 연동.
							String pw = request.getParameter("password");
							String id = request.getParameter("id");
							vo.setId(id);
							replyVO getreply = rpservice.getreply(vo.getSeqs());
							response.setContentType("text/html; charset=UTF-8");
							
							if(getreply.getPassword().equals(pw)) {
								int seq = 0;
								seq = Integer.parseInt(request.getParameter("seq"));	
								vo.setSeq(seq);			
								rpservice.updatereply(vo);
							}
							
							else {
							PrintWriter out;
							try {
								out = response.getWriter();
								
								out.println("<script>alert('패스워드를 확인하세요.');</script>");
								out.println("<script>history.go(-1);</script>");
								out.flush();
								
								
							} catch (IOException e) {
								e.printStackTrace();

							}
							}
							
							return "redirect:getAdminfreeBoard.do?seq="+vo.getSeq();
						}
			
		
			
			// 글 삭제
			@RequestMapping("/deletereply.do")
			public String deletereply(replyVO vo,HttpServletRequest request, HttpSession session, HttpServletResponse response) {
				
				String pw = request.getParameter("password");
				String id = (String)session.getAttribute("id");	
				vo.setId(id);
				replyVO getreply = rpservice.getreply(vo.getSeqs());
				response.setContentType("text/html; charset=UTF-8");

				if(getreply.getPassword().equals(pw)) {
					rpservice.deletereply(vo);
				}
				
				else {
				PrintWriter out;
				try {
					out = response.getWriter();
					
					out.println("<script>alert('패스워드를 확인하세요.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
					
					
				} catch (IOException e) {
					e.printStackTrace();

				}	
				
			}	
				return "redirect:getfreeBoard.do?seq="+vo.getSeq();
			}
			
			// 글 삭제(관리자)
			@RequestMapping("/deleteadminreply.do")
			public String deleteadminreply(replyVO vo,HttpServletRequest request, HttpSession session, HttpServletResponse response) {
				
				String pw = request.getParameter("password");
				String id = (String)session.getAttribute("id");	
				vo.setId(id);
				replyVO getreply = rpservice.getreply(vo.getSeqs());
				response.setContentType("text/html; charset=UTF-8");

				if(getreply.getPassword().equals(pw)) {
					rpservice.deletereply(vo);
				}
				
				else {
				PrintWriter out;
				try {
					out = response.getWriter();
					
					out.println("<script>alert('패스워드를 확인하세요.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
					
					
				} catch (IOException e) {
					e.printStackTrace();

				}	
				
			}	
				return "redirect:getAdminfreeBoard.do?seq="+vo.getSeq();
			}
}
