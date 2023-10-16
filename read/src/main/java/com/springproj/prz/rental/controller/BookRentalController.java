package com.springproj.prz.rental.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springproj.biz.rental.repository.BookRentalVO;
import com.springproj.biz.rental.repository.Criteria;
import com.springproj.biz.rental.repository.PageMaker;
import com.springproj.biz.rental.service.BookRentalService;
import com.springproj.book.repository.BookVO;
import com.springproj.book.service.BookService;
import com.springproj.member.repository.memberVO;
import com.springproj.member.service.memberService;

@Controller
public class BookRentalController {
	@Autowired
	BookRentalService rentalService;
	@Autowired
	BookService bookService;
	@Autowired
	memberService mbservice;
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		
		Map<String, String> conditionMap = new HashMap<>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("회원ID", "ID");
		conditionMap.put("청구기호", "ISBN");
		
		return conditionMap;
	}
	
	@ModelAttribute("userconditionMap")
	public Map<String, String> searchUserConditionMap(){
		
		Map<String, String> conditionMap = new HashMap<>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("청구기호", "ISBN");
		
		return conditionMap;
	}
	
	@RequestMapping(value="/rental.rn")
	public String getMainRental() {
		return "rental";
	}
	
	  // 대여 도서 목록 보기
	  
	  @RequestMapping(value = "/getRentalList.rn") 
	  public String getBoardList(BookRentalVO vo, Model model, Criteria cri) { 
	  //System.out.println("검색 조건 : " + vo.getSearchCondition());
	  //System.out.println("검색 단어 : " + vo.getSearchKeyword());
	  
	  if(vo.getSearchCondition() == null) { vo.setSearchCondition("TITLE"); }
	  
	  if(vo.getSearchKeyword() == null) { vo.setSearchKeyword(""); }
	  

	  
	  List<BookRentalVO> list = rentalService.getRentalList(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(rentalService.listCount());
		  
		model.addAttribute("pageMaker", pageMaker);	  
		model.addAttribute("rentalList", list);
	  
	 
	  
	  return "rental/getRentalList"; 
	  }
	  
		
// 연체 도서 보유 회원 
	@RequestMapping(value="/delayedRentalList.rn")
	public String getDelayedMember(Model model, memberVO vo) {
		
		List<BookRentalVO> list = rentalService.delayedIdList();
		
		
		List<BookRentalVO> blackList = mbservice.getBlackList();
		
		
		model.addAttribute("delayedList", list);
		model.addAttribute("blackList", blackList);
		
		
		return "admin/admin_getDelayedList";
		
	}
	  
	  
	  
	
	  // 대여된 도서 상세 보기
	  
	  @RequestMapping("/getRental.rn") public String getBoard(Model model,
	  BookRentalVO vo) {
	  
	  BookRentalVO book = rentalService.getRental(vo.getRisbn());
	  
	  model.addAttribute("rental", book);
	  
	  return "rental/getRental"; }
	  
	  // 도서 대여하기(화면 출력)
  
	  @RequestMapping(value="/insertRental.rn", method = RequestMethod.GET) 
	  public String insertRentalForm() { 
		  
		  return "rental/newinsertRentalForm"; 
		  
	  }
	  
	  // 도서 대여하기(대출페이지를 통한 DB 업데이트)
	  
	  @RequestMapping(value="/insertRental.rn", method = RequestMethod.POST) public
	  String insertRental(BookRentalVO vo, HttpSession session, HttpServletResponse response,RedirectAttributes redirectAttributes, HttpServletRequest request, memberVO mvo){
		  
		  String id = (String)session.getAttribute("id"); 
		  String email = (String)session.getAttribute("email");
		  
		  // 로그인 여부 확인
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
		  } else if(!email.trim().equals(vo.getRemail().trim())){
			  response.setContentType("text/html; charset=UTF-8");
				PrintWriter out;
				try {
					out = response.getWriter();
					
					out.println("<script>alert('이메일이 일치하지 않습니다.');</script>");
					out.flush();
					return "rental/newinsertRentalForm";
					
				} catch (IOException e) {
					e.printStackTrace();
				}			  
		  }
		  
		  mvo.setId(id);
		  System.out.println(mbservice.checkAlreadyBlackList(mvo) );
		  if(mbservice.checkAlreadyBlackList(mvo) != null) {
			  response.setContentType("text/html; charset=UTF-8");
				PrintWriter out;
				try {
					out = response.getWriter();
					
					out.println("<script>alert('블랙리스트 회원입니다. 관리자에게 문의 바랍니다.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
							
				} catch (IOException e) {
					e.printStackTrace();
				}			  
				return "rental/newinsertRentalForm";
		  }
		  
		  vo.setRid(id);
		  
		  
		  if(vo.getRisbn() == null) {
			  vo.setRisbn("1234");			  
		  }
		  
		  // DB에 존재하는 책인지 확인
		  vo.setAuthor(request.getParameter("rauthor"));
		  vo.setTitle(request.getParameter("rtitle"));
		  BookVO checkbook = rentalService.checkBook(vo);
		  
		  
		  if(checkbook == null) {
			  response.setContentType("text/html; charset=UTF-8");
			  
			  PrintWriter out;
			  try {
				
				out = response.getWriter();
				out.println("<script>alert('해당 책이 존재하지 않습니다');</script>");				
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			  
			  return "rental/newinsertRentalForm";
		  } 
		  
		  vo.setRisbn(checkbook.getIsbn());
		  
		  // 해당 책을 이미 대출하였는지의 유무
		  BookRentalVO bookvo = rentalService.checkAlreadyRental(vo);
		  
		  if(bookvo != null) {
			  response.setContentType("text/html; charset=UTF-8");
			  
			  PrintWriter out;
			  try {
				out = response.getWriter();
				out.println("<script>alert('이미 대여한 책입니다.');</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			  
			  return "rental/newinsertRentalForm";
		  
		  }
		  
		  // 대여 가능한 책 개수 확인
		  BookVO bookCnt = bookService.getBook(vo.getRisbn());
		  if(bookCnt.getBcount() <= 0) {
			  response.setContentType("text/html; charset=UTF-8");
			  
			  PrintWriter out;
			  try {
				out = response.getWriter();
				out.println("<script>alert('해당 책은 모두 대출되었습니다.');</script>");
				out.println("<script>history.go(-1);</script>");
				out.flush();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			  
			  return "rental/newinsertRentalForm";
		  }
		  
		  // 사용자의 대여가능 권수 최대치 확인
		  int rentalCnt = rentalService.getUserRentalCount(vo.getRid());
		  
		  if(rentalCnt>=5) {
			  response.setContentType("text/html; charset=UTF-8");
			  
			  PrintWriter out;
			  try {
				out = response.getWriter();
				out.println("<script>alert('1인 최대 대출 가능 권수는 5권입니다.');</script>");
				out.println("<script>history.go(-1);</script>");
				out.flush();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			  
			  return "rental/newinsertRentalForm";
			  
		  }
  
		  rentalService.insertService(vo);
		  bookService.minusBookCount(vo.getRisbn());
		  
		  redirectAttributes.addFlashAttribute("successMessage", "Success! 대출이 완료되었습니다.");

		  return "redirect:getBookList.do"; 
	  
	 }
	  
	  // 대출 버튼을 통한 대출 DB업데이트
	  @RequestMapping(value="/insertRentalButton.rn", method = RequestMethod.POST) 
	  public String insertRentalButton( HttpServletRequest request,
		BookRentalVO vo, HttpSession session, HttpServletResponse response, RedirectAttributes redirectAttributes, memberVO mvo){
  
		  String id = (String)session.getAttribute("id"); // 로그인 여부 확인
		  String email = (String)session.getAttribute("email");
		  
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
		  
		  mvo.setId(id);

		  if(mbservice.checkAlreadyBlackList(mvo) != null) {
			  response.setContentType("text/html; charset=UTF-8");
				PrintWriter out;
				try {
					out = response.getWriter();
					
					out.println("<script>alert('블랙리스트 회원입니다. 관리자에게 문의 바랍니다.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
							
				} catch (IOException e) {
					e.printStackTrace();
				}			  
				return "rental/newinsertRentalForm";
		  }

		String isbn = request.getParameter("bookInput");
		BookVO bookVO = bookService.getBook(isbn);
			
		vo.setRisbn(bookVO.getIsbn());
		vo.setRtitle(bookVO.getTitle());
		vo.setRauthor(bookVO.getAuthor());
		vo.setRid(id);
		vo.setRemail(email);
		
		  
		 // 해당 책을 이미 대출하였는지의 유무
		  BookRentalVO bookvo = rentalService.checkAlreadyRental(vo);
		  
		  if(bookvo != null) {
			  response.setContentType("text/html; charset=UTF-8");
			  
			  PrintWriter out;
			  try {
				out = response.getWriter();
				out.println("<script>alert('이미 대여한 책입니다.');</script>");
				out.println("<script>history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			  
			  return "redirect:getBookList.do";
		  
		  }
		  
		  // 대여 가능한 책 개수 확인
		  BookVO bookCnt = bookService.getBook(vo.getRisbn());
		  if(bookCnt.getBcount() <= 0) {
			  response.setContentType("text/html; charset=UTF-8");
			  
			  PrintWriter out;
			  try {
				out = response.getWriter();
				out.println("<script>alert('해당 책은 모두 대출되었습니다.');</script>");
				out.println("<script>history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			  
			  return "redirect:getBookList.do";
		  }
		  
		// 사용자의 대여가능 권수 최대치 확인
		  int rentalCnt = rentalService.getUserRentalCount(vo.getRid());
		  
		  if(rentalCnt>=5) {
			  response.setContentType("text/html; charset=UTF-8");
			  
			  PrintWriter out;
			  try {
				out = response.getWriter();
				out.println("<script>alert('1인 최대 대출 가능 권수는 5권입니다.');</script>");
				out.println("<script>history.go(-1);</script>");
				out.flush();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			  
			  return "redirect:getBookList.do";
			  
		  }
		  
		 rentalService.insertService(vo);
		 bookService.minusBookCount(vo.getRisbn());
		 
		 redirectAttributes.addFlashAttribute("successMessage", "Success! 대출이 완료되었습니다.");
		 
		 return "redirect:getBookList.do";
		
	   }
	  
	  
	  // 도서 대여 기간 연장
	  
	  @RequestMapping("/updateRental.rn") 
	  public String updateRental(@ModelAttribute("book") BookRentalVO vo) {
		  
		 rentalService.updateService(vo);
	  
	  return "redirect:getRentalList.rn"; }
	  
	  // 도서 반납 목록
	  @GetMapping("/deleteRental.rn")
	  public String deleteRentalList(BookRentalVO vo, HttpSession session, HttpServletResponse response, Model model, Criteria cri) {
		  String id = (String)session.getAttribute("id"); // 로그인 여부 확인
		  
		  if(vo.getSearchCondition() == null) { vo.setSearchCondition("TITLE"); }
		  
		  if(vo.getSearchKeyword() == null) { vo.setSearchKeyword(""); }
		  
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
		 
		  vo.setRid(id);
		  
		  List<BookRentalVO> list = rentalService.deleteRentalList(vo);
		  model.addAttribute("rentalList", list);
	  
		  return "rental/newReturnList";
}
	  
	
	  
	  // 도서 반납
	  
	  @PostMapping("/deleteRental.rn") 
	  public String deleteRental(BookRentalVO vo, HttpSession session, HttpServletRequest request){
		  
		 vo.setRisbn(request.getParameter("risbn"));
		 vo.setRid((String)session.getAttribute("id"));
		  
		  rentalService.deleteService(vo);
		  bookService.updateBookCount(vo.getRisbn());
		  
	  return "redirect:deleteRental.rn"; }
	 
	 
}