<%@page import="java.util.ArrayList"%>
<%@page import="com.iu.start.bankmembers.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<% ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>)request.getAttribute("list");%>
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
			<%for(BankMembersDTO bankMembersDTO: ar){ %>
			<tr>
				<td><%= bankMembersDTO.getUsername() %></td>
				<td><%= bankMembersDTO.getName() %></td>
				<td><%= bankMembersDTO.getEmail() %></td>
				<td><%= bankMembersDTO.getPhone() %></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>