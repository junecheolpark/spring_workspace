package kh.board.member;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession session;

	// 로그인 유효성 검사
	public MemberDTO login(String id, String pw) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		return session.selectOne("memberMapper.login", map);
	}

	// 아이디 중복확인
	public boolean checkLogin(String id) throws Exception {
		return session.selectOne("memberMapper.checkLogin", id);
	}

	// 프로필 수정
	public int modifyProfile(MemberDTO dto) throws Exception{
		return session.update("memberMapper.modifyProfile", dto);
	}
	
	// 정보 수정
	public int modifyInfo(String id, String nickname) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("nickname", nickname);
		return session.update("memberMapper.modifyInfo", map);
	}

	// 회원가입
	public int insert(MemberDTO dto) throws Exception{
		return session.insert("memberMapper.insert", dto);
	}
}
