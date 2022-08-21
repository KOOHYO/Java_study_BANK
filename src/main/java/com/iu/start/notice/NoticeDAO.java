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
			noticeDTO.setNoticeContents(rs.getString("NOTICECONTENTS"));
			noticeDTO.setNoticeWriter(rs.getString("NOTICEWRITER"));
			noticeDTO.setNoticeRegdate(rs.getDate("NOTICEREGDATE"));
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
		
		String sql = "SELECT * FROM NOTICE WHERE NOTICENUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, noticeDTO.getNoticeNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			noticeDTO2 = new NoticeDTO();
			noticeDTO2.setNoticeNum(rs.getLong("NOTICENUM"));
			noticeDTO2.setNoticeTitle(rs.getString("NOTICETITLE"));
			noticeDTO2.setNoticeContents(rs.getString("NOTICECONTENTS"));
			noticeDTO2.setNoticeWriter(rs.getString("NOTICEWRITER"));
			noticeDTO2.setNoticeRegdate(rs.getDate("NOTICEREGDATE"));
			noticeDTO2.setNoticeHit(rs.getLong("NOTICEHIT"));
		}
		
		DBConnector.disConnect(rs, st, con);
		
		return noticeDTO2;
	}
	
	public int setUpdate(NoticeDTO noticeDTO)throws Exception{
		
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 작성
		String sql = "UPDATE NOTICE SET NOTICETITLE=?, NOTICECONTENTS=? WHERE NOTICENUM=?";
		
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		st.setString(1, noticeDTO.getNoticeTitle());
		st.setString(2, noticeDTO.getNoticeContents());
		st.setLong(3, noticeDTO.getNoticeNum());
		
		//5. 최종전송
		int result = st.executeUpdate();
		
		
		//6. 자원해제
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
}
