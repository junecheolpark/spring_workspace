package kh.board.file;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAO {
	@Autowired
	private SqlSession session;
	
	// 파일 데이터 저장
	public void insert(FileDTO dto) throws Exception{
		session.insert("fileMapper.insert", dto);
	}
	
	// 파일 데이터 삭제
	public void delete(String sys_name) throws Exception{
		session.delete("fileMapper.delete", sys_name);
	}
	
	// files 테이블의 모든 sys_name 가져오기
	public List<String> selectSys_name() throws Exception{
		return session.selectList("fileMapper.selectSys_name");
	}
	
	// 게시글에 첨부된 파일 목록 가져오기
	public List<FileDTO> selectBySeq(int seq_board) throws Exception{
		return session.selectList("fileMapper.selectBySeq", seq_board);
	}
	
}
