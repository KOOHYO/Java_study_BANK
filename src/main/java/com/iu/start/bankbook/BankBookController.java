package com.iu.start.bankbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@RequestMapping(value = "list", method=RequestMethod.GET)
	public String list() {
		System.out.println("List 페이지 접속");
		
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Detail 페이지 접속");
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		BankBookDTO bankBookDTO2 = bankBookDAO.getDetail(bankBookDTO);
		
		return "bankbook/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		System.out.println("Add 페이지 접속");
		
		
		return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method=RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Add 페이지 접속");
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		int result = bankBookDAO.setBankBook(bankBookDTO);
		if(result>0) {
			System.out.println("통장 개설 성공!");
		}else {
			System.out.println("통장 개설 실패!");
		}
		
		return "bankbook/add";
	}
	
}
