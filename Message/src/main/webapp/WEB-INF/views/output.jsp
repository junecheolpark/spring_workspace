<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<th>nickname</th>
			<th>message</th>
		</thead>
		<tbody>
			<tr>
				<td>${dto.nickname}</td>
				<td>${dto.message}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>