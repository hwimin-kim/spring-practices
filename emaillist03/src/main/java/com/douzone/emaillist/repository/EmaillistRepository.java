package com.douzone.emaillist.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.douzone.emaillist.vo.EmaillistVo;

@Repository
public class EmaillistRepository {
	private static final String ID = "webdb";
	private static final String PASSWORD = "webdb";
	
	public List<EmaillistVo> findAll() {
		List<EmaillistVo> result = new ArrayList<>();
		Connection connecion = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connecion = getConnection();
			
			// 3. SQL 준비
			String sql = "select no, first_name, last_name, email from emaillist order by no desc";
			pstmt = connecion.prepareStatement(sql);
			
			// 4. Parameter Mapping
			
			// 5. SQL 실행
			rs =pstmt.executeQuery();		
			
			// 6. 결과처리
			while(rs.next()) {
				Long no =  rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String email = rs.getString(4);
				
				EmaillistVo vo = new EmaillistVo();
				vo.setNo(no);
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(connecion != null)
					connecion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public boolean insert(EmaillistVo vo) {
		boolean result = false;
		Connection connecion = null;
		PreparedStatement pstmt = null;
		
		try {
			connecion = getConnection();
			
			String sql = "insert into emaillist values(null, ?, ?, ?)";
			pstmt = connecion.prepareStatement(sql);
			
			pstmt.setString(1, vo.getFirstName());
			pstmt.setString(2, vo.getLastName());
			pstmt.setString(3, vo.getEmail());
	
			int count =pstmt.executeUpdate();
			result = count == 1;
				
		}  catch (SQLException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(connecion != null)
					connecion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection connecion = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mysql://192.168.10.40:3306/webdb?charset=utf8";
			connecion = DriverManager.getConnection(url, ID, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}	
		return connecion;
	}
}
