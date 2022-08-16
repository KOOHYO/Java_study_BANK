package com.iu.start.bankmembers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankMembersService {

	@Autowired
	private BankMembersDAO bankMembersDAO;
	
}
