package kh.board.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private BasicDataSource bds;
	
	//게시글 등록
	public int insert(BoardDTO dto) throws Exception {
		String sql = "insert into board values(seq_board.nextval,?,?,?,?,0,sysdate)";
		try (Connection con = bds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getWriter_nickname());
			pstmt.setString(4, dto.getWriter_id());
			return pstmt.executeUpdate();
		}
	}
	
	//조회수 증가
	public int veiw_countUp(String title) throws Exception {
		String sql = "UPDATE board SET view_count =  view_count + 1 where title= ?";
		try (Connection con = bds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, title);
	
			return pstmt.executeUpdate();
		}
	}
	
	
	//전체조회
	public ArrayList<BoardDTO> selectAll() throws Exception{
		String sql = "select*from board";
		try (Connection con = bds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();

			ArrayList<BoardDTO> list = new ArrayList<>();
			while(rs.next()) {
				int seq_board = rs.getInt("seq_board");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer_nickname= rs.getString("writer_nickname");
				String writer_id= rs.getString("writer_id");
				int view_count = rs.getInt("view_count");
				String written_date = getStringDate(rs.getDate("written_date"));
				list.add(new BoardDTO(seq_board, title, 
						content, writer_nickname,writer_id, view_count,written_date));
			}
			return list;
		}
	}
	
	//상세조회
		public BoardDTO detailView(String title) throws Exception{
			String sql = "select*from board where title=?";
			try (Connection con = bds.getConnection(); 
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				pstmt.setString(1, title);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int seq_board = rs.getInt("seq_board");
					String content = rs.getString("content");
					String writer_nickname= rs.getString("writer_nickname");
					String writer_id= rs.getString("writer_id");
					int view_count = rs.getInt("view_count");
					String written_date = getStringDate(rs.getDate("written_date"));
					BoardDTO dto = new BoardDTO(seq_board, title, 
							content, writer_nickname,writer_id, view_count,written_date);
					return dto;
				}
				return null;
			}
		}
	
		//마지막 seq_board 가져오기 
		public int seq_board() throws Exception{
			String sql = "select seq_board from board where rownum=1 order by 1 desc";
			try (Connection con = bds.getConnection(); 
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					int seq_board = rs.getInt(1);
					return seq_board;
				}
				return 0;
			}
		}
		
		
	//date 형변환
    public String getStringDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(date);
    }
	
}
