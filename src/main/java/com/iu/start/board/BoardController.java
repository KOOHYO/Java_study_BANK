package com.iu.start.board;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	

	@RequestMapping (value = "list.iu", method = RequestMethod.GET)
	public String getList(Model model)throws Exception {
		System.out.println("게시판목록 접속");
		BoardDAO boardDAO = new BoardDAO();
		ArrayList<BoardDTO> boardDTOs = boardDAO.getList();

		model.addAttribute("list", boardDTOs);
		
		return "board/list";
	}
	
	@RequestMapping (value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception {
		System.out.println("게시판 글 상세보기 접속");
		ModelAndView mv = new ModelAndView();
		BoardDAO boardDAO = new BoardDAO();	
		boardDTO = boardDAO.getDetail(boardDTO);
		
		mv.setViewName("board/detail");
		mv.addObject("detailDto", boardDTO);
		
		return mv;
	}
	
}
