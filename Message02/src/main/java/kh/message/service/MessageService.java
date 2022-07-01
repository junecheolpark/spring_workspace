package kh.message.service;

import java.util.List;
import java.util.Map;

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
	
	// 조인된 테이블 데이터 조회
	public List<Map<String, Object>> seleteJoin() throws Exception{
		return dao.selectJoin();
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
	
	public void deleteChecked(int[] no) throws Exception{
		dao.deleteChecked(no);
	}
	// 검색 ver1
	public List<MessageDTO> search1(String keyword) throws Exception{
		return dao.search1(keyword);
	}
	
	// 검색 ver2
	public List<MessageDTO> search2(String category, String keyword) throws Exception{
		return dao.search2(category, keyword);
	}
	
	// 검색 ver3
	public List<MessageDTO> search3(String no, String nickname, String message, String keyword) throws Exception{
		return dao.search3(no, nickname, message, keyword);
	}
	
	
	
	
}
