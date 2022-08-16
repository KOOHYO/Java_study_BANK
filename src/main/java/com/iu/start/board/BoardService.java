package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.util.DBConnector;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	public ArrayList<BoardDTO> getList()throws Exception{
		return boardDAO.getList();
	}
	
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception{
		return boardDAO.getDetail(boardDTO);
	}
	
}
