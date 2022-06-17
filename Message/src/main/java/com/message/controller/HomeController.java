package com.message.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.message.dao.MessageDAO;
import com.message.dto.MessageDTO;

@Controller
public class HomeController {
	@Autowired
	private MessageDAO dao;

	public HomeController() {
		System.out.println("HomeController 인스턴스 생성");
	}

	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/toInput")
	public String toInput() {
		System.out.println("toInput 요청");
		return "input";
		// /WEB-INF/views/input.jsp
	}

	/*
	 * 클라이언트로부터 데이터를 전송받는 방법 1. servlet에서처럼 HttpServletReqeust가 가지고 있는
	 * getParameter("")메서드로 데이터를 전달받을 수 있음.
	 * 
	 * @RequestMapping(value = "/sendInput") public String
	 * sendInput(HttpServletRequest request) { System.out.println("sendInput 요청");
	 * 
	 * String nickname = request.getParameter("nickname"); String message =
	 * request.getParameter("message");
	 * 
	 * System.out.println(nickname + " : " + message);
	 * 
	 * return ""; }
	 */

	/*
	 * 클라이언트로부터 데이터를 전송받는 방법 2. 요청을 받아주는 메서드의 매개변수로 클라이언트가 넘겨주는 데이터의 name이나 key값과
	 * 동일한 이름의 변수를 만들어 데이터를 받아줄 수 있음 name값과 다른 매개변수명을 사용하면 데이터를 받아주지 못함
	 * 
	 * @RequestMapping(value = "/sendInput") public String sendInput(String
	 * nickname, String message) { System.out.println("sendInput 요청");
	 * System.out.println(nickname + " : " + message); return ""; }
	 */

	/*
	 * 클라이언트로부터 데이터를 전송받는 방법 3. command 객체로 데이터를 전달받는 방법 -> dto 타입으로 데이터를 받을 수 있음
	 * 
	 * 클라이언트의 요청이 들어왔을 때 default -> DTO의 기본생성자로 인스턴스를 생성 클라이언트가 넘겨주는 데이터의 name값을
	 * 이용해서 name값과 동일한 이름의 setter를 찾아 그 세터를 이용해 클라이언트가 보낸 데이터를 인스턴스에 셋팅하는 작업 -> 즉
	 * 기본생성자는 있지만 setter가 없는 경우에는 데이터 셋팅이 제대로 이뤄지지 않음.
	 * 
	 * -> command 객체를 사용할때는 기본생성자 / 세터게터 는 반드시 무조건 필수적으로 만듦.
	 */
	/*
	 * contorller에서 jsp로 데이터를 전달하는 방식 Model 이라는 객체를 이용해 값을 셋팅 model.addAttribute(키,
	 * 값);
	 * 
	 * controller의 RequestMapping된 메서드의 모든 default 리턴 방식은 forward
	 */
	@RequestMapping(value = "/sendInput")
	public String sendInput(MessageDTO dto, Model model)throws Exception {
		System.out.println("sendInput 요청");
		System.out.println(dto.toString());

			dao.insert(dto);
		// 데이터 저장이 잘 이뤄졌다면 home.jsp 를 클라이언트가 다시 볼 수 있게끔.
		return "redirect:/";
	}

	@RequestMapping(value = "/toError") // 에러페이지로 이동
	public String toError() {
		return "error";
	}

	@ExceptionHandler // @ExceptionHandler 가 붙은 controller 내부에있으면 예외가 발생했을 해당 메서드를 자동을 실행해줌
					  // 해당 메서드의 매게변수로 전가된 예외가 받아짐.
	public String handleError(Exception e) {
		System.out.println("에러발생");
		e.printStackTrace();
		return "redirect:/toError";
	}
	
	// @ExceptionHandler(처리해주고 싶은 예외명을 명시할 수 있음)
	@ExceptionHandler(NullPointerException.class)
	public String handleNull(Exception e) {
		System.out.println("널포인터 익셉션 발생");
		e.printStackTrace();
		return "error2";
	}

	// return "output"; // 기본이 forward
	// spring 의 redirect 사용 방법
	// return "redirect:요청url"
	/*
	 * RequestMapping 메서드에서 String 값을 반환 -> D.S -> View Resolver를 통해 아래의 값이 완성
	 * /WEB-INF/views/output.jsp -> redirect를 통해 위의 url 이 클라이언트에게 응답되면 클라이언트가 접근할 수
	 * 없는 경로이기 때문에 잘못된 값이 됨 -> 즉 redirect를 할때는 ViewResolver를 거치면 안됨. -> 결과적으로 클라이언트가
	 * 직접 요청하게 될 url은 /toOutput
	 */

	@RequestMapping(value = "/toOutput") // output페이지로 이동
	public String toOutput(Model model)throws Exception {
		System.out.println("toOutput 요청");
		// DB에서 msg 테이블에 있는 데이터를 모두 가져와 output.jsp 에 전달
			ArrayList<MessageDTO> list = dao.selectAll();
			model.addAttribute("list", list);
		return "output";
	}
	
	@RequestMapping(value = "/toOutput2") // output페이지로 이동
	public String toOutput2(Model model)throws Exception {
		System.out.println("toOutput2 요청");
		// DB에서 msg 테이블에 있는 데이터를 모두 가져와 output.jsp 에 전달
			ArrayList<MessageDTO> list = dao.selectAll();
			model.addAttribute("list", list);
		return "output2";
	}

	@RequestMapping(value = "/delete")
	public String delete(int no) throws Exception{
		System.out.println("no :" + no);

			dao.delete(no);
		return "redirect:/toOutput";

	}
	
	// ajax요청값에 대한 반환 -> annotation (@ResponseBody)
	/* ResponseBody 어노테이션을 이용하면 반환값이 V.R 한테 가지않고
	 * 이 controller 메서드를 요청한 jsp쪽 ajax 쪽으로 그대로 반환값이 돌아간다
	 * 그래서 여기서 반환해주느,ㄴ 값은 반드시 요청한 곳에 되돌려주고 싶은 데이터를
	 * 그대로 반환해준다
	 * */
	@ResponseBody
	@RequestMapping(value = "deleteAjax")//ajax 삭제 요청
	public String deleteAjax(int no)throws Exception{
		System.out.println("삭제할 no " + no);
		 dao.delete(no);
		return "success";
	}

	@RequestMapping(value = "/toModify")
	public String modify(int no, Model model) throws Exception{
		System.out.println("no :" + no);
			MessageDTO dto = dao.oneSelect(no);
			model.addAttribute("dto", dto);
		return "modify";
	}

	@RequestMapping(value = "/modify")
	public String modify(MessageDTO dto) throws Exception {
		System.out.println("수정할 데이터 : " + dto.toString());
		dao.update(dto);
		return "redirect:/toOutput";
	}

}
