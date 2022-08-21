<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Notice Add</h1>
	
	<br>
	<form action="./add.iu" method="post">
		제목을 입력하세요
		<br>
		<input type="text" name="noticeTitle">
		<br>
		내용을 입력하세요
		<br>
		<input type="text" name="noticeContents">
		<br>
		작성자 
		<input type="text" name="noticeWriter">
		<br>
		<input type="submit" value="글 등록 완료"><input type="reset" value="초기화">
		<!-- 위에 말고 밑에는 가능 <butoon type="submit">Add</button> -->
	</form>
	
</body>
</html>