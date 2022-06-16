package com.kh.Message;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/toInput")
	public String toInput() {
		System.out.println("toInput 요청");
		return "input";
//		/WEB-INF/views/input.jsp
	}

	/*
	 * 클라이언트로부터 데이터를 전송받는법
	 * 1.HttpServletRequest이용해
	 * @RequestMapping(value = "/sendInput") public String
	 * sendInput(HttpServletRequest request) { System.out.println("sendInput 요청");
	 * 
	 * String nickname = request.getParameter("nickname"); String message =
	 * request.getParameter("message"); System.out.println(nickname + ":" +
	 * message); return ""; }
	 */
	
	/*
	 * 2. 요청을 받아주는 메서드의 매개변수로 클라이언트가 넘겨주는 데이터의
	 * name이나 key값과 동일한 이름의 변수를 만들어 데이터를 받아줄 수 있음
	 
	@RequestMapping(value = "/sendInput")
	public String sendInput(String nickname, String message) {
		System.out.println("sendInput 요청");
		System.out.println(nickname + ":"+ message);
		return "";
	}
	*/
	
	/*
	 * 3. commend 객체로 데이터를 전달받는 방법
	 * ->dto 타입으로 데이터를 받을 수 있음
	 * 
	 * 클라이언트의 요청이 들어왔을때
	 * default -> dto의 기본생성자로 인스턴스를 생성
	 * 클라이언트가 넘겨주는 데이터의 name값을 이용해서
	 * name값과 동일한 이름의 setter를 찾아
	 * 그 세터를 이용해 클라이언트가 보낸 데이터를 인스턴스에 셋팅하는 작업
	 * -> 즉 기본생성자는 있지만 setter가 없는 경우에는
	 * 데이터 셋팅이 제대로 이뤄지지 않음
	 * 기본생성자./ 세터게터는 무조건 필수적으로 만듬
	 */
	
	/*
	 * controller의 RequestMapping된 메서드의
	 * 모든 default 리턴방식은 forward
	 * 
	 * */
	@RequestMapping(value = "/sendInput")
	public String sendInput(MessageDTO dto,Model model) {
		System.out.println("sendInput 요청");
		System.out.println(dto.toString());
		model.addAttribute("dto", dto);
		
		return "output"; // 기본이 forward
		// redirect -> response.sendRedirect("url");
		//Spring에서의 redirect
 	}
	
	
	@RequestMapping(value = "/toOutput")
	public String toOutput() {
		System.out.println("toOutput요청");
		return "output";
	}
	
	
	
}
