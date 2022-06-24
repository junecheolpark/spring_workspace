package kh.board.board;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;

	// 전체조회
	public ArrayList<BoardDTO> selectAll() throws Exception {
		return dao.selectAll();
	}

	// detailView를 위해 title 조회
	public BoardDTO detailView(String title) throws Exception {
		return dao.detailView(title);
	}

	public int veiw_countUp(String title) throws Exception {
		return dao.veiw_countUp(title);
	}

	// 글쓰기
	public int insert(BoardDTO dto) throws Exception {
		return dao.insert(dto);
	}

	// 마지막 시퀀스번호가져오기
	public int seq_board() throws Exception {
		return dao.seq_board();
	}

	// 파일 업로드
	public String uploadProfile(MultipartFile file, String realPath) throws Exception {
		File realPathFile = new File(realPath);
		if (!realPathFile.exists())
			realPathFile.mkdir();
		String ori_name = file.getOriginalFilename();
		String sys_name = UUID.randomUUID() + "_" + ori_name;
		file.transferTo(new File(realPath + File.separator + sys_name));
		return sys_name;

	}

}
