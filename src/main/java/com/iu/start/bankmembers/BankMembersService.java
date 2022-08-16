package com.iu.start.bankmembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.util.DBConnector;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	//bankMembaers 회원가입
	//int타입으로 리턴하는 이유는 insert가 돼었는지 확인하는 방법이 0 아니면 1이상에 숫자가 오기 때문이다
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		return bankMembersDAO.setJoin(bankMembersDTO);
	}
	
	//검색어를 입력해서 ID를 찾기
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		return bankMembersDAO.getSearchByID(search);
	}
	
}
