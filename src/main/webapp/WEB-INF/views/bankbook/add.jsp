<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Add</h1>
	<br>
	<form action="./add.iu" method="post">
		현재 날짜를 입력하세요
		<br>
		<input type="text" name="bookNum">
		<br>
		통장 이름을 입력하세요
		<br>
		<input type="text" name="bookName">
		<br>
		이자율을 입력하세요
		<br>
		<input type="text" name="bookRate">
		<br>
		판매여부 
		<input type="button" name="bookSale" value="가능">
		<br>
		<br>
		<input type="submit" value="통장개설 완료"><input type="reset" value="초기화">
		<!-- 위에 말고 밑에는 가능 <butoon type="submit">Add</button> -->
		
	</form>

</body>
</html>