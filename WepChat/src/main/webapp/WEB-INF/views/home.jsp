<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<title>Home</title>
</head>
<body>
	<form action="/toChat" method="get">
		<div class="col text-center">
			<h3>채팅방에서 사용할 닉네임 입력</h3>
			<input type="text" class="form-control w-50" name="nickname">
			<button type="submit" class="btn btn-primary">등록</button>
		</div>
	</form>
</body>
</html>
