<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<td>${detailDto.boardNum}</td>
				<td>${detailDto.boardTitle}</td>
				<td>${detailDto.boardUserName}</td>
				<td>${detailDto.boardDate}</td>
				<td>${detailDto.boardHits}</td>
			</tr>
		</tbody>
	</table>
	<br>
	<hr>
	<br>
	<table border="1">
		<thead>
			<tr>
				<th>글내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${detailDto.boardDetail}</td>
			</tr>
		</tbody>
	</table>
	<br>
	<hr>
	<br>
	<button type="button" onclick="location.href='./update.iu'">수정</button>
</body>
</html>