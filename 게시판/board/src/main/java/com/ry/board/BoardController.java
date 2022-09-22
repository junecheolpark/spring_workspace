package com.ry.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/board")
@Controller
public class BoardController {
	public BoardController() {
		System.out.println("접속완료");
	}

	@RequestMapping(value = "/toView")
	public String toView() {
		return "view";
	}

	@RequestMapping(value = "/list")
	public String list() {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/toError")
	public String toError() {
		return "error";
	}

}
