package com.iu.start.bankmembers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

//이 클래스는 Controller 역할,
//Container (생명주기를 만드는 것) 에게 이 클래스의 객체를 생성을 위임한다
@Controller 
@RequestMapping(value = "/member/*")
public class MemberController {

	@Autowired
	private BankMembersService bankMembersService;
	
	// annotation(어너테이션)
	// @ : 설명+실행
	
	@RequestMapping(value = "logout.iu", method = RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		//세션안에 멤버속성 삭제
		//세션을 소멸 ※ 보통 이걸 많이씀!
		session.invalidate();
		return"redirect:../";
	}
	
	// /member/login
	// 이 URL주소가 오면 이 메서드를 실행 해 주세요
	@RequestMapping(value = "login.iu", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	@RequestMapping(value = "login.iu", method = RequestMethod.POST)
	public String login(HttpServletRequest request, BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("DB로그인 실행");
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		
		HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);
		//"redirect:다시접속할 URL주소(절대경로, 상대경로)" 해야할 아이입니다 보통 상대경로를 많이 씀
		return "redirect:../";
	}
	
	// join /member/join GET
	@RequestMapping(value = "join.iu", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 GET 실행");
		
		return "member/join";
	}
	
	// join /member/join POST
	// 오버로딩 : 매개변수를 다르게 
	// 그래서 입력받는 HttpServletRequest request를 작성
	@RequestMapping(value = "join.iu", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {//매개변수로 String username 이라쓰면 
		System.out.println("회원가입 POST 실행");
		
		//멤버메서드의 매개변수 선언
		
		//내장객체 Request로 선언할때
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String phone = request.getParameter("phone");
//		bankMembersDTO.setUsername(username);
//		bankMembersDTO.setPassword(password);
//		bankMembersDTO.setName(name);
//		bankMembersDTO.setEmail(email);
//		bankMembersDTO.setPhone(phone);
		
		//파라미터의 이름과 최종 변환 타입이 동일한 매개변수를 선언할때
//		bankMembersDTO.setUsername(username);
//		bankMembersDTO.setPassword(password);
//		bankMembersDTO.setName(name);
//		bankMembersDTO.setEmail(email);
//		bankMembersDTO.setPhone(phone);
		
		//Bean (객체, DTO, VO)을 선언
		int result = bankMembersService.setJoin(bankMembersDTO);
		if(result>0) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("회원가입 실패!");
		}

		//로그인 폼 페이지로 이동
		//redirect
		return "redirect:../";
	}
	
	//검색어를 입력해서 ID를 찾는 메서드
	@RequestMapping(value = "search.iu", method = RequestMethod.GET)
	public void getSearchByID() throws Exception {
		System.out.println("아이디검색창");

	}
	
	@RequestMapping(value = "search.iu", method = RequestMethod.POST)
	public ModelAndView getSearchByID(String search) throws Exception {
		System.out.println("아이디 정보 검색중");
		ModelAndView mv = new ModelAndView();
		
		List<BankMembersDTO> ar = bankMembersService.getSearchByID(search);
		
		//경로와 데이터를 함께 보낼때
		mv.setViewName("member/list");
		mv.addObject("list", ar);
		
		return mv;
	}
	
}
