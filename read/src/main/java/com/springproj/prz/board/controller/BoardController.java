package com.springproj.prz.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springproj.biz.board.repository.Criteria;
import com.springproj.biz.board.repository.PageMaker;
import com.springproj.biz.board.repository.SpringBoardVO;
import com.springproj.biz.board.service.BoardService;
import com.springproj.book.repository.Elastic;
import com.springproj.book.repository.allElastic;

@Controller
@SessionAttributes("board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap") // key
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<>();
		
		conditionMap.put("제목", "AUTITLE");
		conditionMap.put("내용", "AUCONTENT");
		
		return conditionMap; // value
	}
	
	
	
	// 글 목록 보기
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(SpringBoardVO vo, Model model, Criteria cri, HttpServletRequest request, HttpServletResponse response) throws IOException{
		//System.out.println("글 목록 보기");
		System.out.println("검색 조건 : " + vo.getSearchCondition());
		System.out.println("검색 단어 : " + vo.getSearchKeyword());
		
		if(vo.getSearchCondition() == null) {
			vo.setSearchCondition("AUTITLE");
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
		
		List<SpringBoardVO> list = boardService.getBoardList(cri);
		

		 allElastic elastic2 = new allElastic();
		 String index = "springboard";
		
			

			List<Map<String, Object>> searchlist = elastic2.simpleSearch(index);	
			List<String> result = new ArrayList<String>();
			List<String> aresult = new ArrayList<String>();
			List<String> hwan = new ArrayList<String>();
			List<String> hwan1 = new ArrayList<String>();
			
	
					for (Map<String, Object> date : searchlist) {

				        	result.add("'"+date.get("autitle")+"'");
				        	hwan.add((String)date.get("aucontent"));
				        	aresult.add("'"+date.get("auwriter")+"'");
				    }
					
					String text = String.join(",",hwan);
					
				    String match = "[^\uAC00-\uD7A30-9a-zA-Z]";
				    text = text.replaceAll(match, " ");

					//String ttt = "서울도서관에서는 지역 책 문화 거점 공간인";
					
					StringTokenizer st = new StringTokenizer(text," ");
					
					while(st.hasMoreTokens()) {
						hwan1.add("'"+st.nextToken()+"'");
					}
					
								
					   // List를 Set으로 변경
			       Set<String> set = new HashSet<String>(aresult);
			        // Set을 List로 변경
			        aresult =new ArrayList<String>(set);
			        
			        Set<String> hwanset = new HashSet<String>(hwan1);
			        // Set을 List로 변경
			        hwan1 =new ArrayList<String>(hwanset);
			        
		
		model.addAttribute("titlesearchlist", result);
		//model.addAttribute("writersearchlist", aresult);
		model.addAttribute("contentsearchlist", hwan1);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.listCount());
		
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("boardList", list);
			   
		return "getBoardList";
				
	}
	
	// 글 검색
		@RequestMapping(value = "/getBoardsearchList.do")
		public String getBoardsearchList(SpringBoardVO vo, Model model, Criteria cri, HttpServletRequest request, HttpServletResponse response) throws IOException {
			//System.out.println("글 목록 보기");
			System.out.println("검색 조건 : " + vo.getSearchCondition());
			System.out.println("검색 단어 : " + vo.getSearchKeyword());
			
			if(vo.getSearchCondition() == null) {
				vo.setSearchCondition("AUTITLE");
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
			
			 Elastic elastic1 = new Elastic();
			 allElastic elastic2 = new allElastic();
				String index = "springboard";
			
				Map<String,Object> query = new HashMap<>();
				if(vo.getSearchCondition().equals("AUTITLE")) {
					query.put("autitle",vo.getSearchKeyword());
				}else if(vo.getSearchCondition().equals("AUCONTENT")){
					query.put("aucontent",vo.getSearchKeyword());
				}
				
				Map<String,SortOrder> sort = new HashMap<>();

				
				List<Map<String, Object>> list = elastic1.simpleSearch(index, query, sort);	

				List<Map<String, Object>> searchlist = elastic2.simpleSearch(index);	
				List<String> result = new ArrayList<String>();
				List<String> aresult = new ArrayList<String>();
				List<String> hwan = new ArrayList<String>();
				List<String> hwan1 = new ArrayList<String>();
				
				 if(list == null) {
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter out;
						out = response.getWriter();
						out.println("<script>alert('값을 정확하게 입력해주세여'); history.go(-1);</script>");
						out.flush();

				    }else{
				    	

			         for (Map<String, Object> date : searchlist) {

		        	result.add("'"+date.get("autitle")+"'");
		        	hwan.add((String)date.get("aucontent"));
		        	aresult.add("'"+date.get("auwriter")+"'");
			         }
		
					String text = String.join(",",hwan);
					
				    String match = "[^\uAC00-\uD7A30-9a-zA-Z]";
				    text = text.replaceAll(match, " ");
			
					//String ttt = "서울도서관에서는 지역 책 문화 거점 공간인";
					
					StringTokenizer st = new StringTokenizer(text," ");
					
					while(st.hasMoreTokens()) {
						hwan1.add("'"+st.nextToken()+"'");
					}
					
				
					   // List를 Set으로 변경
			       Set<String> set = new HashSet<String>(aresult);
			        // Set을 List로 변경
			        aresult =new ArrayList<String>(set);
			        
			        Set<String> hwanset = new HashSet<String>(hwan1);
			        // Set을 List로 변경
			        hwan1 =new ArrayList<String>(hwanset);
			        
			
			model.addAttribute("titlesearchlist", result);
			//model.addAttribute("writersearchlist", aresult);
			model.addAttribute("contentsearchlist", hwan1);
			
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(boardService.listCount());
			
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("boardList", list);
				    }	
			return "getBoardList";
		}
	
	// 공지사항 목록
		@RequestMapping(value = "/getAdminBoardList.do")
		public String getAdminBoardList(SpringBoardVO vo, Model model, Criteria cri) {
			//System.out.println("글 목록 보기");

			
			if(vo.getSearchCondition() == null) {
				vo.setSearchCondition("TITLE");
			}
			
			if(vo.getSearchKeyword() == null) {
				vo.setSearchKeyword("");
			}
			
			List<SpringBoardVO> list = boardService.getBoardList(cri);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(boardService.listCount());
			
			model.addAttribute("pageMaker", pageMaker);
			
			
			model.addAttribute("boardList", list);
			return "admin/admin_getNoticeBoardList";
					
		}
		
		// 공지사항 상세 목록 보기
		@RequestMapping("/getAdminBoard.do")
		public String getAdminBoard(Model model, SpringBoardVO vo) {
			
			SpringBoardVO board = boardService.getBoard(vo.getAuseq());
			
			model.addAttribute("board", board);
			
			return "admin/admin_getNoticeBoard";
		}
	
	// 상세 목록 보기
	@RequestMapping("/getBoard.do")
	public String getBoard(Model model, SpringBoardVO vo) {
		
		SpringBoardVO board = boardService.getBoard(vo.getAuseq());
		
		model.addAttribute("board", board);
		
		return "getBoard";
	}
	
	// 글 등록 화면
	@RequestMapping(value="/insertBoard.do", method = RequestMethod.GET)
	public String insertBoardForm() {
		return "insertBoardForm";
	}
	
	// 공지사항 등록 화면
			@RequestMapping(value="/insertAnnouncement.do", method = RequestMethod.GET)
			public String insertAnnouncement() {
				return "admin/admin_insertAnnouncement";
			}
	
	// 글 등록 처리
	@RequestMapping(value="/insertBoard.do", method = RequestMethod.POST)
	public String insertBoardProc(SpringBoardVO vo, HttpSession session) {
		
		
		boardService.insertService(vo);
		
		return "redirect:getBoardList.do";
	}
	
	// 공지사항 등록 처리
		@RequestMapping(value="/insertAnnouncement.do", method = RequestMethod.POST)
		public String insertAnnouncement(SpringBoardVO vo, HttpSession session) {
			
			boardService.insertService(vo);
			
			return "redirect:getAdminBoardList.do";
		}
		
	// 글 수정 폼
	@RequestMapping("/updateAdminAnnouncement.do")
	public String updateAdminAnnouncement(@ModelAttribute("board") SpringBoardVO vo) { //@SessionAttributes("board")와 연동.
				
		
		
		return "admin/admin_updateAnnouncement";
	}

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") SpringBoardVO vo) { //@SessionAttributes("board")와 연동.
				
		boardService.updateService(vo);
		
		return "redirect:getAdminBoardList.do";
	}
	
	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(SpringBoardVO vo) {
		
		boardService.deleteService(vo.getAuseq());
		
		return "redirect:getBoardList.do";
	}
	
	// 공지사항 삭제
	@RequestMapping("/deleteAdminBoard.do")
	public String deleteAdminBoard(SpringBoardVO vo) {
		
		boardService.deleteService(vo.getAuseq());
		
		return "redirect:getAdminBoardList.do";
	}
}


