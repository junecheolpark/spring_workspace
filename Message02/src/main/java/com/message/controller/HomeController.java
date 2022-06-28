package com.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.message.dao.MessageDAO;
import com.message.dto.MessageDTO;
import com.message.service.MessageService;

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
		return"redirect:/";
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
