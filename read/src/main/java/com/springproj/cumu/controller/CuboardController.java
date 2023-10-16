package com.springproj.cumu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springproj.cumu.repository.CumuboardVO;
import com.springproj.cumu.service.CuboardService;
import com.springproj.free.repository.FreeCriteria;
import com.springproj.free.repository.FreePageMaker;
import com.springproj.member.repository.memberVO;
import com.springproj.member.service.memberService;

@Controller
public class CuboardController {
	@Autowired
	CuboardService cuservice;
	
	@Autowired
	private memberService mbservice;
	
	// 검색 조건 목록 설정
			@ModelAttribute("conditionMap") // key
			public Map<String, String> searchConditionMap(){
				Map<String, String> conditionMap = new HashMap<>();
				
				conditionMap.put("제목", "CUTITLE");
				conditionMap.put("내용", "CUCONTENT");
				
				return conditionMap; // value
			}
			
			
			// 글 목록 보기
			@RequestMapping(value = "/getcumuBoardList.do")
			public String getBoardList(CumuboardVO vo, Model model, FreeCriteria cri, HttpServletRequest request) {
				//System.out.println("글 목록 보기");
				System.out.println("검색 조건 : " + vo.getSearchCondition());
				System.out.println("검색 단어 : " + vo.getSearchKeyword());
				
				if(vo.getSearchCondition() == null) {
					vo.setSearchCondition("CUTITLE");
				}
				
				if(vo.getSearchKeyword() == null) {
					vo.setSearchKeyword("");
				}
				
				String page = request.getParameter("page");
				if(page == null) {
					
				}else {
					int pageint = Integer.parseInt(request.getParameter("page"));
					cri.setPage(pageint);
					System.out.println(pageint);
				}
				
				List<CumuboardVO> list = cuservice.getBoardList(cri);
				FreePageMaker pageMaker = new FreePageMaker();
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(cuservice.listCount());
				
				model.addAttribute("pageMaker", pageMaker);
				model.addAttribute("boardList", list);
				return "Cumu/getcumuBoardList";
						
			}	
			
			// 상세 목록 보기
			@RequestMapping("/getcumuBoard.do")
			public String getBoard(Model model, CumuboardVO vo, FreeCriteria cri, HttpServletResponse response, HttpSession session) {
				CumuboardVO board = cuservice.getBoard(vo.getCuseq());
				List<CumuboardVO> boardcureply = cuservice.getcureply(vo.getCuseq());
				List<CumuboardVO> list = cuservice.getcureplyList(cri);
				String id = (String)session.getAttribute("id");
				FreePageMaker pageMaker = new FreePageMaker();
				pageMaker.setCri(cri);
				pageMaker.setTotalCount(cuservice.listCount());
				
				  if(id == null) {
					  response.setContentType("text/html; charset=UTF-8");

						PrintWriter out;
						try {
							out = response.getWriter();
							
							out.println("<script>alert('로그인이 필요합니다.');</script>");
							out.println("<script>history.go(-1);</script>");
							out.flush();
							return "login";
							
						} catch (IOException e) {
			
		
						}
				  }else{
						model.addAttribute("pageMaker", pageMaker);
						model.addAttribute("board", board);
						model.addAttribute("boardcureply", boardcureply);
						model.addAttribute("boardlist", list);
						return "Cumu/cumunotice";
					  
				  }

				  return "Cumu/cumunotice";
			}
			
			
			// reply 상세보기와 수정폼 
			@RequestMapping(value="/getdetailcureply.do", method = RequestMethod.GET)
			public String getdetailreply(@ModelAttribute("boardcureply")CumuboardVO vo, Model model) {
				CumuboardVO boardcureply = cuservice.getcureplyto(vo.getCuseqs());
				
				
				model.addAttribute("boardcureply", boardcureply);
				return "Cumu/setcureplynotice";
			}	
			
			
			// reply 수정폼
			
			@RequestMapping(value="/getupdatecureply.do", method = RequestMethod.GET)
			public String updatereply(@ModelAttribute("boardcureply")CumuboardVO vo, Model model,HttpServletResponse response, HttpSession session) {
				CumuboardVO boardcureply = cuservice.getcureplyto(vo.getCuseqs());
				System.out.println(vo.getCuseqs());
				
				String id = (String)session.getAttribute("id");
				System.out.println(vo.getCuwriter());
				
				if(!id.equals(vo.getCuwriter()) || id == null) {
					
					response.setContentType("text/html; charset=UTF-8");

					PrintWriter out;
					try {
						out = response.getWriter();
						
						out.println("<script>alert('작성자만 수정 가능합니다.');</script>");
						out.println("<script>history.go(-1);</script>");
						out.flush();
						return "redirect:getcumuBoardList.do";
						
					} catch (IOException e) {
			
					}
					
				}
				
				model.addAttribute("boardcureply", boardcureply);
				return "Cumu/updatecureply";
			}
			
			
			// 글 등록 화면
			@RequestMapping(value="/insertcumuBoard.do", method = RequestMethod.GET)
			public String insertBoardForm(HttpSession session, HttpServletResponse response, memberVO vo) {
				String id = (String)session.getAttribute("id"); // 로그인 여부 확인
				System.out.println(id);
				  if(id == null) {
					  response.setContentType("text/html; charset=UTF-8");

						PrintWriter out;
						try {
							out = response.getWriter();
							
							out.println("<script>alert('로그인이 필요합니다.');</script>");
							out.flush();
							return "login";
							
						} catch (IOException e) {
							e.printStackTrace();
		
						}
				  }
				  
				  vo.setId(id);
				  
				  memberVO mvo = mbservice.checkAlreadyBlackList(vo);
				  
				  if(mvo != null) {
					  response.setContentType("text/html; charset=UTF-8");

						PrintWriter out;
						try {
							out = response.getWriter();
							
							out.println("<script>alert('블랙리스트 회원은 게시물 등록이 불가합니다.');</script>");
							out.println("<script>history.go(-1);</script>");
							out.flush();
							return "redirect:getcumuBoardList.do";
							
						} catch (IOException e) {
							e.printStackTrace();
		
						}
					  
				  }
				return "Cumu/insertcumuBoardForm";
			}
			
			// 글 등록 처리
			@RequestMapping(value="/insertcumuBoard.do", method = RequestMethod.POST)
			public String insertBoardProc(CumuboardVO vo, HttpSession session) {
				
				
				cuservice.insertBoard(vo);
				
				return "redirect:getcumuBoardList.do";
			}
			
			// 글 수정
			@RequestMapping("/updatecumuBoard.do")
			public String updateBoard(@ModelAttribute("board") CumuboardVO vo,HttpSession session, HttpServletResponse response, HttpServletRequest request) { //@SessionAttributes("board")와 연동.
					String id = (String)session.getAttribute("id");
					response.setContentType("text/html; charset=UTF-8");
					String cuwriter = request.getParameter("cuwriter");
					System.out.println(cuwriter);
					
					if(cuwriter.equals(id)) {
						cuservice.updateBoard(vo);
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
				
				return "redirect:getcumuBoardList.do";
			}
			
			// 글 수정 폼
			@RequestMapping("/updatecumuBoardform.do")
			public String updateBoardfrom(@ModelAttribute("board") CumuboardVO vo, Model model,HttpSession session, HttpServletResponse response, HttpServletRequest request) { 
				String id = (String)session.getAttribute("id");
				String writer = request.getParameter("cuwriter");
				response.setContentType("text/html; charset=UTF-8");
				
				System.out.println(writer);
				System.out.println( id);
				
				if(!writer.equals(id)) {
					
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
				
					CumuboardVO board = cuservice.getBoard(vo.getCuseq());
					model.addAttribute("board", board);
				
				return "Cumu/setcumunotice";
			}
			

			// 글 삭제
			@RequestMapping("/deletecumuBoard.do")
			public String deleteBoard(@ModelAttribute("board") CumuboardVO vo,HttpSession session, HttpServletResponse response, HttpServletRequest request) {
				String id = (String)session.getAttribute("id");
				int cuseq =Integer.parseInt(request.getParameter("cuseq"));
				System.out.println(cuseq);
				response.setContentType("text/html; charset=UTF-8");
				
				System.out.println(vo.getCuwriter());
					if(vo.getCuwriter().equals(id)) {
						cuservice.deleteBoard(cuseq);
						
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
				
				return "redirect:getcumuBoardList.do";
			}
			
}
