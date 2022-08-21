package com.iu.start.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class NoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.start.notice.NoticeDAO.";
	
	public List<NoticeDTO> getList()throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList");
		
	}
	
	public NoticeDTO getDetail(NoticeDTO noticeDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getDetail", noticeDTO);
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
	
	public int setDelete(NoticeDTO noticeDTO)throws Exception{
		
		Connection con = DBConnector.getConnection();
		
		String sql="DELETE NOTICE WHERE NOTICENUM=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, noticeDTO.getNoticeNum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
		
	}
	
	public int setNotices(NoticeDTO noticeDTO)throws Exception{
		Connection con = DBConnector.getConnection();
		
		String sql ="INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, 0)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, noticeDTO.getNoticeTitle());
		st.setString(2, noticeDTO.getNoticeContents());
		st.setString(3, noticeDTO.getNoticeWriter());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;

	}
	
}
