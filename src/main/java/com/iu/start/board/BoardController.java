package com.iu.start.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping (value = "list.iu", method = RequestMethod.GET)
	public String getList(Model model)throws Exception {
		System.out.println("게시판 목록페이지 접속");
		ArrayList<BoardDTO> boardDTOs = boardService.getList();
 
		model.addAttribute("list", boardDTOs);
		
		return "board/list";
	}
	
	@RequestMapping (value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception {
		System.out.println("게시판 글 상세페이지 접속");
		ModelAndView mv = new ModelAndView();	
		boardDTO = boardService.getDetail(boardDTO);
		
		mv.setViewName("board/detail");
		mv.addObject("detailDto", boardDTO);
		
		return mv;
	}
	
	@RequestMapping (value = "update.iu", method = RequestMethod.GET)
	public void setUpdate()throws Exception {
		System.out.println("글수정 페이지 접속");
		
	}
	
	@RequestMapping (value = "update.iu", method = RequestMethod.POST)
	public void setUpdate(BoardDTO boardDTO)throws Exception {
		System.out.println("글수정 페이지 접속");
		
	}
	
}
