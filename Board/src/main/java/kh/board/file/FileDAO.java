package kh.board.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAO {
	@Autowired
	private BasicDataSource bds;
	
	// 파일 데이터 저장
	public void insert(FileDTO dto) throws Exception{
		String sql = "insert into files values(seq_file.nextval,?,?,?)";
		try(Connection con = bds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, dto.getSeq_board());
			pstmt.setString(2, dto.getOri_name());
			pstmt.setString(3, dto.getSys_name());
			pstmt.executeUpdate();			
		}
	}
	
	// 파일 데이터 삭제
	public void delete(String sys_name) throws Exception{
		String sql = "delete from files where sys_name=?";
		try(Connection con = bds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
				
			pstmt.setString(1, sys_name);
			pstmt.executeUpdate();
		}
	}
	
	// 게시글에 첨부된 파일 목록 가져오기
	public List<FileDTO> selectBySeq(int seq_board) throws Exception{
		String sql = "select * from files where seq_board = ?";
		try(Connection con = bds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, seq_board);
			ResultSet rs = pstmt.executeQuery();
			
			List<FileDTO> list = new ArrayList<>();
			while(rs.next()) {
				int seq_file = rs.getInt("seq_file");
				String ori_name = rs.getString("ori_name");
				String sys_name = rs.getString("sys_name");
				list.add(new FileDTO(seq_file,seq_board,ori_name,sys_name));
			}
			return list;			
		}
	}
	
}
