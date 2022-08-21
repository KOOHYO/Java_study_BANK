package com.iu.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.util.DBConnector;

@Service
public class BankBookService {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setBankBook(bankBookDTO);
	}

	//BankBook 모든 데이터를 조회 최신순으로
	public ArrayList<BankBookDTO> getList() throws Exception {
		return bankBookDAO.getList();
	}

	//Sale컬럼 수정(업데이트)
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {	
		return bankBookDAO.setChangeSale(bankBookDTO);
	}

	//BookNum 값으로 조회
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getDetail(bankBookDTO);//만약 값이 없다면 널로 리턴이 돼고 있다면 값이 대입돼어 리턴한다
	}

	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	public int setDelete(BankBookDTO bankBookDTO)throws Exception{
		return bankBookDAO.setDelete(bankBookDTO);
		
	}
	
}
