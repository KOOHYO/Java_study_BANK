package com.iu.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.iu.start.util.DBConnector;

public class BankBookDAO implements BookDAO {

	//BankBook 테이블에 Insert
	//BookNum  : 현재시간을 밀리세컨즈로 변환해서 입력
	//BookSale : 1로 입력
	//여기서 int타입은 INSERT, UPDATE, DELETE 밖에없다
	//디비에서 컬럼 데이터타입을 변경해야함!
	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		//1. DB연결
		Connection con = DBConnector.getConnection();
				
		//2. SQL문작성
		String sql = "INSERT INTO BANKBOOK "
				+ "VALUES(?, ?, ?, 1)";
		
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		Calendar ca = Calendar.getInstance();
		
		st.setLong(1, ca.getTimeInMillis());
		st.setString(2, bankBookDTO.getBookName());
		st.setDouble(3, bankBookDTO.getBookRate());
		
		//5. 최종전송
		int result = st.executeUpdate();
		
		//6. 자원해제
		DBConnector.disConnect(st, con);
		
		return result;
	}

	//BankBook 모든 데이터를 조회 최신순으로
	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		ArrayList<BankBookDTO> bankBookDTOs = new ArrayList<BankBookDTO>();
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문작성
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		
		
		//5. 최종전송
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
		 	BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getLong("bookNum"));
			bankBookDTO.setBookName(rs.getString("bookName"));
			bankBookDTO.setBookRate(rs.getDouble("bookRate"));
			bankBookDTO.setBookSale(rs.getInt("bookSale"));
			bankBookDTOs.add(bankBookDTO);
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
		return bankBookDTOs;
	}

	//Sale컬럼 수정(업데이트)
	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
//		int select = bankBookDTO.getBooksale();
//		select = 1;
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문작성
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ?  WHERE BOOKNUM = ?";
		
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		st.setInt(1, bankBookDTO.getBookSale());
		st.setLong(2, bankBookDTO.getBookNum());
		
		//5. 최종전송
		int result = st.executeUpdate();

		//6. 자원해제
		DBConnector.disConnect(st, con);
		
		return result;
	}

	//BookNum 값으로 조회
	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		BankBookDTO bankBookDTO2 = null;//만약 값이 없다면 널로 리턴하려고 널값을 초기값으로 넣어준다
		
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문작성
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		
		//3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		st.setLong(1, bankBookDTO.getBookNum());
		
		//5. 최종전송
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			bankBookDTO2 = new BankBookDTO();
			bankBookDTO2.setBookNum(rs.getLong("bookNum"));
			bankBookDTO2.setBookName(rs.getString("bookName"));
			bankBookDTO2.setBookRate(rs.getDouble("bookRate"));
			bankBookDTO2.setBookSale(rs.getInt("bookSale"));
		}
//		else {
//			return null; 이렇게하면 바로 종료되기때문에 다른방법으로!
//		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
		return bankBookDTO2;//만약 값이 없다면 널로 리턴이 돼고 있다면 값이 대입돼어 리턴한다
	}

	@Override
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		
		// 1. DB연결
		Connection con = DBConnector.getConnection();
		
		// 2. SQL문 작성
		String sql = "UPDATE BANKBOOK SET BOOKNAME = ?, BOOKRATE = ? WHERE BOOKNUM = ?";
		
		// 3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		// 4. ?값 세팅
		st.setString(1, bankBookDTO.getBookName());
		st.setDouble(2, bankBookDTO.getBookRate());
		st.setLong(3, bankBookDTO.getBookNum());
		
		// 5. 최종전송
		int result = st.executeUpdate();
		
		// 6. 자원해제
		DBConnector.disConnect(st, con);
		
		return result;
	}

	
	
}
