<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
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
<title>메인</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col text-center">
				<h3>로그인</h3>
			</div>
		</div>
		<div class="row">
			<div class="col">아이디</div>
		</div>
		<div class="row">
			<div class="col">
				<input type="text" class="form-control" name="id">
			</div>
		</div>

		<div class="row">
			<div class="col">비밀번호</div>
		</div>
		<div class="row">
			<div class="col">
				<input type="password" class="form-control" name="pw">
			</div>
		</div>

		<div class="row">
			<div class="form-check mt-2">
				<input type="checkbox" class="form-check-input"
					id="flexCheckDefault" name="id"> <label
					class="form-check-label" for="flexCheckDefault"> 아이디 기억하기 </label>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col text-center">
			<button type="button" class="btn btn-primary">로그인</button>
			<button type="button" class="btn btn-warning" id="signUp">회원가입</button>
		</div>
	</div>

	<script>
		document.getElementById("signUp").onclick = function() {
			location.href = "/member/toSignUp"; // member∼ 로 시작하는
		}
		
	</script>
</body>
</html>
