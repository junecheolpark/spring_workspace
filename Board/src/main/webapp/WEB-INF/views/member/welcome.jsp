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

<title>메인</title>
</head>
<style>
.profile {
	overflow: hidden;
	border: 1px solid rgb(104, 103, 103);
	border-radius: 50%;
	width: 100px;
	height: 100px;
	border-radius: 50%;
}

#profile_default {
	width: 100px;
	height: 100px;
	border-radius: 50%;
}

#profile_image {
	width: 100px;
	height: 100px;
	border-radius: 50%;
}

#profile_message {
	font-weight: bold;
}

.form-control[readonly] {
	background-color: transparent;
}

.btnBox>button {
	width: 24%;
}
</style>

<body>
	<div class="container">
		<form id="profileForm">
			<div class="row text-center mt-2">
				<div class="col-12 m-auto p-0 profile">
					<c:choose>
						<c:when test="${empty loginSession.profile_image}">
							<img src="/resources/images/default_profile.jpg"
								id="profile_default">
						</c:when>
						<c:otherwise>
							<img src="/profile/${loginSession.profile_image}"
								id="profile_image">
						</c:otherwise>
					</c:choose>

				</div>
				<div class="col-12 my-2">
					<c:choose>
						<c:when test="${empty loginSession.profile_message}">
							<input type="text" class="form-control text-center border-0"
								id="profile_message" name="profile_message" value="상태메세지가 없습니다"
								readonly>
						</c:when>
						<c:otherwise>
							<input type="text" class="form-control text-center border-0"
								id="profile_message" name="profile_message"
								value="${loginSession.profile_message}" readonly>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="col-12 d-flex justify-content-center">
					<input type="file" class="form-control w-50 d-none" id="file"
						name="file">
				</div>
				<div class="col-12 my-2 btnBox">
					<button type="button" class="btn btn-primary" id="changeProfile">프로필변경</button>
					<button type="button" class="btn btn-primary d-none"
						id="saveProfile">프로필저장</button>
					<button type="button" class="btn btn-secondary" id="toLogout">로그아웃</button>
					<%-- 내정보 모달 띄워줌 --%>
					<button type="button" class="btn btn-warning"
						data-bs-toggle="modal" data-bs-target="#exampleModal">내정보</button>
					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">내 정보</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<div class="row ">
										<form id="nickForm">
											<div class="col-12">아이디</div>
											<div class="col my-2">
												<input type="text" class="form-control" id="id" name="id"
													value="${loginSession.id}" readonly>
											</div>
										</form>
									</div>




									<div class="row">
										<div class="col-12">닉네임</div>
										<div class="col my-2">
											<input type="text" class="form-control" id="nickname"
												name="nickname" value="${loginSession.nickname}" readonly>
										</div>
									</div>
									
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">닫기</button>
									<button type="button" class="btn btn-warning"
										id="modify_nickname">수정</button>
									<button type="button" class="btn btn-primary d-none"
										id="complet_nickname">완료</button>
								</div>
							</div>
						</div>
					</div>
					<%-- 모달 끝--%>
					<button type="button" class="btn btn-success" id="toBoard">게시판</button>
				</div>
			</div>
		</form>
	</div>

	<script>
		// 로그아웃 요청
		$("#toLogout").click(function() {
			location.href = "/member/logout";
		})

		// 게시판 페이지 요청
		$("#toBoard").click(function() {
			location.href = "/board/toBoard";
		})

		//내정보 수정 눌렀을때
		$("#modify_nickname").on("click", function() {
			$("#nickname").attr({
				readonly : false
			}).focus();
			$("#modify_nickname").addClass("d-none");
			$("#complet_nickname").removeClass("d-none");

		})
		//내정보 완료
		$("#complet_nickname").on("click", function() {
			$("#nickname").attr({
				readonly : true
			}).focus();
			$("#modify_nickname").removeClass("d-none");
			$("#complet_nickname").addClass("d-none");

		})

		// 정보수정

		$("#complet_nickname").on("click", function() {
			let id = $("#id").val();
			let nickname = $("#nickname").val();
			console.log(id, nickname);

			$("#exampleModal").modal('hide');
			$.ajax({
				url : "/member/modify_nickname",
				type : "post",
				data : {
					id : id,
					nickname : nickname
				},
				success : function(data) {
					console.log(data);
					if (data == "success") {
						alert("수정 성공");
					} else if (data == "fail") {
						alert("수정 실패. 다시 ㄱㄱ");
					}
				},
				error : function(e) {
					console.log(e);
				}
			})
		})

		// 프로필 저장버튼을 클릭했을때
		$("#saveProfile").on("click", function() {
			$("#saveProfile").addClass("d-none");
			$("#changeProfile").removeClass("d-none");
			$("#file").addClass("d-none"); // 파일태그 숨기기
			$("#profile_message").attr("readonly", true); // 메세지 입력창 다시 readonly 적용
			/*
				jQuery의 serialize 함수를 이용해서 form을 전송할 수 있는 형태로변환
				파일을 전송해야하는 경우에는 serialize 로 데이터를 변환해도 파일데이터가 정상적으로 변환x
				
				자바스크립트의 FormData 객체에 우리가 만들어 둔 form을 자바스크립트 객체로 넘겨서 만든 변수를
				ajax의 data 영역에 셋팅
			
			 */
			console.log(document.getElementById("profileForm"));
			let data = new FormData(document.getElementById("profileForm"));
			$.ajax({
				url : "/member/modifyProfile",
				type : "post",
				enctype : "multipart/form-data",
				contentType : false,
				processData : false,
				data : data,
				success : function(data) {
					console.log(data);
					if (data == "success") {
						alert("수정 성공");
					} else if (data == "fail") {
						alert("수정 실패. 다시 ㄱㄱ");
					}
				},
				error : function(e) {
					console.log(e);
				}

			})
		})

		// 프로필 변경 버튼을 클릭했을때
		$("#changeProfile").on("click", function() {
			$("#file").removeClass("d-none");
			$("#profile_message").attr({
				readonly : false
			}).focus();
			$("#changeProfile").addClass("d-none");
			$("#saveProfile").removeClass("d-none");

		})

		// 사용자가 profile_image 파일태그를 이용해 프로필 사진을 선택했을때 profile_default 이미지 태그에 선택된 사진을 띄워주는 작업
		document.getElementById("file").onchange = function() {
			let reader = new FileReader();
			reader.readAsDataURL(this.files[0])// 
			reader.onload = function(e) {
				document.getElementById("profile_image").src = e.target.result;
			}
		}
	</script>
</body>
</html>