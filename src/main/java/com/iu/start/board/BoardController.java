package com.iu.start.board;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

	@RequestMapping (value = "list.iu", method = RequestMethod.GET)
	public String getList(Model model)throws Exception {
		System.out.println("게시판목록 접속");
		BoardDAO boardDAO = new BoardDAO();
		ArrayList<BoardDTO> boardDTOs = boardDAO.getList();
		
		System.out.println(boardDTOs);
		model.addAttribute("list", boardDTOs);
		
		return "board/list";
	}
	
	@RequestMapping (value = "detail.iu", method = RequestMethod.GET)
	public void getDetail() {
		System.out.println("게시판 글 상세보기 접속");
	}
	
}
