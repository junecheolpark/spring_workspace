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

<title>상세페이지</title>
</head>
<body>
<img src="/profile/${filelist.content_image}"
								id="profile_image">
	<div class="container">
		<form id="writeForm" action="/board/write" method="post"
			enctype="multipart/form-data">
			<div align="right">
				<input type="button" class="btn btn-danger" id="toLogout"
					value="로그아웃">
			</div>

			<div class="row text-center">
				<div class="text-center">
					<h3>글쓰기</h3>
				</div>


			</div>
			<div class="row">
				<div class="row m-0 p-0">
					<div class="col-6 mt-3">제목</div>
					<div class="col-6 mt-3">날짜</div>
				</div>
				<div class="row m-0 p-0">
					<div class="col">
						<input type="text" class="form-control" id="title" name="title"
							value="${dto.title}">
					</div>
					<div class="col">
						<input type="text" class="form-control" id="title" name="title"
							value="${dto.written_date}">
					</div>


				</div>


				<div class="row m-0 p-0">
					<div class="col">
						<p>닉네임</p>
					</div>
					<div class="col">
						<p>아이디</p>
					</div>
				</div>
				<div class="row m-0 p-0">
					<div class="col">
						<input type="text" class="form-control" id="writer_nickname"
							name="writer_nickname" value="${dto.writer_nickname}">
					</div>
					<div class="col">
						<input type="text" class="form-control" id="writer_id"
							name="writer_id" value="${dto.writer_id}">
					</div>
				</div>


			</div>

			<div class="row">
				<div class="mt-3">
					<p>내용</p>
				</div>
				<div class="">
					<textarea class="form-control h-100" rows="7" id="content"
						name="content">${dto.content}</textarea>
				</div>
			</div>
			<div class="row">
				<div class="col text-center mt-2">
					<button type="button" class="btn btn-secondary" id="cancelBtn">뒤로가기</button>
					<button type="button" class="btn btn-primary" id="writeBtn">등록</button>
				</div>
			</div>
	</div>
	</form>

	<script>
		//글쓰기
		$("#writeBtn").on("click", function() {
			document.getElementById("writeForm").submit();
		})

		// 로그아웃 요청
		$("#toLogout").click(function() {
			location.href = "/member/logout";
		})

		// 뒤로가기 요청
		$("#cancelBtn").click(function() {
			location.href = "/board/toBoard";
		})
	</script>
</body>
</html>