package com.iu.start.notice;

import java.util.ArrayList;
import java.util.List;

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
		List<NoticeDTO> noticeDTOs = noticeService.getList();

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
	public void setUpdate(NoticeDTO noticeDTO, Model model)throws Exception{
		System.out.println("게시판 글 수정");
		noticeDTO = noticeService.getDetail(noticeDTO);
		
		model.addAttribute("dto", noticeDTO);
		//여기서 리턴안하면 벨류값과 똑같은 JSP페이지로 이동
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(NoticeDTO noticeDTO)throws Exception{
		System.out.println("게시판 글 수정");
	
		int result = noticeService.setUpdate(noticeDTO);
		if(result>0) {
			System.out.println("수정성공!");

		}else {
			System.out.println("수정실패!");
		}
		
		return "redirect:./detail.iu?noticeNum="+noticeDTO.getNoticeNum();
	}
	
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public String setDelete(NoticeDTO noticeDTO)throws Exception{
		System.out.println("글 삭제");
		int result = noticeService.setDelete(noticeDTO);
		if(result>0) {
			System.out.println("글 삭제 성공!");
		}else {
			System.out.println("글 삭제 실패..");
		}
		
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void setNotice()throws Exception{
		System.out.println("글 등록페이지 접속");
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public String setNotice(NoticeDTO noticeDTO)throws Exception{
		System.out.println("글 등록페이지 접속");
		
		int result = noticeService.setNotices(noticeDTO);
		if(result>0) {
			System.out.println("글 등록 성공!");
		}else {
			System.out.println("글 등록 실패..");
		}
		
		return "redirect:./list.iu?noticeNum="+noticeDTO.getNoticeNum();
	}
	
}
