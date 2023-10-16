package com.springproj.book.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.springframework.web.multipart.MultipartFile;

import com.springproj.biz.rental.repository.Criteria;
import com.springproj.biz.rental.repository.PageMaker;
import com.springproj.biz.rental.repository.Search;
import com.springproj.biz.rental.service.BookRentalService;
import com.springproj.book.repository.BookVO;
import com.springproj.book.repository.Elastic;
import com.springproj.book.service.BookService;

@Controller
@SessionAttributes("book")
public class BookController {
	@Autowired
	BookService bookService;
	@Autowired
	BookRentalService rentalService;
	

	 

	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap") // key
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<>();

		conditionMap.put("제목", "TITLE");
		conditionMap.put("저자", "AUTHOR");

		return conditionMap; // value
	}

	// 책 목록 보기
	@RequestMapping(value = "/getBookList.do")
	public String getBookList(BookVO vo, Model model, Criteria cri, HttpServletRequest request) {
		
		System.out.println("검색 조건 : " + vo.getSearchCondition());
		System.out.println("검색 단어 : " + vo.getSearchKeyword());

		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}

		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}

		cri.setRowStart();
		cri.setRowEnd();
		System.out.println(cri);
		String page = request.getParameter("page");
		if(page == null) {
			
		}else {
			int pageint = Integer.parseInt(request.getParameter("page"));
			cri.setPage(pageint);
			System.out.println(pageint);
		}
		
		List<BookVO> list = bookService.getBookList(cri);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(bookService.listCount());

		List<BookVO> searchlist = bookService.getAllBook(cri);
		List<String> result = new ArrayList<String>();
		List<String> aresult = new ArrayList<String>();
		
		for (BookVO date : searchlist) {

	        	result.add("'"+date.getTitle()+"'");
	        	aresult.add("'"+date.getAuthor()+"'");

	    }
		
		
		   // List를 Set으로 변경
	       Set<String> set = new HashSet<String>(aresult);
	        // Set을 List로 변경
	        aresult =new ArrayList<String>(set);
		
		model.addAttribute("searchlist", result);
		model.addAttribute("authorchlist", aresult);
		model.addAttribute("pageMaker", pageMaker);	 
		model.addAttribute("bookList", list);
		
		String successMessage = (String)request.getAttribute("successMessage");
		  if(successMessage != null){
		    model.addAttribute("successMessage", successMessage);
		  }
		  
		return "rental/newgetRentalList";
	}
	
	// 책 검색 
	@RequestMapping(value = "/getBooksearch.do")
	public String getBooksearch(BookVO vo, Model model, Criteria cri, HttpServletRequest request, HttpServletResponse response, HttpSession session
) throws IOException {
		
		
		System.out.println("검색 조건1 : " + vo.getSearchCondition());
		System.out.println("검색 단어1 : " + vo.getSearchKeyword());

		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}

		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}

        
        Elastic elastic1 = new Elastic();
		
		String index = "book";
		Map<String, Object> searchdate = null;
		Search search = new Search();
		
		Map<String,Object> query = new HashMap<>();
		if(vo.getSearchCondition().equals("TITLE")) {
			query.put("title",vo.getSearchKeyword());
		}else if(vo.getSearchCondition().equals("AUTHOR")){
			query.put("author",vo.getSearchKeyword());
		}
		
		Map<String,SortOrder> sort = new HashMap<>();
		List<String> isbn = new ArrayList<>();
		List<String> title = new ArrayList<>();
		List<String> author = new ArrayList<>();
		List<String> genre = new ArrayList<>();

			
		List<Map<String, Object>> list = elastic1.simpleSearch(index, query, sort);	
		
		for(Map<String, Object> map : list) {
			System.out.println(map);

			searchdate = map;
					 
			isbn.add((String) searchdate.get("isbn")); 
			search.setIsbn(isbn);
			title.add((String) searchdate.get("title")); 
			search.setTitle(title);
			author.add((String) searchdate.get("author")); 
			search.setAuthor(author);
			genre.add((String) searchdate.get("genre")); 
			search.setGenre(genre);	 
			
		}
		

	    if(search.getIsbn() == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.println("<script>alert('값을 정확하게 입력해주세여'); history.go(-1);</script>");
			out.flush();

	    }else{
	    	List<BookVO> searchlist = bookService.getAllBook(cri);
			List<String> result = new ArrayList<String>();
			List<String> aresult = new ArrayList<String>();
			
			for (BookVO date : searchlist) {

		        	result.add("'"+date.getTitle()+"'");
		        	aresult.add("'"+date.getAuthor()+"'");

		    }

			   // List를 Set으로 변경
		       Set<String> set = new HashSet<String>(aresult);
		        // Set을 List로 변경
		        aresult =new ArrayList<String>(set);


			model.addAttribute("searchlist", result);
			model.addAttribute("authorchlist", aresult);
	    	PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(bookService.listCount());
			session.setAttribute("isbn", searchdate.get("isbn"));
			
			model.addAttribute("pageMaker", pageMaker);	  
			model.addAttribute("isbn", isbn);
			model.addAttribute("title", title);	
			model.addAttribute("author", author);	
			model.addAttribute("genre", genre);	
	    }
			
		 return "rental/newgetRentalList";
	}
	

	
	// 책 목록 보기 (관리자)
		@RequestMapping(value = "/getAdminBookList.do")
		public String getAdminBookList(BookVO vo, Model model, Criteria cri) {


			if (vo.getSearchCondition() == null) {
				vo.setSearchCondition("TITLE");
			}

			if (vo.getSearchKeyword() == null) {
				vo.setSearchKeyword("");
			}

			List<BookVO> list = bookService.getBookList(cri);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(bookService.listCount());
			  
			model.addAttribute("pageMaker", pageMaker);	  

			model.addAttribute("bookList", list);

			return "admin/admin_getBookList";
		}

	// 상세 목록 보기 (회원)
	@RequestMapping("/getBook.do")
	public String getBook(Model model, BookVO vo) {

		// 책 상세 정보 불러오기
		BookVO book = bookService.getBook(vo.getIsbn());
				
		// 같은 장르 도서 추천
		List<BookVO> list = bookService.getRecommend(book.getGenre());
					
		model.addAttribute("book", book);
		model.addAttribute("recommand", list);

		return "rental/getBook";
	}
	
	// 상세 목록 보기 (관리자)
		@RequestMapping("/getAdminBook.do")
		public String getAdminBook(Model model, BookVO vo) {

			// 책 상세 정보 불러오기
			BookVO book = bookService.getBook(vo.getIsbn());
			
			model.addAttribute("book", book);


			return "admin/admin_getBook";
		}


	// 책 등록 화면
	@RequestMapping(value = "/insertBook.do", method = RequestMethod.GET)
	public String insertBookForm(Model model, BookVO vo) {
		
		model.addAttribute("book", vo);
		return "admin/admin_insertBookForm";
	}

	// 책 등록 처리
	@RequestMapping(value = "/insertBook.do", method = RequestMethod.POST)
	public String insertBookProc(BookVO vo, HttpSession session, HttpServletResponse response) {
		System.out.println("insertBookProc() 호출");
		System.out.println(vo.toString());

		// 파일 업로드
		String fileSaveFolder = session.getServletContext().getRealPath("/bookimage/");
		System.out.println(fileSaveFolder);
		MultipartFile uploadFile = vo.getUploadFile();

		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			vo.setImage(fileName);

			try {
				uploadFile.transferTo(new File(fileSaveFolder + fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println(vo);
		vo.setHit(0);
		bookService.insertService(vo);

		return "redirect:getAdminBookList.do";
	}

	/*
	 * // 책 수정
	 * 
	 * @RequestMapping(value = "/updateBook.do", method = RequestMethod.GET) public
	 * String updateBookForm() { return "updateBookForm"; }
	 */
	
	/*
	 * // 책 수정
	 * 
	 * @RequestMapping(value = "/updateBook.do", method = RequestMethod.GET) public
	 * String updateBookForm() { return "updateBookForm"; }
	 */
		@RequestMapping(value = "/updateBook.do", method = RequestMethod.POST)
		public String updateBookProc(BookVO vo, HttpSession session) {
			System.out.println("updateBookProc() 호출");
			System.out.println(vo);
			// 파일 업로드
					String fileSaveFolder = session.getServletContext().getRealPath("/bookimage/");

					MultipartFile uploadFile = vo.getUploadFile();

					if (!uploadFile.isEmpty()) {
						String fileName = uploadFile.getOriginalFilename();
						vo.setImage(fileName);

						try {
							uploadFile.transferTo(new File(fileSaveFolder + fileName));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
			System.out.println(vo);
			
			bookService.updateService(vo);
			return "redirect:getAdminBookList.do";
		}

		
	// 책 삭제 목록 (관리자)
		@RequestMapping(value = "/deleteBook.do", method = RequestMethod.GET)
		public String getDeleteBookList(BookVO vo, Model model, Criteria cri) {


			if (vo.getSearchCondition() == null) {
				vo.setSearchCondition("TITLE");
			}

			if (vo.getSearchKeyword() == null) {
				vo.setSearchKeyword("");
			}

			List<BookVO> list = bookService.getBookList(cri);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(bookService.listCount());
			  
			model.addAttribute("pageMaker", pageMaker);	  

			model.addAttribute("bookList", list);

			return "admin/admin_getDeleteBookList";
		}
		
		@RequestMapping(value = "/deleteBook.do", method = RequestMethod.POST)
		public String deleteBookProc(BookVO vo, HttpSession session,HttpServletResponse response) {
			System.out.println("deleteBookProc() 호출");
			
			BookVO bookVO = bookService.getBook(vo.getIsbn());
			System.out.println(bookVO);
			bookService.deleteService(vo.getIsbn());
			
			
			rentalService.deleteAllService(vo.getIsbn());
			
//			
//			if (bookVO == null) { // ISBN이 존재하지 않는 경우
//		        response.setContentType("text/html; charset=UTF-8");
//		        PrintWriter out;
//		        try {
//		            out = response.getWriter();
//		            out.println("<script>alert('존재하지 않는 도서입니다.');</script>");
//		            out.flush();
//		        } catch (IOException e) {
//		            e.printStackTrace();
//		        }
//		        return "deleteBookForm";
//		    }
//			
//			if(bookVO.getTitle().equals(title)) {
//				if(title.equals(titleConfirm)) {
//					bookService.deleteService(vo.getIsbn());
//					return "redirect:getBookList.do";
//				} else {
//					response.setContentType("text/html; charset=UTF-8");
//					PrintWriter out;
//					try {
//						out = response.getWriter();
//						out.println("<script>alert('도서명과 확인 도서명이 일치하지 않습니다.');</script>");
//						out.flush();
//						return "deleteBookForm";
//					
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			} else {
//				response.setContentType("text/html; charset=UTF-8");
//				PrintWriter out;
//				try {
//					out = response.getWriter();
//					out.println("<script>alert('존재하지 않는 도서명입니다.');</script>");
//					out.flush();
//					return "deleteBookForm";
//				
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
			return "redirect:deleteBook.do";
				
		}
		
		
		@RequestMapping(value = "/test1.do")
		public String testform(BookVO vo, Criteria cri, Model model) {
			List<BookVO> list = bookService.getAllBook(cri);
			List<String> result = new ArrayList<String>();
			
			
			for (BookVO date : list) {

		        	result.add("'"+date.getTitle()+"'");

		    }
			
			System.out.println(result);
			
			model.addAttribute("bookList", result);
			
			return "test";
		}
}
