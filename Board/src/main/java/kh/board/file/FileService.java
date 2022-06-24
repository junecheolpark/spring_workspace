package kh.board.file;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {
	@Autowired
	private FileDAO dao;
	
	//board seq번호 찾아서 insert
	public int file_insert(FileDTO dto)throws Exception{
		return dao.file_insert(dto);
	}
	
	//board seq 같은번호 전체 조회
	public ArrayList<FileDTO> look_img(int seq_board) throws Exception{
		return dao.look_img(seq_board);
	}

}
