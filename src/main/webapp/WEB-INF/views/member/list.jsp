<%@page import="java.util.ArrayList"%>
<%@page import="com.iu.start.bankmembers.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List Page</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>UserName</th><th>Name</th><th>Email</th><th>Phone</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">			
				<tr>
					<td>${dto.userName}</td>
					<td>${dto.name}</td>
					<td>${dto.email}</td>
					<td>${dto.phone}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${empty sessionScope.member}">
		<button type="button" onclick="location.href='./search'">회원검색</button>
	</c:if>
</body>
</html>