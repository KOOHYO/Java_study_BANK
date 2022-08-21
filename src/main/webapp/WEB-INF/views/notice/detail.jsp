<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 상세 페이지</h1>
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
			<tr>
				<td>${detailDto.noticeNum}</td>
				<td>${detailDto.noticeTitle}</td>
				<td>${detailDto.noticeWriter}</td>
				<td>${detailDto.noticeRegdate}</td>
				<td>${detailDto.noticeHit}</td>
			</tr>
		</tbody>
	</table>
	<br>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>글내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${detailDto.noticeContents}</td>
			</tr>
		</tbody>
	</table>
	
	<c:if test="${empty sessionScope.member}">
	<a href="../member/login.iu">로그인</a>
	<a href="../member/join.iu">회원가입하기</a>
	</c:if>
	
	<c:if test="${not empty sessionScope.member}">
	<a href="./update.iu?noticeNum=${detailDto.noticeNum}">글 수정하기</a>
	<a href="./delete.iu?noticeNum=${detailDto.noticeNum}">글 삭제하기</a>
	<a href="./add.iu">글 등록하기</a>
	</c:if>
</body>
</html>