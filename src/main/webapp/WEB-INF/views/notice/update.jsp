<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Page</h1>
	<form action="">
		<div>
			<input type="text" name=noticeNum readonly="readonly" value="${dto.noticeNum}">
			제목을 수정하세요
			<br>
			<input type="text" name="noticeTitle" value="${dto.noticeTitle}">
			<br>
			내용을 수정하세요
			<br>
			<textarea rows="100" cols="100" name="noticeContents"></textarea>
			<br>
			<br>
			<button type="submit">수정완료</button>
		</div>
		
	</form>
</body>
</html>