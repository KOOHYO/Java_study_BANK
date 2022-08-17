package com.iu.start.bankmembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class BankMembersDAO implements MembersDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.start.bankmembers.BankMembersDAO."; 
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{	
		return sqlSession.selectOne(NAMESPACE+"getLogin",bankMembersDTO);
	}
	
	//bankMembaers 회원가입
	//int타입으로 리턴하는 이유는 insert가 돼었는지 확인하는 방법이 0 아니면 1이상에 숫자가 오기 때문이다
	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}
	
	//검색어를 입력해서 ID를 찾기
	@Override
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		ArrayList<BankMembersDTO> bankMembersDTOs = new ArrayList<BankMembersDTO>();
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 작성
		String sql = "SELECT * "
				+ "FROM BANKMEMBERS "
				+ "WHERE USERNAME LIKE ? ORDER BY USERNAME ASC";
		
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 넣기
		st.setString(1, "%"+search+"%");
		
		//5. 최종 전송
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserName(rs.getString("USERNAME"));
			bankMembersDTO.setPassWord(rs.getString("PASSWORD"));
			bankMembersDTO.setName(rs.getString("NAME"));
			bankMembersDTO.setEmail(rs.getString("EMAIL"));
			bankMembersDTO.setPhone(rs.getString("PHONE"));
			bankMembersDTOs.add(bankMembersDTO);
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		return bankMembersDTOs;
	}
	
}
