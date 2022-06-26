package kh.board.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.board.board.BoardDAO;
import kh.board.board.BoardDTO;

@Repository
public class FileDAO {
	@Autowired
	private BasicDataSource bds;
	@Autowired
	private BoardDAO boardDao;
	
	public FileDAO() {
		System.out.println("Message DAO 인스턴스 생성");
	}
	
	public int file_insert(FileDTO dto)throws Exception{
		String sql = "insert into tbl_file values(seq_file.nextval,?,?)";
		try (Connection con = bds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			int seq_board = boardDao.seq_board();
			
			pstmt.setInt(1, seq_board);
			pstmt.setString(2, dto.getContent_image());
			
			return pstmt.executeUpdate();
		}
	}
	
	public ArrayList<FileDTO> look_img(int seq_board) throws Exception{
		String sql = "select*from tbl_file where seq_board=?";
		try (Connection con = bds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, seq_board);
			ResultSet rs = pstmt.executeQuery();
			ArrayList <FileDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				int seq_file = rs.getInt("seq_file");
				String content_image = rs.getString("content_image");
				list.add(new FileDTO(seq_file, seq_board, content_image));
			}
			return list;
		}
	}

}
