package kh.message2.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.message2.dto.MessageDTO;

@Repository
public class MessageDAO {
	// 마이바티스를 이용해 mapper가 가지고있는 쿼리문을 사용하기 위해 멤버필드 추가
	@Autowired
	private SqlSession session;

	public void insert(MessageDTO dto) throws Exception {
		// 마이바티스 내부에 쿼리문을 미리 작성해놓고
		// 그 쿼리문을 실행시켜라 메서드를 호출
		// DAO에서는 어떤 쿼리문을 실행시킬거고 그 쿼리문을 실행시키기 위해
		// 필요한 데이터가 있다면 그 데이터만 넘겨주고 결과를 반환받을 것.

		// insert("매퍼의 이름.쿼리문의 아이디, 넘겨주는 데이터)넘겨주는 인자값 2개
		session.insert("messageMapper.insert", dto);
	}

	public MessageDTO selectOne(int no) throws Exception {
		return session.selectOne("messageMapper.selectOne", no);
	}

	// 모든 메세지 조회
	public List<MessageDTO> selectList() throws Exception {
		return session.selectList("messageMapper.selectList");
	}

	// 메세지 삭제
	public void delete(int no) throws Exception {
		session.delete("messageMapper.delete", no);
	}
	
	// 메세지 수정
	public void update(MessageDTO dto) throws Exception {
		session.update("messageMapper.update", dto);
	}

}
