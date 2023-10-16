package com.springproj.free.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springproj.free.repository.FiveCriteria;
import com.springproj.free.repository.FreeBoardVO;
import com.springproj.free.repository.FreeCriteria;
import com.springproj.free.repository.FreePageMaker;
import com.springproj.free.repository.SixCriteria;
import com.springproj.free.service.FreeBoardService;
import com.springproj.relpy.service.replyService;

@Controller
@SessionAttributes("board")
public class FreeBoardController {

	@Autowired
	FreeBoardService freeservice;
	
	@Autowired
	replyService rpservice;
	
	// 검색 조건 목록 설정
		@ModelAttribute("freeconditionMap") // key
		public Map<String, String> searchfreeConditionMap(){
			Map<String, String> freeconditionMap = new HashMap<>();
			
			freeconditionMap.put("제목", "TTL");
			freeconditionMap.put("내용", "CONTENT");
			
			return freeconditionMap; // value
		}
		
		// 검색 조건 목록 설정
		@ModelAttribute("conditionMap") // key
		public Map<String, String> searchConditionMap() {
			Map<String, String> conditionMap = new HashMap<>();

			conditionMap.put("Title", "TITLE");
			conditionMap.put("Author", "AUTHOR");

			return conditionMap; // value
		}
		
		// 도서 검색 화면
		@RequestMapping(value="/searchForBookPage.do")
		public String searchForBookPage() {
			return "searchForBook";
		}
			
		// 도서 검색 결과
		@PostMapping(value="/searchForBook.do")
		public String searchForBook(FreeBoardVO vo, Model model) {
			System.out.println("검색 조건 : " + vo.getSearchCondition());
			System.out.println("검색 단어 : " + vo.getSearchKeyword());

			if (vo.getSearchKeyword() == null || vo.getSearchKeyword() == "") {
				
				return "redirect:getBookList.do";
			}
			
			if (vo.getSearchCondition() == null) {
				vo.setSearchCondition("TITLE");
			}
			
			List<FreeBoardVO> list = freeservice.searchForBook(vo);
			
			model.addAttribute("bookList",list);
					
			return "searchForBook";
		}
		
		//메인화면
		@RequestMapping(value = "/main.do")
		public String getmain(FreeBoardVO vo,Model model, FiveCriteria cri, SixCriteria sixcri) {
		
			if (vo.getSearchCondition() == null) {
				vo.setSearchCondition("TITLE");
			}

			if (vo.getSearchKeyword() == null) {
				vo.setSearchKeyword("");
			}
			

			List<FreeBoardVO> list = freeservice.getThree();
			List<FreeBoardVO> recommand = freeservice.getrm();
			List<FreeBoardVO> freelist = freeservice.getspringList(sixcri);
			List<FreeBoardVO> readlist = freeservice.getreadBook(cri);
			List<FreeBoardVO> cumulist = freeservice.getcumuBoardList(cri);
			
			model.addAttribute("boardList",list);
			model.addAttribute("recommand",recommand);
			model.addAttribute("freelist",freelist);
			model.addAttribute("readList",readlist);
			model.addAttribute("cumulist",cumulist);
			return "main";
		}
		
		//메인화면
		@RequestMapping(value = "/adminmain.do")
		public String getadminmain(FreeBoardVO vo,Model model, FiveCriteria cri) {
			List<FreeBoardVO> list = freeservice.getThree();
			List<FreeBoardVO> recommand = freeservice.getrm();
			List<FreeBoardVO> member = freeservice.getallmember(cri);
			model.addAttribute("boardList",list);
			model.addAttribute("recommand",recommand);
			model.addAttribute("member",member);
		
			return "adminMain";
		}
		
		//사용자메뉴얼
		@RequestMapping(value = "/usermenu.do")
		public String getusermenu(FreeBoardVO vo) {

			return "usermenu";
		}
		
		// 글 목록 보기
		@RequestMapping(value = "/getFreeBoardList.do")
		public String getBoardList(FreeBoardVO vo, Model model, FreeCriteria cri, HttpServletRequest request) {
			//System.out.println("글 목록 보기");
			System.out.println("검색 조건 : " + vo.getSearchCondition());
			System.out.println("검색 단어 : " + vo.getSearchKeyword());
			
			if(vo.getSearchCondition() == null) {
				vo.setSearchCondition("TTL");
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
			
			List<FreeBoardVO> list = freeservice.getBoardList(cri);
			FreePageMaker pageMaker = new FreePageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(freeservice.listCount());
			
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("boardList", list);
			return "freeboard/getfreeBoardList";
					
		}	
		
		

		// 글 목록 보기 (관리자 페이지)
				@RequestMapping(value = "/getAdminFreeBoardList.do")
				public String getAdminBoardList(FreeBoardVO vo, Model model, FreeCriteria cri) {
					//System.out.println("글 목록 보기");
					System.out.println("검색 조건 : " + vo.getSearchCondition());
					System.out.println("검색 단어 : " + vo.getSearchKeyword());
					
					if(vo.getSearchCondition() == null) {
						vo.setSearchCondition("TITLE");
					}
					
					if(vo.getSearchKeyword() == null) {
						vo.setSearchKeyword("");
					}
					
					List<FreeBoardVO> list = freeservice.getBoardList(cri);
					FreePageMaker pageMaker = new FreePageMaker();
					pageMaker.setCri(cri);
					pageMaker.setTotalCount(freeservice.listCount());
					
					model.addAttribute("pageMaker", pageMaker);
					model.addAttribute("boardList", list);
					return "admin/admin_getfreeBoardList";
							
				}	
		
		// 상세 목록 보기
		@RequestMapping("/getfreeBoard.do")
		public String getBoard(Model model, FreeBoardVO vo, FreeCriteria cri) {
			FreeBoardVO board = freeservice.getBoard(vo.getSeq());
			List<FreeBoardVO> boardreply = freeservice.getreply(vo.getSeq());
			List<FreeBoardVO> list = freeservice.getrelpyList(cri);
			FreePageMaker pageMaker = new FreePageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(freeservice.listCount());
			
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("boardList", list);
			model.addAttribute("board", board);
			model.addAttribute("boardreply", boardreply);

			return "freeboard/freenotice";
		}
		
		// 상세 목록 보기(관리자 전용)
		@RequestMapping("/getAdminfreeBoard.do")
		public String getAdminBoard(Model model, FreeBoardVO vo, FreeCriteria cri) {
			FreeBoardVO board = freeservice.getBoard(vo.getSeq());
			List<FreeBoardVO> boardreply = freeservice.getreply(vo.getSeq());
			List<FreeBoardVO> list = freeservice.getrelpyList(cri);
			FreePageMaker pageMaker = new FreePageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(freeservice.listCount());
			
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("boardList", list);
			model.addAttribute("board", board);
			model.addAttribute("boardreply", boardreply);

			return "admin/admin_freeboard";
		}
		
		
			
		// reply 삭제폼 
		@RequestMapping(value="/getupdatereply.do", method = RequestMethod.GET)
		public String getdetailreply(@ModelAttribute("boardreply")FreeBoardVO vo, Model model) {
			FreeBoardVO boardreply = freeservice.getreplyto(vo.getSeqs());
			model.addAttribute("boardreply", boardreply);
			return "freeboard/setreplyupdate";
		}	
		
		// reply 수정폼 
		@RequestMapping(value="/getdetailreply.do", method = RequestMethod.GET)
		public String getupdatereply(@ModelAttribute("boardreply")FreeBoardVO vo, Model model) {
			FreeBoardVO boardreply = freeservice.getreplyto(vo.getSeqs());
			model.addAttribute("boardreply", boardreply);
			return "freeboard/setreplynotice";
		}	
		
		
		// reply 수정폼 (관리자)
		@RequestMapping(value="/getfreeboard.do", method = RequestMethod.GET)
		public String getfreereply(@ModelAttribute("boardreply")FreeBoardVO vo, Model model) {
			FreeBoardVO boardreply = freeservice.getreplyto(vo.getSeqs());
			model.addAttribute("boardreply", boardreply);
			return "admin/admin_getfreeboard";
		}	
		
		
		
		
		
		// 글 등록 화면
		@RequestMapping(value="/insertfreeBoard.do", method = RequestMethod.GET)
		public String insertBoardForm(HttpSession session, HttpServletResponse response) {
			String id = (String)session.getAttribute("id"); // 로그인 여부 확인
			
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
			return "freeboard/insertBoardForm";
		}
		
		// 글 등록 처리
		@RequestMapping(value="/insertfreeBoard.do", method = RequestMethod.POST)
		public String insertBoardProc(FreeBoardVO vo, HttpSession session) {
			
			freeservice.insertBoard(vo);
			
			return "redirect:getFreeBoardList.do";
		}
		
		// 글 수정
		@RequestMapping("/updatefreeBoard.do")
		public String updateBoard(@ModelAttribute("board") FreeBoardVO vo,HttpServletRequest request, HttpSession session, HttpServletResponse response) { //@SessionAttributes("board")와 연동.
			String writer = request.getParameter("writer");
			String id = (String)session.getAttribute("id");
			response.setContentType("text/html; charset=UTF-8");
			
			if(writer.equals(id)) {
				freeservice.updateBoard(vo);
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
			
			return "redirect:getFreeBoardList.do";
		}
		
		// 글 수정 폼
		@RequestMapping("/updatefreeBoardform.do")
		public String updateBoardfrom(@ModelAttribute("board") FreeBoardVO vo,Model model,HttpServletRequest request, HttpSession session, HttpServletResponse response) { //@SessionAttributes("board")와 연동.
			FreeBoardVO board = freeservice.getBoard(vo.getSeq());
			model.addAttribute("board", board);
			
			return "freeboard/setfreenotice";
		}
		
		
		
		
		// 도서 정보
		@RequestMapping("/homeinfo.do")
		public String info() {
					
			
			return "info";
		}
		

		// 글 삭제
		@RequestMapping("/deletefreeBoard.do")
		public String deleteBoard(@ModelAttribute("board") FreeBoardVO vo, HttpServletResponse response, HttpSession session, HttpServletRequest request) {

			String id = (String)session.getAttribute("id");
			System.out.println(vo.getWriter());
			response.setContentType("text/html; charset=UTF-8");
			if(vo.getWriter().equals(id)) {
				freeservice.deleteBoard(vo.getSeq());
			}else {
			
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
			
			return "redirect:getFreeBoardList.do";
		}	
		
		// 글 삭제 (관리자)
		@RequestMapping("/deleteAdminfreeBoard.do")
		public String deleteAdminBoard(@ModelAttribute("board") FreeBoardVO vo) {
			
			freeservice.deleteBoard(vo.getSeq());
			rpservice.deleteAllReply(vo.getSeq());
			
			
			return "redirect:getAdminFreeBoardList.do";
		}	
}
