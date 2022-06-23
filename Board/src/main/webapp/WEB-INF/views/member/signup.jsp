<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>회원가입</title>
</head>
<style>
.profile {
	overflow: hidden;
	border: 1px solid rgb(104, 103, 103); border-radius : 50%;
	width: 100px;
	height: 100px;
	border-radius: 50%;
}

#profile_default {
	width: 100px;
	height: 100px;
	border-radius: 50%;
}
</style>
<body>
	<form id="signupForm" action="/member/signup" method="post" enctype="multipart/form-data">
		<div class="container">
			<div class="row text-center">
				<div class="col-12">
					<h3>회원가입</h3>
				</div>
				<div class="col-12 m-auto p-0 profile">
					<img src="/resources/images/default_profile.jpg"
						id="profile_default">
				</div>
				<div class="col-12">
					<p>프로필 등록</p>
				</div>
				<div class="col-8 m-auto">
					<input class="form-control" type="file" id="formFileMultiple" name="file"
						multiple />
				</div>
			</div>
			<div class="row">
				<div class="col-12 my-2">아이디</div>

				<div class="col-12 text-align:center">
					<input type="text" class="form-control" id="user_id" name="id">
				</div>
				<div class="col mt-2" align="right">
					<button type="button" class="btn btn-danger float-right" id="idCheckBtn">중복
						확인</button>
				</div>
			</div>

			<div class="row my-1">
				<div class="col-12">
					<p>비밀번호</p>
				</div>
				<div class="col-12">
					<input type="password" class="form-control" id="user_pw" name="pw">
				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<p>닉네임</p>
				</div>
				<div class="col-12">
					<input type="text" class="form-control" id="user_nickname" name="nickname">
				</div>
			</div>

		</div>
		<div class="row">
			<div class="col text-center mt-2">
				<button type="button" class="btn btn-secondary" id="cancel">취소</button>
				<button type="submit" class="btn btn-primary" id="signBtn">가입</button>
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

		document.getElementById("cancel").onclick = function() {
			location.href = "/";
		}
		//아이디 체크
		$("#idCheckBtn").on("click", function(){
			let user_id = $("#user_id").val();
			console.log(user_id);

            $.ajax({
                url: "/member/idCheck", // ID중복체크
                type: "post",
                data: {id :user_id},
                success: function (data) {
                	console.log(data);
                	if (data > 0) {   
                		alert("사용가능한 아이디입니다.");
                		
                	}else{
                		alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
                	}
                },
                error: function(e){
					console.log(e);
				}
            });
		})
		//중복, 정규식 검사
		$("#signBtn").on("click", function(){
            let regexId = /[a-zA-Z0-9]{6,12}/;
            let regexPw = /^[a-zA-Z0-9]{6,20}$/
            let regexNickname = /^[a-zA-Z0-9ㄱ-힣]{4,10}$/

            if ($("#user_id").val() === ""){
                alert("아이디를 입력해 주세요.");
				$('#user_id').focus();
				return;
            }else if (!regexId.test($("#user_id").val())) {
				alert("형식에 맞지않는 아이디입니다.");
				$('#user_pw').focus();
				return;
			}else if ($("#user_pw").val() === ""){
                alert("비밀번호를 입력해 주세요.");
				$('#user_pw').focus();
				return;
            }else if (!regexPw.test($("#user_pw").val())) {
				alert("형식에 맞지않는 비밀번호입니다.");
				$('#user_pw').focus();
				return;
			}else if ($("#user_nickname").val() === ""){
                alert("닉네임을 입력해 주세요.");
				$('#user_nickname').focus();
				return;
            }else if (!regexNickname.test($("#user_pw").val())) {
				alert("형식에 맞지않는 닉네임입니다.");
				$('#user_nickname').focus();
				return;
			}
          
            document.getElementById("signupForm").submit();
        })
	</script>
</body>
</html>