package com.iu.start.bankmembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class BankMembersDAO implements MembersDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.start.bankmembers.BankMembersDAO.";
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		//sqlSession.쿼리메서드명(namespace+"id명")
		//: Mapper 보내야하는 parameter가 없을 때
		//sqlSession.쿼리메서드명(namespace+"id명", 파라미터값)  
		//: Mapper 보내야하는 parameter가 있을 때
		return sqlSession.selectOne(NAMESPACE+"getLogin",bankMembersDTO);
	}
	
	//bankMembaers 회원가입
	//int타입으로 리턴하는 이유는 insert가 돼었는지 확인하는 방법이 0 아니면 1이상에 숫자가 오기 때문이다
	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setJoin",bankMembersDTO);
	}
	
	//검색어를 입력해서 ID를 찾기
	@Override
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getSearchByID", search);
	}
	
}
