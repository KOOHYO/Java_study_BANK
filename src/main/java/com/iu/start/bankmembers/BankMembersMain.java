package com.iu.start.bankmembers;

import java.util.ArrayList;

public class BankMembersMain {

	public static void main(String[] args) {
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		ArrayList<BankMembersDTO> bankMembersDTOs = new ArrayList<BankMembersDTO>();
		//DTO에 값 넣기
//		bankMembersDTO.setUsername("GD");
//		bankMembersDTO.setPassword("123");
//		bankMembersDTO.setName("지용");
//		bankMembersDTO.setEmail("GD@naver.com");
//		bankMembersDTO.setPhone("010-2222-2222");
		try {
			bankMembersDTOs = bankMembersDAO.getSearchByID("GD");
//			while(bankMembersDTOs.size()>0) {
//				System.out.println(bankMembersDTOs.get());
//			}
			System.out.println(bankMembersDTOs.size()>0);
			//int result = bankMembersDAO.setJoin(bankMembersDTO);
			//if(result > 0) {
			//	System.out.println("성공");

			//}else {
			//	System.out.println("실패");
			//}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
