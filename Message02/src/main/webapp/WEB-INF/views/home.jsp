<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<button type="button" id="toInput">toInput</button>
	<button type="button" id="toOutputDTO">toOutputDTO</button>
	<button type="button" id="toOutputList">toOutputList</button>
	<button type="button" id="toOutputJoin">toOutputJoin</button>
	<!-- toInput버튼을 클릭했을 때는 클라이언트가 input.jsp 페이지를 응답
		toOutput버튼을 클릭했을 때는 output.jsp 페이지를 응답
	 -->
	 
	<script>
		document.getElementById("toInput").onclick = function(){
			location.href = "/toInput";
		}
		document.getElementById("toOutputDTO").onclick = function(){
			location.href = "/toOutputDTO";
		}
		document.getElementById("toOutputList").onclick = function(){
			location.href = "/toOutputList";
		}
		document.getElementById("toOutputJoin").onclick = function(){
			location.href = "/toOutputJoin";
		}
	</script>
</body>
</html>
