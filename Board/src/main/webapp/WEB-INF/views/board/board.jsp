<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 부트스트랩 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

<title>게시판</title>
</head>
<style>
a {
	text-decoration-line: none;
	font-weight: bold;
	color: black;
}
</style>
<body>

	<div class="container">
		<div align="right">
			<input type="button" class="btn btn-danger" id="toLogout"
				value="로그아웃">
		</div>
		<div class="text-center">
			<h3>게시판</h3>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">글번호</th>
					<th scope="col">제목</th>
					<th scope="col">글쓴이</th>
					<th scope="col">날짜</th>
					<th scope="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty list}">
						<c:forEach items="${list}" var="dto">

							<tr>
								<td>${dto.seq_board}</td>
								<td><a href="/board/detail?title=${dto.title}&seq_board=${dto.seq_board}">${dto.title}</a></td>
								<td>${dto.writer_nickname}</td>
								<td>${dto.written_date}</td>
								<td>${dto.view_count}</td>
							</tr>

						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<th colspan="5">등록된 글이 없습니다.</th>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>

		</table>
		<div align="right">
			<input type="button" class="btn btn-success" id="backBtn" value="뒤로가기">
			<input type="button" class="btn btn-success" id="toWrite" value="글쓰기">
			
		</div>
	</div>

	<script>
		// 뒤로가기 요청
		$("#backBtn").click(function() {
			location.href = "/member/toWelcome";
		})
		
		// 로그아웃 요청
		$("#toLogout").click(function() {
			location.href = "/member/logout";
		})

		// 로그아웃 요청
		$("#toWrite").click(function() {
			location.href = "/board/towrite";
		})
	</script>
</body>
</html>