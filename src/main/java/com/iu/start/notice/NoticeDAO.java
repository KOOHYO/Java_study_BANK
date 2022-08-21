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
		ArrayList<NoticeDTO> noticeDTOs = new ArrayList<NoticeDTO>();
		
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 작성
		String sql = "SELECT * FROM NOTICE ORDER BY NOTICENUM DESC";
		
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		
		//5. 최종전송
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNoticeNum(rs.getLong("NOTICENUM"));
			noticeDTO.setNoticeTitle(rs.getString("NOTICETITLE"));
			noticeDTO.setNoticeContents(rs.getString("NOTICETCONTENTS"));
			noticeDTO.setNoticeWriter(rs.getString("NOTICEWRITER"));
			noticeDTO.setNoticeRedate(rs.getDate("NOTICEREGDATE"));
			noticeDTO.setNoticeHit(rs.getLong("NOTICEHIT"));
			noticeDTOs.add(noticeDTO);
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
		return noticeDTOs;
		
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO)throws Exception{
		NoticeDTO noticeDTO2=null;
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BOARD WHERE BOARDNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, noticeDTO.getNoticeNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			noticeDTO2 = new NoticeDTO();
			noticeDTO2.setNoticeNum(rs.getLong("NOTICENUM"));
			noticeDTO2.setNoticeTitle(rs.getString("NOTICETITLE"));
			noticeDTO2.setNoticeContents(rs.getString("NOTICETCONTENTS"));
			noticeDTO2.setBoardUserName(rs.getString("BOARDUSERNAME"));
			noticeDTO2.setBoardDate(rs.getDate("BOARDDATE"));
			noticeDTO2.setBoardHits(rs.getInt("BOARDHITS"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return noticeDTO2;
	}
	
}
