package com.iu.start.bankaccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.start.util.DBConnector;

public class BankAccountDAO {

	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 작성
		String sql = "INSERT INTO BANKACCOUNT "
				+ "VALUES(ACCOUNT_SEQ.NEXTVAL, ?, ?, sysdate)";
		
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		st.setString(1,bankAccountDTO.getUserName());
		st.setLong(2, bankAccountDTO.getBookNum());
		
		//5. 최종전송
		int result = st.executeUpdate();
		
		//6. 자원해제
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
}
