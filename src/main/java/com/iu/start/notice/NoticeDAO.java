package com.iu.start.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class NoticeDAO {

	public ArrayList<NoticeDTO> getList()throws Exception{
		ArrayList<NoticeDTO> boardDTOs = new ArrayList<NoticeDTO>();
		
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
			NoticeDTO boardDTO = new NoticeDTO();
			boardDTO.setNoticeNum(rs.getLong("NOTICENUM"));
			boardDTO.setNoticeTitle(rs.getString("NOTICETITLE"));
			boardDTO.setNoticeContents(rs.getString("NOTICETCONTENTS"));
			boardDTO.setNoticeWriter(rs.getString("BOARDUSERNAME"));
			boardDTO.setNoticeRedate(rs.getDate("BOARDDATE"));
			boardDTO.setNoticeHit(rs.getLong("BOARDHIT"));
			boardDTOs.add(boardDTO);
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
		return boardDTOs;
		
	}
	
	public NoticeDTO getDetail(NoticeDTO boardDTO)throws Exception{
		NoticeDTO boardDTO2=null;
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BOARD WHERE BOARDNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, boardDTO.getBoardNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			boardDTO2 = new NoticeDTO();
			boardDTO2.setBoardNum(rs.getLong("BOARDNUM"));
			boardDTO2.setBoardTitle(rs.getString("BOARDTITLE"));
			boardDTO2.setBoardDetail(rs.getString("BOARDDETAIL"));
			boardDTO2.setBoardUserName(rs.getString("BOARDUSERNAME"));
			boardDTO2.setBoardDate(rs.getDate("BOARDDATE"));
			boardDTO2.setBoardHits(rs.getInt("BOARDHITS"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return boardDTO2;
	}
	
}
