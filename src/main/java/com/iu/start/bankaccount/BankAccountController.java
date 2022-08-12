package com.iu.start.bankaccount;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//속성이 두개이상일때는 속성명을 명시해야하고
//한개이면 value 생략가능!
@RequestMapping("/bankAccount/*")
public class BankAccountController {

	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void add()throws Exception{
		System.out.println("BankAccount Add");
		
	}
	
}
