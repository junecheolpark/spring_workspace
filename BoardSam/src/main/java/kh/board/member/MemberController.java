package kh.board.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

// 클라이언트의 요청 중 /member로 시작하는 모든 요청은 이 컨트롤러가 받음
@RequestMapping("/member")
@Controller
public class MemberController {
	@Autowired
	private MemberService service;

	@RequestMapping("/login") 
	@ResponseBody	// 로그인 요청 
	public String login(String id, String pw) throws Exception{
		System.out.println(id + " : " + pw);
		MemberDTO dto = service.login(id, pw);
		if(dto != null) {
			return "success";
		}
		return "fail";
	}
	
	@RequestMapping(value = "/toSignup")//singup페이지 요청
	public String toSignup() {
		return "member/signup";
	}
	
	@RequestMapping(value = "/checkLogin") //ID중복검사 요청
	@ResponseBody	
	public String checkLogin(String id) throws Exception{
		if(service.checkLogin(id)) return "available";
		else return "unavailable";
	}
	
	@RequestMapping(value = "/signup") // 회원가입 요청
	public String signup(MemberDTO dto, MultipartFile file, HttpSession session) throws Exception{
		System.out.println(dto.toString());
		System.out.println("file : " + file);
		String realPath = session.getServletContext().getRealPath("profile");
		System.out.println("realPath : " + realPath);
		service.signup(dto, file, realPath);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/toWelcome")//welcome페이지 요청
	public String toWelcome() {
		return "member/welcome";
	}
	
	@ExceptionHandler
	public String toError(Exception e) {
		System.out.println("예외 발생");
		e.printStackTrace();
		return "redirect:/toError";
	}
}
