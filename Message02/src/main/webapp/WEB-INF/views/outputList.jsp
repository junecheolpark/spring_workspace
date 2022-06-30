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
	
	<form id="searchForm1">
		<h2>검색 ver1</h2>
		<span>
			<input type="text" name="keyword" placeholder="nickname 검색">
			<button type="button" id="search1">검색1</button> 
		</span>
	</form>
	
	<form id="searchForm2">
		<h2>검색 ver2</h2>
		<span>
			<select name="category">
				<option value="all">전체</option>
				<option value="no">번호</option>
				<option value="nickname">닉네임</option>
				<option value="message">내용</option>
			</select>
			<input type="text" name="keyword" placeholder="검색">
			<button type="button" id="search2">검색2</button> 
		</span>
	</form>
	
	<form id="searchForm3">
		<h2>검색 ver3</h2>
		<span>
			<input type="checkbox" id="all">전체
			<input type="checkbox" class="category" name="no" value="no">번호
			<input type="checkbox" class="category" name="nickname" value="nickname">닉네임
			<input type="checkbox" class="category" name="message" value="message">메세지			
			<input type="text" name="keyword" placeholder="검색">
			<button type="button" id="search3">검색3</button> 
		</span>
	</form>
	
	<script>
		// 검색 ver3
		$("#search3").on("click", function(){
			let data = $("#searchForm3").serialize();
			console.log(data);
			
			 $.ajax({
				url : "/search3"
				, type : "get"
				, data : data
				, success: function(data){
					console.log(data);
					makeDynamicEl(data);
				}, error : function(e){
					console.log(e);
				}
			}); 
		})
		
		$("#all").on("click", function(){ // 전체를 체크했을때/풀었을때
			// 방법  1 $(".category").prop("checked", this.checked);
			if(this.checked){ // 전체를 선택했을때
				$(".category").prop("checked", true);
				$(".category").click(function(e){
					e.preventDefault();
					// 지금 발생한 이벤트가 원래 수행해야하는 동작을 수행하지 않겠다					
				});
			}else{ // 전체를 해제했을때
				$(".category").prop("checked", false);
				$(".category").unbind(); // 사용자가 직접 등록한 이벤트를 제거.
			}
		})
		
		
		// 검색 ver2
		$("#search2").on("click", function(){
			let data = $("#searchForm2").serialize();
			console.log(data);
			
			$.ajax({
				url : "/search2"
				, type : "get"
				, data : data
				, success: function(data){
					console.log(data);
					makeDynamicEl(data);
				}, error : function(e){
					console.log(e);
				}
			});
		})
	
	
	
	
	
	
	
	
	
		// 검색 ver1
		$("#search1").on("click", function(){
			let data = $("#searchForm1").serialize();
			console.log(data);
			$.ajax({
				url : "/search1"
				, type : "get"
				, data : data
				, success: function(data){
					console.log(data);
					makeDynamicEl(data);
				}, error : function(e){
					console.log(e);
				}
			});
		})
		
		function makeDynamicEl(data){
			$("tbody").empty();
			if(data.length == 0){ // 검색 결과 없음
				let tr = $("<tr>");
				let td = $("<td colspan=5>").append("검색 결과가 없습니다.");
				tr.append(td);
				tr.appendTo("tbody");
			}else{ //검색 결과 있음 
				for(let dto of data){
					let tr = $("<tr>");
					let td1 = $("<td>").append(dto.no);
					let td2 = $("<td>").append(dto.nickname);
					let td3 = $("<td>").append(dto.message);
					let modifyBtn = $("<button>").attr({
						type : "button"
						, class : "modifyBtn"
						, value : dto.no
					}).append("수정");
					let td4 = $("<td>").append(modifyBtn);
					let deleteBtn = $("<button>").attr({
						type : "button"
						, class : "deleteBtn"
						, value : dto.no
					}).append("삭제");
					let td5 = $("<td>").append(deleteBtn);
					
					tr.append(td1, td2, td3, td4, td5);
					tr.appendTo("tbody");
				}
			}
		}
	
	
		// 수정 버튼을 클릭했을 때 서버로 no 를 넘겨줌 -> 해당 no의 데이터를 DB로부터 가져와서 수정페이지에 뿌려줄 것. 
		let modifyBtn = document.getElementsByClassName("modifyBtn");
		
		for(let i = 0; i < modifyBtn.length; i++){
			modifyBtn[i].addEventListener("click", function(){
				location.href = "/toModify?no="+this.value; // 서버에 현재 눌린 수정 버튼 value 전송
			});
		}
	
		// 삭제 버튼을 클릭했을 때 confirm 창을 띄워줌 -> 진짜 삭제하겠다라고 하면 그때 seq 번호를 서버에 전송해서 삭제
		let deleteBtn = document.getElementsByClassName("deleteBtn");
		
		for(let i = 0; i < deleteBtn.length; i++){
			deleteBtn[i].addEventListener("click", function(e){
				let answer = confirm("정말 삭제하시겠습니까?");
				console.log(answer);
				// 만약 answer에 true 값이 담겨있으면 if문이 실행
				// 만약 answer에 false 값이 담겨있으면 if문 건너뜀.
				if(answer){ 
					let val1 = e.target.value; // 콜백펑션의 매개변수를 통해 value를 가져오는 방식
					let val2 = this.value; // 자기 자신을 참조하는 this 키워드를 통해 value를 가져오는 방식
					
					location.href = "/delete?no="+val1; // 서버에 지금 눌린 삭제 버튼의 value값을 전송해 삭제 
				}
			});
		}
	
	</script>	
</body>
</html>