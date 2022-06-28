package com.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.message.dao.MessageDAO;
import com.message.dto.MessageDTO;

@Service
public class MessageService {
	@Autowired
	private MessageDAO dao;
	
	public void insert(MessageDTO dto)throws Exception{
		dao.insert(dto);
	}
	
	
}

