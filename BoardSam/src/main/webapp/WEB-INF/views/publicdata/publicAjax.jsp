<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<title>AJAX 공공데이터</title>
<script>
	$(document).ready(function(){
		$("#getJSON").click(function(){
			$.ajax({
				url : "/public/getJSON"
				,success: function(data){
					console.log(data)
					console.log(data.FestivalBaseInfo)
					$("tbody").empty();
					for(let item of data.FestivalBaseInfo){
						let tr = $("<tr>");
						let td1 = $("<td>").append(item.festivalNm);
						let td2 = $("<td>").append(item.festivalVenue);
						let td3 = $("<td>").append(item.festivalBeginDate);
						let td4 = $("<td>").append(item.festivalEndDate);
						let td5 = $("<td>").append(item.homePage);
						tr.append(td1,td2,td3,td4,td5);
						tr.appendTo("tbody");
					}
				}, error: function(e){
					console.log(e);
				}
			})
		})
		$("#getXML").click(function(){
			$.ajax({
				url : "/public/getXML"
				,success: function(data){
					let items = $(data).find("item");
					console.log(items);
					
					for(let item of items){
						console.log($(item).find("festivalNm").html());
					}
					
				}, error: function(e){
					console.log(e);
				}
			})
		})
	})
</script>
</head>
<body>
	<button type="button" id="getJSON">getJSON</button>
	<button type="button" id="getXML">getXML</button>

	<table border=1>
		<thead>
			<tr>
				<th>축제명</th>
				<th>축제장소</th>
				<th>시작일</th>
				<th>종료일</th>
				<th>홈페이지</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</body>
</html>