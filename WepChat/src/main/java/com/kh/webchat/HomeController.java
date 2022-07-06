package com.kh.webchat;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	@Autowired
	private HttpSession session;
	@Autowired
	private ChatService service;
	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value= "/toChat")// 채팅 페이지 요청
	public String toChat(String nickname, Model model) throws Exception{
		System.out.println("nickname : " + nickname);
		// HttpSession에 nickname 을 등록해둘 것.
		session.setAttribute("nickname", nickname);
		List<ChatDTO> list = service.select();
		model.addAttribute("list", list);
		return "chat";
	}
	
}
