package kh.message2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.message2.dao.MessageDAO;
import kh.message2.dto.MessageDTO;
import kh.message2.service.MessageService;

@Controller
public class HomeController {
	@Autowired
	private MessageDAO dao;
	@Autowired
	private MessageService service;

	public HomeController() {
		System.out.println("HomeController 인스턴스 생성");
	}

	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/toInput")
	public String toInput() {
		return "input";
	}

	@RequestMapping(value = "/sendInput")
	public String sendInput(MessageDTO dto) throws Exception {
		service.insert(dto);
		return "redirect:/";
	}

	@RequestMapping(value = "/toOutputDTO")
	public String toOutputDTO(Model model) throws Exception {
		MessageDTO dto = service.selectOne(1);
		model.addAttribute("dto", dto);
		System.out.println(dto);
		return "outputDTO";
	}

	// 조회
	@RequestMapping(value = "/toOutputList")
	public String toOutputList(Model model) throws Exception {
		List<MessageDTO> list = service.selectList();
		model.addAttribute("list", list);
		System.out.println(list);
		return "outputList";
	}

	// 삭제
	@RequestMapping(value = "/delete")
	public String toOutputList(int no) throws Exception {
		service.delete(no);
		return "redirect:/toOutputList";
	}

	// 수정
	@RequestMapping(value = "/toModify")
	public String toOutputList(int no, Model model) throws Exception {
		MessageDTO dto = service.selectOne(no);
		model.addAttribute("dto", dto);
		return "modify";
	}

	@RequestMapping(value = "/modify")
	public String modify(MessageDTO dto) throws Exception{
		service.update(dto);
		return "redirect:/toOutputList";
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

}
