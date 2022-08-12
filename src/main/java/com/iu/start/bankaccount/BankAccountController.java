package com.iu.start.bankaccount;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.bankmembers.BankMembersDTO;

@Controller
//속성이 두개이상일때는 속성명을 명시해야하고
//한개이면 value 생략가능!
@RequestMapping("/bankAccount/*")
public class BankAccountController {
	private BankAccountDAO bankAccountDAO;
	
	public BankAccountController() {
		this.bankAccountDAO = new BankAccountDAO();
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO, HttpSession session )throws Exception{
		System.out.println("BankAccount Add");
		//DTO : userName(세션에서 받기), bookNum(파라미터로 받기)
		System.out.println(bankAccountDTO.getBookNum());
		//Attribute는 키(String)와벨류(Object)로 이루어짐
		//그러므로 꺼낼때 다형성
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		bankAccountDTO.setUserName(bankMembersDTO.getUserName());
		
		int result = this.bankAccountDAO.add(bankAccountDTO);
		if(result>0) {
			System.out.println("통장가입성공!");
		}else {
			System.out.println("통장가입실패!");
		}
		
		return "redirect:../bankbook/list.iu";
	}
	
}
