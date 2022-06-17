package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.dto.StudentDTO;

@Repository
public class StudentDAO {
	@Autowired
	private BasicDataSource bds;
	
	public StudentDAO() {
		System.out.println("Message DAO 인스턴스 생성");
	}
	
	public int insert(StudentDTO dto) throws Exception{ //삽입
		String sql = "insert into Student values(seq_no.nextval,?,?)";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getMemo());
			
			return pstmt.executeUpdate();
		}
	}
	
	public int delete(int no) throws Exception{ //삭제
		String sql = "delete from Student where no = ?";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, no);
			return pstmt.executeUpdate();
		}
		
	}
	
	public int update(StudentDTO dto) throws Exception{ //업데이트
		String sql = "update Student set name=?,memo=? where no = ?";
		
		try(Connection con = bds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getMemo());
			pstmt.setInt(3, dto.getNo());
			return pstmt.executeUpdate();
		}
		
	}
	
	public StudentDTO oneSelect(int no)throws Exception{ //하나만조회
		String sql = "select*from Student where no=?";
		try(Connection con =bds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new StudentDTO(no, rs.getString("name"), rs.getString("memo"));
			}
			return null;
			
		}
		
	}
	
	public ArrayList<StudentDTO> selectAll() throws Exception{ //전체조회
		String sql = "select * from Student";
		try(Connection con = bds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql)){
			
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<StudentDTO> list = new ArrayList<>();
			while(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String memo = rs.getString("memo");
				list.add(new StudentDTO(no, name, memo));
			}
			return list;			
		}
	}
	
}
