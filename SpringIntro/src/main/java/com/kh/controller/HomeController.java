package com.kh.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// annotation : 주석(설명)
// 개발자가 아닌 컴파일러/ 스프링 컨테이너가 이해할 수 있는 설명
@Controller
public class HomeController {
	
	public HomeController() {
		System.out.println("홈컨트롤러 인스턴스 생성");
	}
	
	
	/*
	 *  RequestMapping : 핸들러매핑이 요청url과
	 * 	해당 메서드를 매핑시켜줄 수 있게해주는 어노테이션
	 * 
	 * */
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping(value = "/test2")
	public String test2() {
		return "temp/test2";
	}
	
}
