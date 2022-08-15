package com.iu.start.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

	@RequestMapping (value = "list.iu", method = RequestMethod.GET)
	public void getList()throws Exception {
		System.out.println("list 접속");
	}
	
}
