<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/sendInput">
		<label>nickname : </label>
		<input type="text" name="nickname" placeholder="닉네임 입력">
		<label>message : </label>
		<input type="text" name="message" placeholder="메세지 입력">
		<button type="submit">전송</button>
		
	</form>
</body>
</html>