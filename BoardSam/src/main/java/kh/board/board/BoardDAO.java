package kh.board.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSession session;
	
	public void insert(BoardDTO dto) throws Exception{ // 게시글 저장
		session.insert("boardMapper.insert", dto);
	}
	
	public int selectSeq() throws Exception{ // 새로운 게시글 시퀀스 번호 생성
		return session.selectOne("boardMapper.selectSeq");
	}
	
	public void modify(BoardDTO dto) throws Exception{ // 게시글 수정
		session.update("boardMapper.modify", dto);
	}
	
	public int delete(int seq_board) throws Exception{ // 게시글 삭제 요청
		return session.delete("boardMapper.delete", seq_board);
	}
	
	public BoardDTO selectOne(int seq_board) throws Exception{ // 하나의 게시글 조회
		return session.selectOne("boardMapper.selectOne", seq_board);
	}
	
	public List<BoardDTO> selectAll() throws Exception{ // 모든 게시글 조회
		return session.selectList("boardMapper.selectAll");
	}
}
