package com.iu.start.bankmembers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;

//이 클래스는 Controller 역할,
//Container (생명주기를 만드는 것) 에게 이 클래스의 객체를 생성을 위임한다
@Controller 
@RequestMapping(value = "/member/*")
public class MemberController {

	// annotation(어너테이션)
	// @ : 설명+실행
	
	// /member/login
	// 이 URL주소가 오면 이 메서드를 실행 해 주세요
	@RequestMapping(value = "login")
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	// join /member/join GET
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 GET 실행");
		
		return "member/join";
	}
	
	// join /member/join POST
	// 오버로딩 : 매개변수를 다르게 
	// 그래서 입력받는 HttpServletRequest request를 작성
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {//매개변수로 String username 이라쓰면 
		System.out.println("회원가입 POST 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		
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
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		if(result>0) {
			System.out.println("회원가입 성공!");
		}else {
			System.out.println("회원가입 실패!");
		}

		
		return "member/join";
	}
	
}
