<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정</h1>
	<form action="./update.iu" method="post">
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
					<td><input type="hidden" name="boardTitle" readonly="readonly" value="${detailDto.boardNum}" >${detailDto.boardNum}</td>
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
	</form>
</body>
</html>