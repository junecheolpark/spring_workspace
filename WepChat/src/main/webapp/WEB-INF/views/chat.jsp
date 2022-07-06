<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<title>채팅창</title>
	<style>
		*{border: 1px solid grey;}
		.container{
				width: 300px;
				height: 500px;
		}
		.row:first-child{ height: 80%;}
		.row:last-child{height: 20%;}
		#message{resize:none}
	
	</style>
</head>
<body>
	<h3>${nickname}님의 채팅방</h3>
	<div class="container w-50">
		<div class="row">
			<div class="col" id="chat-content">
				<c:if test="${not empty list}">
					<c:forEach items="${list}" var="dto">
						<div>${dto.nickname} : ${dto.message}</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<div class="row">
			<div class="col-10 p-0 input-message">
				<textarea class="form-control h-100" id="message"></textarea>
			</div>
			<div class="col-2 p-0 input-button">
				<button class="btn btn-warning w-100 h-100 p-2" id="send">Send</button>
			</div>
		</div>
	</div>
	
	<script>
		// home.jsp 페이지가 로드됐을때 바로 WebSocket 접속이 이뤄져 스트림이 생성되고
		// 그 후 작성하여 보낸 메세지가 요청이 되거나, 다른 접속자가 보낸 메세지를 응답받을 수 있게 만듦.
		// 웹소켓 객체 생성할때 반드시 서버의 ip 주소값은 실제 ip 주소를 이용 
		let ws = new WebSocket("ws://192.168.200.175/chat");
		
		$("#send").click(function(){
			let message = $("#message").val();
			if(message != ""){ // message가 빈값이 아닐때만 전송
				$("#message").val(""); // 입력창 비우기
				ws.send(message); // 서버의 endpoint에 메세지를 보내는 함수
			}
		})
		
		// endpoint로부터 전송된 메세지 받기
		ws.onmessage = function(message){
			console.log(message.data);
			// 넘어 온 json 처럼 생긴 문자열을 실제 json형(객체)으로 변환
			let msg = JSON.parse(message.data);
			console.log(msg);
			
			let msgDiv = $("<div>").append(msg.nickname + " : " + msg.message);
			$("#chat-content").append(msgDiv); 
		}
	
	</script>
</body>
</html>
