package kh.board.member;

import java.io.File;
import java.util.UUID;

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

	@RequestMapping(value = "/toSignUp")
	public String toInput() {
		System.out.println("toInput 요청");
		return "member/signup";
	}
	
	@RequestMapping(value = "/toWelcome")//welcome페이지 요청
	public String toWelcome() {
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
		System.out.println("realPath" + realPath);
		service.signup(dto, file, realPath);
		return "redirect:/";

	}

	
	//로그인
	@ResponseBody
	@RequestMapping(value = "/toLogin")
	public String idCheck(String id, String pw) throws Exception {
		System.out.println("로그인 요청");
		System.out.println(id + pw);
		MemberDTO dto = service.login(id, pw);
		System.out.println(dto);
		 if(dto != null) {
			 return "success";
		 }else{
			 return "fail";
		 }
		
	}
	//아이디 중복체크
	@ResponseBody
	@RequestMapping(value = "/idCheck")
	public String idCheck(String id) throws Exception {
		System.out.println("idCheck 요청");
		boolean count = service.idCheck(id);
		System.out.println("count: " + count);
		 if(count) {
			 return "1";
		 }else{
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
