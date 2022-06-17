<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input</title>
</head>
<body>
	<form method="post" action="/sendInput">
		<label>name : </label>
		<input type="text" name="name" placeholder="이름 입력">
		<label>memo : </label>
		<input type="text" name="memo" placeholder="내용 입력">	
		<button type="submit">전송</button>
	</form>
</body>
</html>