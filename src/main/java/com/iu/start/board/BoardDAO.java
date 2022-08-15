package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BoardDAO {

	public ArrayList<BoardDTO> getList()throws Exception{
		ArrayList<BoardDTO> boardDTOs = new ArrayList<BoardDTO>();
		
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 작성
		String sql = "SELECT * FROM BOARD ORDER BY BOARDNUM DESC";
		
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		
		//5. 최종전송
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setBoardNum(rs.getLong("BOARDNUM"));
			boardDTO.setBoardTitle(rs.getString("BOARDTITLE"));
			boardDTO.setBoardDetail(rs.getString("BOARDDETAIL"));
			boardDTO.setBoardUserName(rs.getString("USERNAME"));
			boardDTO.setBoardDate(rs.getDate("BOARDDATE"));
			boardDTO.setBoardHits(rs.getInt("BOARDHITS"));
			boardDTOs.add(boardDTO);
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
		return boardDTOs;
		
	}
	
}
