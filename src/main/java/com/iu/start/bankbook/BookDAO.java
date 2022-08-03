package com.iu.start.bankbook;

import java.util.ArrayList;

public interface BookDAO {
	
	//BankBook 테이블에 Insert
	//BookNum  : 현재시간을 밀리세컨즈로 변환해서 입력
	//BookSale : 1로 입력
	//여기서 int타입은 INSERT, UPDATE, DELETE 밖에없다
	public int setBankBook(BankBookDTO bankbookDTO)throws Exception;
	
	//BankBook 모든 데이터를 조회 최신순으로
	public ArrayList<BankBookDTO> getList(BankBookDTO bankBookDTO)throws Exception;
	
	//Sale컬럼 수정(업데이트)
	public int setChangeSale(BankBookDTO bankbookDTO)throws Exception;
	
	//BookNum 값으로 조회
	public BankBookDTO getDetail(BankBookDTO bankBookDTO)throws Exception;
	
}
