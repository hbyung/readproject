package com.springproj.hope.controller;

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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springproj.hope.repository.hopeCriteria;
import com.springproj.hope.repository.hopePagemaker;
import com.springproj.hope.repository.hopeVO;
import com.springproj.hope.service.hopeService;
import com.springproj.member.service.memberService;
import com.springproj.member.repository.memberVO;

@Controller
@SessionAttributes("board")
public class hopeController {
	@Autowired
	hopeService hpservice;
	
	
	@Autowired
	private memberService mbservice;
	
	
	// 검색 조건 목록 설정
		@ModelAttribute("conditionMap") // key
		public Map<String, String> searchConditionMap(){
			Map<String, String> conditionMap = new HashMap<>();
			
			conditionMap.put("제목", "TITLE");
			conditionMap.put("내용", "CONTENT");
			
			return conditionMap; // value
		}
		
		
		// 글 목록 보기
		@RequestMapping(value = "/hopelist.do")
		public String getBoardList(hopeVO vo, Model model, hopeCriteria cri, HttpSession session, HttpServletRequest request) {
			//System.out.println("글 목록 보기");
			System.out.println("검색 조건 : " + vo.getSearchCondition());
			System.out.println("검색 단어 : " + vo.getSearchKeyword());
			
			if(vo.getSearchCondition() == null) {
				vo.setSearchCondition("TITLE");
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
			
			List<hopeVO> list = hpservice.getBoardList(cri);
			hopePagemaker pageMaker = new hopePagemaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(hpservice.listCount());
			
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("boardList", list);
			return "hope/gethopeList";
					
		}
		
		// 글 목록 보기 (관리자 페이지)
				@RequestMapping(value = "/hopeAdminlist.do")
				public String getAdminBoardList(hopeVO vo, Model model, hopeCriteria cri) {
					//System.out.println("글 목록 보기");

					
					if(vo.getSearchCondition() == null) {
						vo.setSearchCondition("TITLE");
					}
					
					if(vo.getSearchKeyword() == null) {
						vo.setSearchKeyword("");
					}
					
					List<hopeVO> list = hpservice.getBoardList(cri);
					hopePagemaker pageMaker = new hopePagemaker();
					pageMaker.setCri(cri);
					pageMaker.setTotalCount(hpservice.listCount());
					
					model.addAttribute("pageMaker", pageMaker);
					model.addAttribute("boardList", list);
					return "admin/admin_gethopeList";
							
						}
		
				// 상세 목록 보기
				@RequestMapping("/gethope.do")
				public String getBoard(Model model, hopeVO vo) {
					
					hpservice.setCnt(vo.getSeq());
					hopeVO board = hpservice.getBoard(vo.getSeq());
					
					System.out.println(board.getAuthor()); 
					
					model.addAttribute("board", board);
					
					return "hope/gethope";
				}
		

		// 상세 목록 보기
		@RequestMapping("/gethopeAdmin.do")
		public String getAdminBoard(Model model, hopeVO vo) {
			
			hopeVO board = hpservice.getBoard(vo.getSeq());
			
			model.addAttribute("board", board);
			
			return "admin/admin_gethope";
		}
		

		// 글 등록 화면
		@RequestMapping(value="/inserthope.do", method = RequestMethod.GET)
		public String insertBoardForm(HttpSession session, HttpServletResponse response, hopeVO vo) {
			String id =(String)session.getAttribute("id");
			
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
			
			memberVO mvo = mbservice.getmember(id);
			
			if(mvo.getBlackrank() == -1) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out;
				try {
					out = response.getWriter();
					
					out.println("<script>alert('블랙리스트 회원은 참여가 불가합니다. 관리자에게 문의 바랍니다.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
					return "redirect:hopelist.do";
					
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			
			
			return "hope/insertHopeForm";
		}

		
		// 글 등록 처리
		@RequestMapping(value="/inserthope.do", method = RequestMethod.POST)
		public String insertBoardProc(hopeVO vo, HttpSession session) {

			hpservice.insertBoard(vo);
			
			return "redirect:hopelist.do";
		}
		
		
		// 글 등록 처리
		@RequestMapping(value="/admininserthope.do", method = RequestMethod.POST)
		public String admininsertBoardProc(hopeVO vo, HttpSession session) {

			hpservice.insertBoard(vo);
			
			return "redirect:hopeAdminlist.do";
		}
		
		// 글 수정 화면
		@RequestMapping("/updatehopepage.do")
		public String updateHopePage(@ModelAttribute("board") hopeVO vo, HttpSession session,  HttpServletResponse response, HttpServletRequest request) { //@SessionAttributes("board")와 연동.
			String id =(String)session.getAttribute("id");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			System.out.println(id);
			System.out.println(vo.getWriter());
			
		if(id == null) {

				try {
					out = response.getWriter();
					
					out.println("<script>alert('로그인이 필요합니다.');</script>");
					out.flush();
					return "login";
					
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}	
		
		memberVO mvo = mbservice.getmember(id);
		
		if(mvo.getBlackrank() == -1) {
			response.setContentType("text/html; charset=UTF-8");
			
			try {
				out = response.getWriter();
				
				out.println("<script>alert('블랙리스트 회원은 참여가 불가합니다. 관리자에게 문의 바랍니다.');</script>");
				out.println("<script>history.go(-1);</script>");
				out.flush();
				return "redirect:hopelist.do";
				
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
			
		if(!id.equals(vo.getWriter())){
				try {
					out = response.getWriter();
					
					out.println("<script>alert('작성자만 수정 가능합니다.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
					
					
				} catch (IOException e) {
					e.printStackTrace();
				}	
				
			}	
		

			return "hope/updatehope";
			
		}
		
		// 글 수정
				@RequestMapping("/updatehope.do")
				public String updateBoard(@ModelAttribute("board") hopeVO vo, HttpSession session,  HttpServletResponse response, HttpServletRequest request) { //@SessionAttributes("board")와 연동.
					String id =(String)session.getAttribute("id");
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out;
					System.out.println(id);
					System.out.println(vo.getWriter());
					System.out.println(vo.getTitle());
					
				if(id == null) {

						try {
							out = response.getWriter();
							
							out.println("<script>alert('로그인이 필요합니다.');</script>");
							out.flush();
							return "login";
							
						} catch (IOException e) {
							e.printStackTrace();
						}	
					}	
				memberVO mvo = mbservice.getmember(id);
				
				if(mvo.getBlackrank() == -1) {
					response.setContentType("text/html; charset=UTF-8");
					
					try {
						out = response.getWriter();
						
						out.println("<script>alert('블랙리스트 회원은 참여가 불가합니다. 관리자에게 문의 바랍니다.');</script>");
						out.println("<script>history.go(-1);</script>");
						out.flush();
						return "redirect:hopelist.do";
						
					} catch (IOException e) {
						e.printStackTrace();
					}	
				}
					
				if(!id.equals(vo.getWriter())){
						try {
							out = response.getWriter();
							
							out.println("<script>alert('사용자가 일치하지않습니다.');</script>");
							out.println("<script>history.go(-1);</script>");
							out.flush();
							
							
						} catch (IOException e) {
							e.printStackTrace();
						}	
						
					}	
				
					hpservice.updateBoard(vo);
					return "redirect:hopelist.do";
					
					
				}
		
		// 글 삭제
				@RequestMapping("/deletehope.do")
				public String deleteBoard(hopeVO vo, HttpSession session,  HttpServletResponse response, HttpServletRequest request) {
					String id =(String)session.getAttribute("id");
					System.out.println(id);
					System.out.println(vo.getWriter());
					System.out.println(vo.getSeq());
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out;
					
					if(id == null) {

						try {
							out = response.getWriter();
							
							out.println("<script>alert('로그인이 필요합니다.');</script>");
							out.flush();
							return "login";
							
						} catch (IOException e) {
							e.printStackTrace();
						}	
					}	
					
					memberVO mvo = mbservice.getmember(id);
					
					if(mvo.getBlackrank() == -1) {
						response.setContentType("text/html; charset=UTF-8");
						
						try {
							out = response.getWriter();
							
							out.println("<script>alert('블랙리스트 회원은 참여가 불가합니다. 관리자에게 문의 바랍니다.');</script>");
							out.println("<script>history.go(-1);</script>");
							out.flush();
							return "redirect:hopelist.do";
							
						} catch (IOException e) {
							e.printStackTrace();
						}	
					}
					
					if(!id.equals(vo.getWriter())) {

						try {
							out = response.getWriter();
							
							out.println("<script>alert('작성자만 수정 가능합니다.');</script>");
							out.println("<script>history.go(-1);</script>");
							out.flush();
							return "redirect:hopelist.do";
							
						} catch (IOException e) {
							e.printStackTrace();
						}	
						
					}	
					hpservice.deleteBoard(vo.getSeq());
					return "redirect:hopelist.do";
				}
		
		// 글 삭제(관리자)
		@RequestMapping("/admindeletehope.do")
		public String admindeleteBoard(hopeVO vo, HttpSession session,  HttpServletResponse response, HttpServletRequest request) {
			String id =(String)session.getAttribute("id");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			
			if(id == null) {

				try {
					out = response.getWriter();
					
					out.println("<script>alert('로그인이 필요합니다.');</script>");
					out.flush();
					return "login";
					
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}	
		
				hpservice.deleteBoard(vo.getSeq());
				return "redirect:hopeAdminlist.do";

		}
	
	
}
