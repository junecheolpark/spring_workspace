package com.ry.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession session;
	
	public List<Board_masterDTO> selectTest(){

		return session.selectList("board_master.selectTest");

	}

}
