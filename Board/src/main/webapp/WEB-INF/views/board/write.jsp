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

<title>글쓰기</title>
</head>
<style>

#profile_default {
	width: 300px;
	height: 300px;
	border-radius: 50%;
}
</style>
<body>
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
				<div class="col-12 m-auto p-0 profile">
					<img src="/resources/images/default_profile.jpg"
						id="profile_default">
				</div>

			</div>
			<div class="row">
				<div class="my-2">제목</div>
				<div class="d-none">
					<input type="text" id="writer_nickname" name="writer_nickname"
						value="${loginSession.nickname}"> <input type="text"
						id="writer_id" name="writer_id" value="${loginSession.id}">
				</div>

				<div class="text-align:center">
					<input type="text" class="form-control" id="title" name="title"
						placeholder="제목을 입력해주세요.">
				</div>

			</div>

			<div class="row">
				<div class="my-2">파일첨부</div>

				<div class="">
					<input class="form-control" type="file" id="formFileMultiple"
						name="file" multiple />
				</div>

			</div>

			<div class="row">
				<div class="">
					<p>내용</p>
				</div>
				<div class="">
					<textarea class="form-control h-100" rows="7" id="content"
						name="content"></textarea>
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
	// 사용자가 profile_image 파일태그를 이용해 프로필 사진을 선택했을때 profile_default 이미지 태그에 선택된 사진을 띄워주는 작업
	document.getElementById("formFileMultiple").onchange = function() {
		let reader = new FileReader(); // 사용자가 파일태그를 이용해서 파일을 선택했을때 사용자의 로컬에있는 파일의 정보를 브라우저에서 사용 가능하게끔 해주는클래스

		reader.readAsDataURL(this.files[0])// -> 인자값으로 file객체

		// onload 함수가 트리거됨-> onload 이벤트가 발생했을때 콜백펑션안에서 위에있는 이미지 태그의 src에 이미지를 띄워줄수 있는 경로값으로 대체
		reader.onload = function(e) {
			// e.target.result -> 브라우저에서 바로 해석(로드)이 가능하게끔 변환된 이미지의 경로값
			console.log("e.target ", e.target.result);
			// 위에있는 이미지 태그의 src 속성값을 변환된 이미지 경로값으로 셋팅 해주기 (사용자가 선택한 이미지 띄우기)
			document.getElementById("profile_default").src = e.target.result;
		}

		// 사용자의 파일 -> /desktop/a.jsp
		// <img src="/desktop/a.jpg"/>
	}
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