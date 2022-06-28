<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한 행의 DTO 뿌리기</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>no</th>
				<th>nickname</th>
				<th>message</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${dto.no}</td>
				<td>${dto.nickname}</td>
				<td>${dto.message}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>