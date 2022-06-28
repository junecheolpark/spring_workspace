<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Output</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>no</th>
				<th>nickname</th>
				<th>message</th>
				<th>modify</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.no}</td>
					<td>${dto.nickname}</td>
					<td>${dto.message}</td>
					<td><button type="button" class="modifyBtn" value="${dto.no}">수정</button></td>
					<td><button type="button" class="deleteBtn" value="${dto.no}">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		//수정버튼을 클릭했을때
		let modifyBtn = document.getElementsByClassName("modifyBtn");
		
		for(let i = 0; i <modifyBtn.length; i++){
			modifyBtn[i].addEventListener("click", function(){
				location.href = "/toModify?no="+this.value;
			});
		}
		//삭제 버튼을 클릭했을 떄 confirm 창을 띄워줌 -> 진짜 삭제 하겠다라고 하면 seq번호를 서버에 전송
		let deleteBtn = document.getElementsByClassName("deleteBtn");

		for(let i = 0; i <deleteBtn.length; i++){
			deleteBtn[i].addEventListener("click", function(){
				let answer = confirm("정말 삭제하겠수?");
				if(answer){// 만약 answer에 true값이 담겨있으면 삭제
					//let val1 = e.target.value;
					let val2 = this.value;
					
					location.href = "/delete?no="+val2; //서버에 지금눌린 삭제 버튼의 value값을 전송해 삭제
				}
			});
		}
		
		
		
	</script>
</body>
</html>