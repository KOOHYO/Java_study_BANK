package com.iu.start.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.util.DBConnector;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO boardDAO;
	
	public ArrayList<NoticeDTO> getList()throws Exception{
		return boardDAO.getList();
	}
	
	public NoticeDTO getDetail(NoticeDTO boardDTO)throws Exception{
		return boardDAO.getDetail(boardDTO);
	}
	
}
