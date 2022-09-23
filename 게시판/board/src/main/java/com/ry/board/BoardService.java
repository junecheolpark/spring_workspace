package com.ry.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;
	
	public List<Board_masterDTO> selectTest(){
		return dao.selectTest();
	}
}
