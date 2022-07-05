<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<title>Home</title>
</head>
 <style>
        *{
            box-sizing: border-box;
        }
        div{
            border: 1px solid gray;
        }
        .chatBox{
            width: 400px;
            height: 500px;
        }
        .chatChat{
            width: 400px;
            height: 400px;
            float: bottom;
        }
        .chatBtnDiv{
            width: 80px;
            height: 100px;
            float: right;
        }
        .chatBtn{
            width: 100%;
            height: 100%;
            background-color: orange;
            border: 0;
           
        }
    </style>
</head>
<body>
      <div class="chatBox">
        <div class="chatChat">
            
        </div>
        <textarea claas="message" id="message">asd</textarea>
        <div class="chatBtnDiv">
            
            <button class="chatBtn" id="send">Send</button>
        </div>
    </div>
    <script>
    	// home.jsp 페이지가 로드됐을때 바로 WebSsocket 접속이 이뤄져 스트림이 생성되고
    	// 그후 작성하여 보낸 메세지가 요청이 되거나, 다른 접속자가 보낸 메세지를 응답받을 수 있게 만듦.
    	// 웹소켓 객체 생성할때 반드시 서버의 ip 주소값은 실제 ip 주소를 이용
    	let ws = new WebSocket("ws://192.168.200.175//chat");
    	// 80번 쓰지않으면:8090 이런식으로 써줘야함
    	$("#send").click(function(){
    		let message = $("#message").val();
    		if(message != ""){ // message가 빈값이 아닐떄만 전송
    			$("#message").val(""); //입력창 비우기
    			ws.send(message); //서버의 endpoint에 메세지를 보내는 함수
    		}
    	})
    	
    	// endpoint로부터 전송된 메세지 받기
    	ws.onmessage = function(message){
    		console.log(message.data);
    		let msgDiv = $("<div>").append(message.data);
    		$(".chatChat").append(msgDiv);
    	}
    </script>
</body>
</body>
</html>
