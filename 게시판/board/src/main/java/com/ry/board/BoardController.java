package com.ry.board;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	public BoardController() {
		System.out.println("접속완료");
	}

	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		System.out.println("ㅎ");
		List<Board_masterDTO> mdto = service.selectTest();
		model.addAttribute("mdto", mdto);
		return "list";
	}
	
	@RequestMapping(value = "/board/toView")
	public String toView() {
		return "view";
	}

	@RequestMapping(value = "/board/list")
	public String list() {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/board/toError")
	public String toError() {
		return "error";
	}

}
