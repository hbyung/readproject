package com.springproj.curelpy.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproj.curelpy.repository.cureplyVO;
import com.springproj.curelpy.service.cureplyService;
import com.springproj.relpy.repository.replyVO;


@Controller
public class cureplyController {
	
	@Autowired
	cureplyService curpservice;
	
	
			// 글 등록 처리
			@RequestMapping(value="/cureply.do")
			public String insertBoardProc(cureplyVO vo, HttpServletResponse response, HttpServletRequest request, HttpSession session) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out;
				String cucontents = request.getParameter("cucontents");
				int cuseq = Integer.parseInt(request.getParameter("cuseq"));
				int rank =(int)session.getAttribute("rank");
				int rank1 =(int)session.getAttribute("rank1");
				int rank2 =(int)session.getAttribute("rank2");
				
				try {
					out = response.getWriter();
					if(rank == cuseq || rank1 == cuseq || rank2 == cuseq) {
					if(cucontents.equals("")) {
						out.println("<script>alert('아이디를 정확하게 입력해주세여!.');</script>");
						out.println("<script>history.go(-1);</script>");
						out.flush();
						}else {	
						vo.setCuseq(cuseq);	
						curpservice.insertcureply(vo);
						return "redirect:getcumuBoard.do?cuseq="+vo.getCuseq();
						}
					}else {
						out.println("<script>alert('참여 가능 인원이 아닙니다.!.');</script>");
						out.println("<script>history.go(-1);</script>");
						out.flush();
					}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				return "redirect:getcumuBoard.do?cuseq="+vo.getCuseq();
		
			}
			
			// 글 수정
			@RequestMapping("/updatecureply.do")
			public String updatereply(cureplyVO vo,HttpServletRequest request, HttpSession session, HttpServletResponse response) { //@SessionAttributes("board")와 연동.
				int cuseq = 0;
				cuseq = Integer.parseInt(request.getParameter("cuseq"));	
				String id = (String)session.getAttribute("id");	
				String ids =  request.getParameter("id");
				vo.setId(ids);
				response.setContentType("text/html; charset=UTF-8");

				if(id.equals(vo.getId())) {
					vo.setCuseq(cuseq);			
					curpservice.updatecureply(vo);
				}
				
				else {
				PrintWriter out;
				try {
					out = response.getWriter();
					
					out.println("<script>alert('작성자만 수정가능합니다.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
					
					
				} catch (IOException e) {
					e.printStackTrace();

				}	
				}
					
				return "redirect:getcumuBoard.do?cuseq="+vo.getCuseq();
			}
			
			// 글 삭제
			@RequestMapping("/deletecureply.do")
			public String deletereply(cureplyVO vo, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
				
				String id = (String)session.getAttribute("id");	
				String ids =  request.getParameter("id");
				vo.setId(ids);
				response.setContentType("text/html; charset=UTF-8");

				if(id.equals(vo.getId())) {
					curpservice.deletecureply(vo);
				}
				
				else {
				PrintWriter out;
				try {
					out = response.getWriter();
					
					out.println("<script>alert('작성자만 삭제가능합니다.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
					
					
				} catch (IOException e) {
					e.printStackTrace();

				}	
				}
						
				return "redirect:getcumuBoard.do?cuseq="+vo.getCuseq();
			}			
}
