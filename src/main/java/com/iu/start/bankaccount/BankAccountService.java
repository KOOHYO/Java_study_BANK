package com.iu.start.bankaccount;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.util.DBConnector;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		return bankAccountDAO.add(bankAccountDTO);
	}
	
}
