package com.iu.start.notice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/board/*")
public class NoticeController {
	
	@Autowired
	private NoticeService boardService;
	
	@RequestMapping (value = "list.iu", method = RequestMethod.GET)
	public String getList(Model model)throws Exception {
		System.out.println("게시판목록 접속");
		ArrayList<NoticeDTO> boardDTOs = boardService.getList();

		model.addAttribute("list", boardDTOs);
		
		return "board/list";
	}
	
	@RequestMapping (value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView getDetail(NoticeDTO boardDTO) throws Exception {
		System.out.println("게시판 글 상세보기 접속");
		ModelAndView mv = new ModelAndView();	
		boardDTO = boardService.getDetail(boardDTO);
		
		mv.setViewName("board/detail");
		mv.addObject("detailDto", boardDTO);
		
		return mv;
	}
	
}
