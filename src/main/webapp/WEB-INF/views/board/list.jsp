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
	<h3>게시판</h3>

	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<th>${pageScope.dto.boardNum}</th>
					<th><a href="detail.iu?boardNum=${dto.boardNum}">${pageScope.dto.boardTitle}</a></th>
					<th>${pageScope.dto.boardUserName}</th>
					<th>${pageScope.dto.boardDate}</th>
					<th>${pageScope.dto.boardHits}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>