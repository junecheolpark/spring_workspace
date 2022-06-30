package kh.message2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.message2.dao.MessageDAO;
import kh.message2.dto.MessageDTO;

@Service
public class MessageService {
	@Autowired
	private MessageDAO dao;
	
	public void insert(MessageDTO dto)throws Exception{
		dao.insert(dto);
	}
	
	public MessageDTO selectOne(int no) throws Exception{
		return dao.selectOne(no);
	}
	
	public List<MessageDTO> selectList() throws Exception{
		return dao.selectList();
	}
	
	public void delete(int no)throws Exception{
		dao.delete(no);
	}
	
	public void update(MessageDTO dto)throws Exception{
		dao.update(dto);
	}
	
}

