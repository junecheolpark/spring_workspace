package com.student.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.dao.StudentDAO;
import com.student.dto.StudentDTO;

@Controller
public class HomeController {
	@Autowired
	private StudentDAO dao;
	
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
	}
	
	
	@RequestMapping(value = "/sendInput")
	public String sendInput(StudentDTO dto, Model model) throws Exception {
		System.out.println("sendInput 요청");
		System.out.println(dto.toString());
		
			dao.insert(dto);
		// 데이터 저장이 잘 이뤄졌다면 home.jsp 를 클라이언트가 다시 볼 수 있게끔. 
		return "redirect:/";
	}
	
	@RequestMapping(value= "/toError") // 에러페이지로 이동
	public String toError() {
		return "error";
	}
	
	@ExceptionHandler
	public String handleError(Exception e) {
		System.out.println("에러발생");
		e.printStackTrace();
		return "redirect:/toError";
	}
	
	
	
	@RequestMapping(value = "/toOutput") // output페이지로 이동
	public String toOutput(Model model)throws Exception {
		System.out.println("toOutput 요청");
		// DB에서 msg 테이블에 있는 데이터를 모두 가져와 output.jsp 에 전달 
			ArrayList<StudentDTO> list = dao.selectAll();
			model.addAttribute("list", list);
		return "output";
	}
	@RequestMapping(value = "/delete")
	public String delete(int no)throws Exception {
		System.out.println("no :" + no);
		
			dao.delete(no);
		return "redirect:/toOutput";
		
	}
	
	@RequestMapping(value = "/toModify")
	public String modify(int no, Model model)throws Exception {
		System.out.println("no :" +no);
			StudentDTO dto= dao.oneSelect(no);
			model.addAttribute("dto", dto);
		return "modify";
	}
	
	@RequestMapping(value = "/modify")
	public String modify(StudentDTO dto)throws Exception {
		System.out.println("수정할 데이터 : "+ dto.toString());
			dao.update(dto);
		return "redirect:/toOutput";
	}
	
	
	
	
	
	
	
}
