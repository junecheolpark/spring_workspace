package kh.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.message.dao.MessageDAO;
import kh.message.dto.MessageDTO;

@Service
public class MessageService {
	@Autowired
	private MessageDAO dao;
	
	// 메세지 저장
	public void insert(MessageDTO dto) throws Exception{
		dao.insert(dto);
	}
	
	// no를 넘겨받아 해당 데이터를 가져오는 메서드
	public MessageDTO selectOne(int no) throws Exception{
		return dao.selectOne(no);
	}
	
	// 모든 메시지 가져오기 
	public List<MessageDTO> selectList() throws Exception{
		return dao.selectList();
	}
	
	// 메세지 수정
	public void update(MessageDTO dto) throws Exception{
		dao.update(dto);
	}
	
	// 메시지 삭제 
	public void delete(int no) throws Exception{
		dao.delete(no);
	}
}
