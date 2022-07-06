package com.kh.webchat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
	@Autowired
	private ChatDAO dao;
	
	public void insert(ChatDTO dto) throws Exception{
		dao.insert(dto);
	}
	
	public List<ChatDTO> select() throws Exception{
		return dao.select();
	}
}
