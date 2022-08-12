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
	<h1>Detail Page</h1>

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
				<td>

				</td>
			</tr>
		</tbody>
	</table>

	<!-- 상대경로 -->
	<a href="./member/login.iu">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join.iu">Join</a>
	
	<a href="./list.iu">리스트보기</a>
	
	<a href="./update.iu?bookNum=${detail.bookNum}">수정하기</a>
</body>
</html>