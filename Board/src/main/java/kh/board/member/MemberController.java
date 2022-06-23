package kh.board.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

// 클라이언트의 요청중 /member로 시작하는 모든 요청은 이 컨트롤러가 받음
@RequestMapping("/member")
@Controller
public class MemberController {
	/*
	 * @Autowired private MemberDAO dao;
	 */
	@Autowired
	private MemberService service;
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/toSignUp")
	public String toInput() {
		System.out.println("toInput 요청");
		return "member/signup";
	}

	@RequestMapping(value = "/toWelcome") // welcome페이지 요청
	public String toWelcome() {
		System.out.println("welcom접속");
		return "member/welcome";
	}

	/*
	 * 파일 데이터는 MultipartFile 형 변수로 받아줌. Multyfile 형 변수의 이름은 클라이언트에서 넘겨주는 파일태그의 이름
	 * MultipartFile을 받아줄때에는 반드시 함께 받아주는 일반데이터의 멤버필드명과 겹치지 않도록 함.
	 */
	@RequestMapping(value = "/signup")
	public String signup(MemberDTO dto, MultipartFile file, HttpSession session) throws Exception {
		System.out.println(dto.toString());
		System.out.println("file : " + file);
		String realPath = session.getServletContext().getRealPath("profile");
		String profile_image = service.uploadProfile(file, realPath);
		dto.setProfile_image(profile_image);
		service.signup(dto);
		return "redirect:/";

	}

	@RequestMapping(value = "/modifyProfile") // 프로필 수정 요청
	@ResponseBody
	public String modifyProfile(String profile_message, MultipartFile file) throws Exception {
		System.out.println("message:" + profile_message);
		System.out.println("file :" + file);

		// 1. 서버의 profile 폴더에 새로운 프로필 사진 업로드
		// 만약 사용자가 프로필사진을 변경하지 않았다면(업로드 x)
		// 새로운 프로필 사진을 업로드 x
		if (!file.isEmpty()) {
			String realPath = session.getServletContext().getRealPath("profile");
			// 파이을 업로드하는 service의 메서드를 호출하고 반환값으로 실제 저장된 파일명을 반환
			String profile_image = service.uploadProfile(file, realPath);
			// loginSession 안에 들어있는 dto의 profile_image 멤버필드 값을 새롭게 업로드된 파일명으로 변경
			((MemberDTO) session.getAttribute("loginSession")).setProfile_image(profile_image);
		} // 만약 사용자가 프로필 사진 수정을 안했다면(파일 업로드 x) 원래의 값을 유지
			// loginSession에 DTO -> profile_image -> 사용자가 원래가지고있는 프로필사진의 이름값

		// 넘어온 변경된 프로필 메서지도 loginSession의 dto에 다시셋팅
		((MemberDTO) session.getAttribute("loginSession")).setProfile_message(profile_message);
		// 2. member테이블의 현재 프로필 수정중인 메버의 데이터를 수정
		int rs = service.modifyProfile((MemberDTO) session.getAttribute("loginSession"));
		if (rs > 0) {
			return "success";
		} else {
			return "fail";
		}

	}


	@RequestMapping(value = "/modify_nickname") // 프로필 수정 요청
	@ResponseBody
	public String modify_nickname(String nickname, String id) throws Exception{
		System.out.println(id + nickname);
		((MemberDTO) session.getAttribute("loginSession")).setNickname(nickname);
		int rs = service.modifyProfile((MemberDTO) session.getAttribute("loginSession"));
		if (rs > 0) {
			return "success";
		} else {
			return "fail";
		}
		
	}
	// 로그인
	@ResponseBody
	@RequestMapping(value = "/toLogin")
	public String idCheck(String id, String pw) throws Exception {
		System.out.println("로그인 요청");
		System.out.println(id + pw);
		MemberDTO dto = service.login(id, pw);

		if (dto != null) {
			session.setAttribute("loginSession", dto);
			System.out.println(dto);
			return "success";
		} else {
			return "fail";
		}

	}

	// 아이디 중복체크
	@ResponseBody
	@RequestMapping(value = "/idCheck")
	public String idCheck(String id) throws Exception {
		System.out.println("idCheck 요청");
		boolean count = service.idCheck(id);
		System.out.println("count: " + count);
		if (count) {
			return "1";
		} else {
			return "0";
		}

	}

	@ExceptionHandler
	public String toError(Exception e) {
		System.out.println("예외 발생");
		e.printStackTrace();
		return "redirect:/toError";
	}
}
