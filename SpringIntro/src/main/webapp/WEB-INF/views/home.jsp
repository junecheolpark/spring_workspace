<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- jsp페이지에서 다른 jsp 페이지로 직접 넘어갈수 없음 
	why? jsp가 위치하고 있는 폴더(WEB-INF)
	
	WEB-INF:외부에서 접근이 불가
	그래서 반드시 모든 요청(단순한 jsp 페이지 요청이라도)은
	controller를 걸쳐서 결과값을 반환하도록 한다.
-->
<a href="/WEB-INF/views/test.jsp">toTest</a>
</body>
</html>
