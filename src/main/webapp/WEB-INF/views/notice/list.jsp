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
					<th>${pageScope.dto.noticeNum}</th>
					<th><a href="detail.iu?noticeNum=${dto.noticeNum}">${pageScope.dto.noticeTitle}</a></th>
					<th>${pageScope.dto.noticeWriter}</th>
					<th>${pageScope.dto.noticeRegdate}</th>
					<th>${pageScope.dto.noticeHit}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="./add.iu?userName=${sessionScope.member.userName}">글 등록</a>
</body>
</html>