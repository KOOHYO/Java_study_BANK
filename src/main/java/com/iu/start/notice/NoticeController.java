package com.iu.start.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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
	public void setUpdate()throws Exception{
		System.out.println("게시판 글 수정");
		
		
		int result = 
		
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public String setUpdate(NoticeDTO noticeDTO, Model model)throws Exception{
		System.out.println("게시판 글 수정");
		
		return "redirect:../";
	}
	
}
