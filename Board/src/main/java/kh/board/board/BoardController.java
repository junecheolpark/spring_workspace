package kh.board.board;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kh.board.file.FileDTO;
import kh.board.file.FileService;
import kh.board.member.MemberDTO;

@RequestMapping(value = "/board")
@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	@Autowired
	private FileService fileService;
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/toBoard") // board페이지 요청
	public String toBoard(Model model) throws Exception {
		ArrayList<BoardDTO> list = service.selectAll();
		model.addAttribute("list", list);
		return "board/board";
	}

	@RequestMapping(value = "/towrite") // write페이지 요청
	public String toWrite() {

		return "board/write";
	}

	@RequestMapping(value = "/write") // 게시글 작성
	public String write(BoardDTO dto, FileDTO filedto, MultipartFile file) throws Exception {

		int rs = service.insert(dto);
		if (rs > 0) {// 성공했다면 마지막 시퀀스번호로 file insert
			System.out.println(filedto.toString());
			System.out.println("file : " + file);
			String realPath = session.getServletContext().getRealPath("profile");
			String content_image = service.uploadProfile(file, realPath);
			filedto.setContent_image(content_image);

			fileService.file_insert(filedto);
		}

		return "redirect:/member/toWelcome";
	}

	@RequestMapping(value = "/detail") // detail페이지 요청
	public String write(String title, int seq_board, Model model) throws Exception {
		System.out.println(seq_board);
		service.veiw_countUp(title);
		BoardDTO dto = service.detailView(title);
		model.addAttribute("dto", dto);
		System.out.println(dto);
		ArrayList<FileDTO> list = fileService.look_img(seq_board);
		System.out.println(list);
		model.addAttribute("filelist", list);
		

		return "/board/detail";
	}

	@ExceptionHandler
	public String toError(Exception e) {
		System.out.println("예외 발생");
		e.printStackTrace();
		return "redirect:/toError";
	}
}