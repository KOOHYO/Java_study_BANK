<%@page import="com.iu.start.bankmembers.BankMembersDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join" method="post">
		<h1>Join Page</h1>
	    
    	<h2>회원가입</h2>
   		<div>
        	아이디를 입력하세요<br>
        	<input type="text" name="userName"><input type="button" value="중복확인"><br>
       		비밀번호를 입력 하세요<br>
        	<input type="password"><br> 
        	비밀번호를 다시 입력하세요<br>
        	<input type="password" name="passWord"><input type="button" value="비밀번호 확인"><br>
    	</div>
    	<br>
    	<div>
	       이름을 입력하세요<br>
	       <input type="text" name="name"><br>
	       이메일을 입력하세요<br>
	       <input type="email" name="email"><br>
	       전화번호를 입력하세요<br>
	       <input type="text" name="phone"><br>
	       <br>
	       <hr>
	       <br>
	       <input type="submit" value="회원가입완료"><input type="button" value="회원가입취소">
	   </div>
	</form>
</body>
</html>