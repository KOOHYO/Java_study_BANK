<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!-- 요청이 발생하면 생성, 응답이 나가면 소멸 : Requst --> 
<%-- BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail"); --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>통장 상세정보</h1>

	<table border="1">
		<thead>
			<tr>
				<th>BookNum</th>
				<th>BookName</th>
				<th>BookRate</th>
				<th>BookSale</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${requestScope.detail.getBookNum()}</td><!-- 속성명 잘 보기! -->
				<td>${requestScope.detail.bookName}</td>
				<td>${detail.bookRate}</td>
				<td>${detail.bookSale}</td>
			</tr>
		</tbody>
	</table>
	
	<c:if test="${not empty sessionScope.member}">
	<a href="../member/login.iu">로그인</a>
	<a href="../member/join.iu">회원가입하기</a>
	</c:if>
	
	<c:if test="${empty sessionScope.member}">
	<a href="./update.iu?bookNum=${detail.bookNum}">통장수정</a>
	<a href="./delete.iu?bookNum=${detail.bookNum}">통장삭제</a>
	<a href="../bankAccount/add.iu?bookNum=${detail.bookNum}">통장가입하기</a>
	</c:if>
	
	<a href="./list.iu">통장리스트</a>
</body>
</html>