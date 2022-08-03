package com.iu.start.test;

import java.sql.Connection;

import com.iu.start.util.DBConnector;

public class DBConnectionTest {

	public static void main(String[] args) {
		//DBC클래스에 있는 겟을 호출!
		try {
			Connection con = DBConnector.getConnection();
			System.out.println(con != null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
