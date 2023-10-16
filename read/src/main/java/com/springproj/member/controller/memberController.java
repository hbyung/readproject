package com.springproj.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springproj.biz.board.repository.Criteria;
import com.springproj.biz.board.repository.PageMaker;
import com.springproj.biz.rental.service.BookRentalService;
import com.springproj.member.repository.memberVO;
import com.springproj.member.service.memberService;

@Controller
public class memberController {
	@Autowired
	private memberService mbservice;
	
	@Autowired
	private BookRentalService rentalService;
	


	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap") // key
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<>();

		conditionMap.put("아이디", "ID");
		conditionMap.put("이름", "NAME");

		return conditionMap; // value
	}
	
		///@RequestMapping(value = "/memberlogin.me", method = RequestMethod.GET)
		@GetMapping(value = "/memberlogin.me") // 4.3 이후 버전
		public String loginForm(@ModelAttribute("member") memberVO vo) {
			
			vo.setId("test");
			vo.setPassword("test1234");
			
			return "login";
		}
		
		@GetMapping(value = "/joinmembership.me") // 4.3 이후 버전
		public String joinmembership(@ModelAttribute("member") memberVO vo) {
			
			return "membership";
		}
		
		
		@GetMapping(value = "/pwsearch.me") // 4.3 이후 버전
		public String pwsearch(@ModelAttribute("member") memberVO vo) {
			
			return "pwsearch";
		}
		
		@GetMapping(value = "/twopwsearch.me") // 4.3 이후 버전
		public String twopwsearch(@ModelAttribute("member") memberVO vo) {
			
			return "findpw";
		}
		
	
		//비밀번호 변경
		@PostMapping(value = "/change.me") // 4.3 이후 버전
		public String pwsearchform(@ModelAttribute("member") memberVO vo,HttpServletRequest request,HttpServletResponse response) {
			String pw = request.getParameter("password");
			vo.setPassword(pw);	
			memberVO user = mbservice.getmember(vo.getId());
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;

			

			try {
				out = response.getWriter();
				if(user == null) {
					out.println("<script>alert('아이디를 정확하게 입력해주세여!.');</script>");
					out.flush();
					return "findpw";
				}
				if((user.getId().equals(vo.getId())) && (user.getEmail().equals(vo.getEmail())) && (user.getPassword().equals(vo.getPassword()))) {
				
				return "pwsearchform";
				
				}else {
				
					out.println("<script>alert('로그인 정보를 확인하세요!.');</script>");
					out.flush();
					return "findpw";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "findpw";
		}


		@GetMapping(value = "/rental.do") // 4.3 이후 버전
		public String memberRental(@ModelAttribute("member") memberVO vo) {
			
			return "rental";
		}
		
		@GetMapping(value = "/notice.do") // 4.3 이후 버전
		public String memberNotice(@ModelAttribute("member") memberVO vo) {
			
			return "notice";
		}
		
		//@RequestMapping(value = "/memberlogin.me", method = RequestMethod.POST)
		@PostMapping(value = "/memberlogin.me") // 4.3 이후 버전
		public String loginProc(memberVO vo, HttpSession session) {
			    String retVal = null;
				if(vo.getId().equals("admin")) {
					
					
					memberVO user = mbservice.getmember(vo.getId());
					
					if((user != null) &&
						(user.getPassword().equals(vo.getPassword()))) {
						session.setAttribute("userName", user.getName());
						session.setAttribute("id", user.getId());
						session.setAttribute("email", user.getEmail());
						session.setAttribute("rank", user.getRank());
						session.setAttribute("rank1", user.getRank1());
						session.setAttribute("rank2", user.getRank2());
						retVal = "adminMain";
						
					}else {
						retVal = "redirect:memberlogin.me";
					}
						return retVal;
				}
				else {
					if(vo.getId() == null || vo.getId().equals("")) {
						throw new ArithmeticException("아이디는 반드시 입력해야 합니다.");
					}
					
					memberVO user = mbservice.getmember(vo.getId());
					
					if((user != null) &&
							(user.getPassword().equals(vo.getPassword()))) {
						session.setAttribute("userName", user.getName());
						session.setAttribute("id", user.getId());
						session.setAttribute("email", user.getEmail());
						session.setAttribute("rank", user.getRank());
						session.setAttribute("rank1", user.getRank1());
						session.setAttribute("rank2", user.getRank2());
						retVal = "redirect:index.jsp";
						
					}else {
						retVal = "redirect:memberlogin.me";
					}
					
					return retVal;
			}
		}
		
		@GetMapping(value = "/getAdminMain.me") // 4.3 이후 버전
		public String getAdminMain(memberVO vo, HttpSession session, HttpServletResponse response) {
				String id = (String)session.getAttribute("id");
				
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
				  } else if(!id.equals("admin")){
					  response.setContentType("text/html; charset=UTF-8");
						PrintWriter out;
						try {
							out = response.getWriter();
							
							out.println("<script>alert('관리자만 접속가능합니다.');</script>");
							out.println("<script>history.go(-1);</script>");
							out.flush();
							
						} catch (IOException e) {
							e.printStackTrace();
						}			  
				  } 
				return "adminMain";
		}	
		
		// 로그 아웃
		@RequestMapping("/memberlogout.me")
		public String logoutProc(HttpSession session) {
			
			session.invalidate();
			
			return "redirect:memberlogin.me";
			
		}
		
		// 회원 등록 
		
		@RequestMapping("/insertmember.do")
		public String insertmember(memberVO vo) {
			mbservice.insertmember(vo);
			
			return "redirect:index.jsp";
		}
		
		// 회원 수정
		@RequestMapping("/updatemember.do")
		public String updateBoard(@ModelAttribute("member") memberVO vo, HttpServletRequest request,HttpServletResponse response) { //@SessionAttributes("board")와 연동.
			
			String id = request.getParameter("id");
			String pw = request.getParameter("password");
			String repw = request.getParameter("repassword");
			memberVO user = mbservice.getmember(vo.getId());
			
			if(user !=null && pw.equals(repw)) {
				if(!pw.equals("") && !repw.equals("")) {
				mbservice.updatemember(vo);
					
				return "redirect:memberlogin.me";	
				}
				
				try {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('로그인 정보를 확인하세요!.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
					out.close();
					
						
				} catch (IOException e) {
					
					e.printStackTrace();
					
				}
			
			}
			
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('로그인 정보를 확인하세요!.');</script>");
				out.println("<script>history.go(-1);</script>");
				out.flush();
				out.close();
				
					
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			return "pwsearchform";
			
		}
		
		// 회원정보 수정 (관리자)
		@RequestMapping("/updateAdminmember.do")
		public String updateAdminMember(@ModelAttribute("member") memberVO vo, HttpServletRequest request,HttpServletResponse response) { //@SessionAttributes("board")와 연동.
			
			
			mbservice.updateAdminmember(vo);
			
			return "redirect:getmemberList.do";
			
		}
		
		// 회원정보 랭크수정
		@RequestMapping("/updaterank.do")
		public void updaterankMember(@ModelAttribute("member") memberVO vo, HttpServletRequest request,HttpServletResponse response, HttpSession session) { //@SessionAttributes("board")와 연동.
			response.setContentType("text/html; charset=UTF-8");
			String id =(String)session.getAttribute("id");
			int rank =Integer.parseInt(String.valueOf(session.getAttribute("rank")));
			int rank1 =Integer.parseInt(String.valueOf(session.getAttribute("rank1")));
			int rank2 =Integer.parseInt(String.valueOf(session.getAttribute("rank2")));
			int seq = Integer.parseInt(request.getParameter("cuseq"));
			
			 vo.setId(id);
			  memberVO mvo = mbservice.checkAlreadyBlackList(vo);
			  
			  if(mvo != null) {
				  response.setContentType("text/html; charset=UTF-8");

					PrintWriter out;
					try {
						out = response.getWriter();
						
						out.println("<script>alert('블랙리스트 회원은 참여가 불가합니다.');</script>");
						out.println("<script>history.go(-1);</script>");
						out.flush();
						return;
						
					} catch (IOException e) {
						e.printStackTrace();
	
					}
				  
			  }
			
			if(rank == 0) {
			try {
				PrintWriter out= response.getWriter();
				vo.setId(id);
				vo.setRank(seq);
				mbservice.rankupdatemember(vo);
				session.setAttribute("rank", vo.getRank());
				out.println("<script>alert('참여가 완료되었습니다.');</script>");
				out.println("<script>history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {

			}
			}else if(rank1== 0) {
				try {
					PrintWriter out= response.getWriter();
					vo.setId(id);
				    vo.setRank1(seq);
					mbservice.twrankupdatemember(vo);
					session.setAttribute("rank1", vo.getRank1());
					out.println("<script>alert('참여가 완료되었습니다.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
				} catch (IOException e) {

				}
				
			}else if(rank2 ==0) {
				try {
					PrintWriter out= response.getWriter();
					vo.setId(id);
					vo.setRank2(seq);
					mbservice.thrankupdatemember(vo);
					session.setAttribute("rank2", vo.getRank2());
					out.println("<script>alert('참여가 완료되었습니다.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
				} catch (IOException e) {

				}
				
			}else {
				try {
					PrintWriter out= response.getWriter();
					vo.setId(id);
					vo.setRank(seq);
					mbservice.rankupdatemember(vo);
					session.setAttribute("rank", vo.getRank());
					out.println("<script>alert('참여가 한도입니다. 처음값을 재설정합니다.');</script>");
					out.println("<script>history.go(-1);</script>");
					out.flush();
				} catch (IOException e) {

				}
				
			}

			
		}
		

		
		// 회원 삭제
		@RequestMapping("/deletemember.do")
		public String deleteBoard(memberVO vo) {
			
			mbservice.deletemember(vo.getId());
			
			return "redirect:memberlogin.me";
		}
		
		// 회원 삭제(관리자)
		@RequestMapping("/deleteAdminmember.do")
		public String deleteAdminBoard(memberVO vo) {
			
			mbservice.deletemember(vo.getId());
			
			return "redirect:getmemberList.do";
		}
		
		// 회원 목록 보기
		@RequestMapping(value = "/getmemberList.do")
		public String getmemberList(memberVO vo, Model model, Criteria cri) {
			
			if (vo.getSearchCondition() == null) {
				vo.setSearchCondition("ID");
			}

			if (vo.getSearchKeyword() == null) {
				vo.setSearchKeyword("");
			}
			
			List<memberVO> list = mbservice.getmemberList(cri);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(mbservice.getMemberCount());
			  
			model.addAttribute("pageMaker", pageMaker);	
			model.addAttribute("memberList", list);
			return "admin/admin_getMemberList";
		}
		
				// 회원 상세 목록 보기
				@RequestMapping("/getmember.do")
				public String getBoard(Model model, memberVO vo) {
					
					memberVO member = mbservice.getmember(vo.getId());
					
					model.addAttribute("member", member);
					
					return "getBoard";
				}
				
				// 회원 상세 목록 보기
				@RequestMapping("/getadminmember.do")
				public String getadminBoard(Model model, memberVO vo) {
					
					memberVO member = mbservice.getmember(vo.getId());
					
					model.addAttribute("member", member);
					
					return "admin/admin_getMember";
				}
				
		// 블랙리스트 목록에 추가
		@RequestMapping(value = "/addBlackList.do")
		public String addBlackList(Model model, memberVO vo, HttpServletRequest request, HttpServletResponse response){
			
			vo.setId(request.getParameter("id"));
			vo.setEmail(request.getParameter("email"));
			
			System.out.println(vo.getId());
			System.out.println(vo.getEmail());
			
			memberVO member = mbservice.checkAlreadyBlackList(vo);
			
			// 이미 블랙리스트 회원인지 확인
			if(member != null) {
				  response.setContentType("text/html; charset=UTF-8");

					PrintWriter out;
					try {
						out = response.getWriter();
						
						out.println("<script>alert('이미 블랙리스트 등록 회원입니다.');</script>");
						out.println("<script>history.go(-1);</script>");
						out.flush();
						return "redirect:delayedRentalList.rn";
						
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			
			mbservice.addBlackList(vo);
			System.out.println("블랙리스트 등록 성공");
			
			return "redirect:delayedRentalList.rn";
			
		}
		
		@RequestMapping(value="/deleteBlackList.do")
		public String deleteBlackList(memberVO vo, HttpServletRequest request) {
			
			vo.setId(request.getParameter("id"));
			vo.setEmail(request.getParameter("email"));
			
			mbservice.deleteBlackList(vo);
			
			return "redirect:delayedRentalList.rn";
			
		}
		
		@PostMapping("/noticeMail.do")
		public String findpw(memberVO vo, HttpServletResponse response, HttpServletRequest request){
			response.setContentType("text/html;charset=utf-8");
			memberVO user = mbservice.getmember(vo.getId());
			PrintWriter out;
			try {
				out = response.getWriter();
				if(vo.getId() == null || vo.getId().equals("")) {
					out.print("아이디를 입력해주세여.");
					out.close();
				}	
				
				else if(user == null){
					out.print("아이디를 정확하게 입력해주세여.");
					out.close();	
				}	
				else if(!user.getEmail().equals(vo.getEmail())){
					out.print("등록되지 않은 이메일입니다.");
					out.close();
				}else {
					// 임시 비밀번호 생성
					String pw = "";
					for (int i = 0; i < 12; i++) {
						pw += (char) ((Math.random() * 26) + 97);
					}
					vo.setPassword(pw);
					// 비밀번호 변경
					mbservice.updatemember(vo);
					// 비밀번호 변경 메일 발송
					
					String email = vo.getEmail();
					
					String addr = "tjsdnd627@gmail.com";
					
					String subject = "LB에 요청하신 "+vo.getId()+" 님의 임시 비밀번호입니다.";
					
					String body = "LB에 요청하신: " +pw+ " 요청하신 임시 비밀번호입니다.";
					

					
					mbservice.sendEmail(email, addr, subject, body);

					out.print("이메일로 임시 비밀번호를 발송하였습니다.");
					out.close();
					
					return "pwsearchform";
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
			
			
			return "redirect:login.do";
			
		}
		
		@RequestMapping("/noticeMailform.do")
		public String findpwform(memberVO vo, HttpServletResponse response) throws Exception {
			
			return "findpw";
		}
		
		
		
}
