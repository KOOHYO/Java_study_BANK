<%@page import="java.util.ArrayList"%>
<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Book List</h1>
	<!-- /book/list -->
	
	<!-- /book/detail   jsp:derail.jsp -->
	<!-- link 주소는 상대경로 작성 -->
	<!-- 이 페이지의 URL주소를 보고 경로를 결정 -->
	<!-- <a href="./detail">Detail</a> 이렇게 써도 됀다 -->
	
	<table border="1">
		<thead>
			<tr>
				<th>BookNum</th><th>BookRate</th>
			</tr>
		</thead>
		<tbody>
			<%for(BankBookDTO bankBookDTO : ar){ %>
				<tr>
				<!-- 파라미터 보낼때 띄어쓰기 하지말기 예를들어 detail?bookNum=... -->
					<td><a href="detail?bookNum=<%= bankBookDTO.getBookNum()%>"><%= bankBookDTO.getBookName()%></a></td>
					<td><%= bankBookDTO.getBookRate()%></td>
				</tr>
			<%} %>
		</tbody>
	</table>
	
	<a href="./add.iu">상품등록</a>
	
</body>
</html>