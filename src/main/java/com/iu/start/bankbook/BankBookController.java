package com.iu.start.bankbook;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@RequestMapping(value = "list", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		System.out.println("List 페이지 접속");
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		
		//return "bankbook/list"; 리턴URL과 요청URL이 똑같으면 리턴 생략가능(viod)
		
		model.addAttribute("list", ar);
		
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Detail 페이지 접속");
		//스프링이 하는 과정을 우리가 직접 객체를 만들어서 보내도 됀다
		ModelAndView mv = new ModelAndView();
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO2 = bankBookDAO.getDetail(bankBookDTO);
		//return "bankbook/detail";
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", bankBookDTO2);
		
		return mv;
	}
	
	// /bankbook/add GET/WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {
		System.out.println("Add 페이지 접속");
		
		// servlet-context.xml을 보면
		// beans:property name="prefix" value="/WEB-INF/views/"이 보임
		// 여기에 /WEB-INF/views/는 RequestMapping
		// beans:property name="suffix" value=".jsp" 가 있기 때문에
		// bankbook/add 만 쓰면 됀다
		//return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method=RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("Add 페이지 접속");
		BankBookDAO bankBookDAO = new BankBookDAO();
		System.out.println(bankBookDTO.getBookname());
		ModelAndView mv = new ModelAndView();
		
		int result = bankBookDAO.setBankBook(bankBookDTO);
		if(result>0) {
			System.out.println("통장 개설 성공!");
		}else {
			System.out.println("통장 개설 실패!");
		}
		
		//return "bankbook/add";
		//상품 등록 후 리스트페이지로
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
}
