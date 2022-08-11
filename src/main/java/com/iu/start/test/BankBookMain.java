package com.iu.start.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import com.iu.start.bankbook.BankBookDAO;
import com.iu.start.bankbook.BankBookDTO;
import com.iu.start.bankmembers.BankMembersDTO;

public class BankBookMain {

	public static void main(String[] args) {
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		ArrayList<BankBookDTO> bankBookDTOs = new ArrayList<BankBookDTO>();
//		bankBookDTO.setBooknum(System.currentTimeMillis());
//		bankBookDTO.setBookname("여행저축");
//		bankBookDTO.setBookrate(12.12);
//		bankBookDTO.setBooksale();
		
//		bankBookDTO.setBooknum(1659514911403L);
		
		 try {
			 
			 bankBookDTO.setBookName("funny");
			 bankBookDTO.setBookRate(7);
			 bankBookDTO.setBookNum(20220810);
			 int result = bankBookDAO.setUpdate(bankBookDTO);
			 if(result>0) {
				 System.out.println("수정성공!");
			 }else {
				 System.out.println("수정실패!");
			 }
			 
//			 BankBookDTO bankBookDTO2 = new BankBookDTO();
//			 bankBookDTO2 = bankBookDAO.getDetail(bankBookDTO);
//			 System.out.println(bankBookDTO2.getBooknum());
//			 System.out.println(bankBookDTO2.getBookname());
//			 System.out.println(bankBookDTO2.getBookrate());
//			 System.out.println(bankBookDTO2.getBooksale());
//			 System.out.println(bankBookDTO2 != null);
			 
//			 int result = bankBookDAO.setChangeSale(bankBookDTO);
//			 if (result > 0) {
//				 System.out.println("성공!");
//			 }else {
//				 System.out.println("실패!");
//			 }
			 
//			 bankBookDTOs = bankBookDAO.getList(bankBookDTO);
//			 for(int i=0; i<bankBookDTOs.size(); i++) {
//				 System.out.println(bankBookDTOs.get(i).getBooknum());
//				 System.out.println(bankBookDTOs.get(i).getBookname());
//				 System.out.println(bankBookDTOs.get(i).getBookrate());
//				 System.out.println(bankBookDTOs.get(i).getBooksale());
//			 }
			 
//			int result = bankBookDAO.setBankBook(bankBookDTO);
//			if(result > 0) {
//				System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
