package kh.board.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

// 클라이언트의 요청중 /member로 시작하는 모든 요청은 이 컨트롤러가 받음
@RequestMapping("/member")
@Controller
public class MemberController {


	@RequestMapping(value = "/toSignUp")
	public String toInput() {
		System.out.println("toInput 요청");
		return "/member/signup";
	}
	
	
	/* 파일 데이터는 MultipartFile 형 변수로 받아줌.
	 * Multyfile 형 변수의 이름은 클라이언트에서 넘겨주는 파일태그의 이름
	 * MultipartFile을 받아줄때에는 반드시 함께 받아주는 일반데이터의 멤버필드명과 겹치지 않도록 함.
	 * */
	@RequestMapping(value = "/signup")
	public String signu(MemberDTO dto, MultipartFile file) throws Exception{
		System.out.println(dto.toString());
		System.out.println("file : " + file);
		return "";
	}
	
	@ExceptionHandler
	public String toError(Exception e) {
		System.out.println("예외 발생");
		e.printStackTrace();
		return "redirect:/toError";
	}
}
