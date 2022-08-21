package com.iu.start.notice;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping (value = "list.iu", method = RequestMethod.GET)
	public String getList(Model model)throws Exception {
		System.out.println("게시판목록 접속");
		ArrayList<NoticeDTO> noticeDTOs = noticeService.getList();

		model.addAttribute("list", noticeDTOs);
		
		return "notice/list";
	}
	
	@RequestMapping (value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView getDetail(NoticeDTO noticeDTO) throws Exception {
		System.out.println("게시판 글 상세보기 접속");
		ModelAndView mv = new ModelAndView();	
		noticeDTO = noticeService.getDetail(noticeDTO);
		
		mv.setViewName("notice/detail");
		mv.addObject("detailDto", noticeDTO);
		
		return mv;
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public String setUpdate(NoticeDTO noticeDTO, Model model)throws Exception{
		System.out.println("게시판 글 수정");
		
		model.addAttribute("dto", noticeDTO);
		
		return "notice/update";
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public ModelAndView setUpdate(NoticeDTO noticeDTO)throws Exception{
		System.out.println("게시판 글 수정");
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.setUpdate(noticeDTO);
		if(result>0) {
			System.out.println("수정성공!");
			mv.setViewName("notice/list.iu");
			mv.addObject("dto", noticeDTO);	
		}else {
			System.out.println("수정실패!");
		}
		
		return mv;
	}
	
}
