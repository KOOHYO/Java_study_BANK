<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Detail Page</h1>
	<% if(bankBookDTO != null){ %>
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
				<td><%= bankBookDTO.getBooknum() %></td>
				<td><%= bankBookDTO.getBookname() %></td>
				<td><%= bankBookDTO.getBookrate() %></td>
				<td><%= bankBookDTO.getBooksale() %></td>
				<td>
					<% if(bankBookDTO.getBooksale()==1){ %>
						판매중
					<%}else{ %>
						판매금지
					<%} %>
				</td>
			</tr>
		</tbody>
	</table>
	<%}else{ %>
		데이터가 없습니다
	<%} %>
	<!-- 상대경로 -->
	<a href="./member/login">Login</a>
	<!-- 절대경로 -->
	<a href="/member/join">Join</a>
	
	<a href="./list">리스트보기</a>
</body>
</html>