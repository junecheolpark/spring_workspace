package kh.message.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.message.dto.MessageDTO;
import kh.message.service.MessageService;

@Controller
public class HomeController {
	@Autowired
	private MessageService service;

	@RequestMapping(value = "/") // home 페이지 요청
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/toInput") // input 페이지 요청
	public String toInput() {
		return "input";
	}
	
	@RequestMapping(value = "/sendInput") // 메세지 저장
	public String sendInput(MessageDTO dto) throws Exception{
		service.insert(dto);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/toOutputDTO") // 한 행의 DTO 가져오기
	public String toOutputDTO(Model model) throws Exception{
		MessageDTO dto = service.selectOne(14); // 14번 데이터 가져오기 
		model.addAttribute("dto", dto);
		return "outputDTO";
	}
	
	@RequestMapping(value = "/toOutputList") // 모든 메세지 가져오기
	public String toOutputList(Model model) throws Exception{
		List<MessageDTO> list = service.selectList();
		model.addAttribute("list", list);
		return "outputList";
	}
	
	@RequestMapping(value = "/toModify")//메세지 수정 페이지 요청
	public String toModify(int no, Model model) throws Exception{
		MessageDTO dto = service.selectOne(no);
		model.addAttribute("dto", dto);
		return "modify";
	}
	
	@RequestMapping(value = "/modify") //메세지 수정 요청
	public String modify(MessageDTO dto) throws Exception{
		service.update(dto);
		return "redirect:/toOutputList";
	}
	
	@RequestMapping(value = "/delete")//메시지 삭제 요청
	public String delete(int no) throws Exception{
		service.delete(no);
		return "redirect:/toOutputList";
	}
	

	@RequestMapping(value= "/toError") // 에러페이지로 이동
	public String toError() {
		return "error";
	}

	@ExceptionHandler
	public String handleError(Exception e){
		System.out.println("에러 발생");
		e.printStackTrace();
		return "redirect:/toError";
	}
}
