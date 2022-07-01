<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<title>Output</title>
<style>
	span{border : 1px solid black; padding: 10px;}
</style>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>nickname</th>
				<th>message</th>
				<th>address</th>
				<th>phone</th>
			</tr>
		</thead>
		<tbody>
		${list}
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.nickname}</td>
					<td>${dto.MESSAGE}</td>
					<td>${dto.MESSAGE}</td>
					<td>${dto.MESSAGE}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	
	<script>
	
	
	</script>	
</body>
</html>