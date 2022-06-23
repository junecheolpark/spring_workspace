package kh.board.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private BasicDataSource bds;

	public MemberDAO() {
		System.out.println("Message DAO 인스턴스 생성");
	}

	public int insert(MemberDTO dto) throws Exception {
		String sql = "insert into member values(?,?,?,null,?)";

		try (Connection con = bds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getProfile_image());

			return pstmt.executeUpdate();
		}
	}

	// 아이디 중복체크
	public boolean checkID(String user_id) throws Exception {
		String sql = "select count(*) from member where id = ?";

		try (Connection con = bds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();

			int result = 0;
			if (rs.next()) {
				result = rs.getInt(1);
			}
			if (result == 0) {
				return true;
			} else {
				return false;
			}
		}
	}
	//로그인체크
	public MemberDTO login(String id, String pw) throws Exception {
		String sql = "select * from member where id = ? and pw = ?";

		try (Connection con = bds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String nickname = rs.getString("nickname");
				String profile_message = rs.getString("profile_message");
				String profile_image = rs.getString("profile_image");
				MemberDTO dto = new MemberDTO(id, pw, nickname, profile_message, profile_image);
				return dto;
			}
			return null;
		}
	}
	
	// 프로필 수정
	public int modifyProfile(MemberDTO dto) throws Exception{
		String sql = "update member set profile_message=?, profile_image= ? where id=?";
		try (Connection con = bds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1,  dto.getProfile_message());
			pstmt.setString(2,  dto.getProfile_image());
			pstmt.setString(3,  dto.getId());
			return pstmt.executeUpdate();
		}
		
	}
	// 닉네임 수정
	public int modify_nickname(MemberDTO dto) throws Exception{
		String sql = "update member set nickname=? where id=?";
		try (Connection con = bds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1,  dto.getNickname());
			pstmt.setString(2,  dto.getId());
			return pstmt.executeUpdate();
		}
		
	}
}
