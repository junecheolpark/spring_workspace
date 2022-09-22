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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	public HomeController() {
		System.out.println("접속완료");
	}

	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		System.out.println("ㅎ");
		return "list";
	}

	@RequestMapping(value = "/toError")
	public String toError() {
		return "error";
	}

}
