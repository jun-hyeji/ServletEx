package com.bit.servlet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmailDaoOrclImpl implements EmailDao {
	//	커넥션 메서드
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			//	드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			//	드라이버 매니저 -> 접속 얻어오기
			conn = DriverManager.getConnection(dburl, "C##HYEJI", "1234");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	@Override
	public List<EmailVo> getList() {	//	겟리스트하면 이메일보에 리스트를 만들어준다
		List<EmailVo> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
				conn = getConnection();
				stmt = conn.createStatement();
				String sql = "SELECT no, first_name, last_name, email, create_at "+
						"FROM emaillist ORDER BY create_at DESC";
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					Long no = rs.getLong(1);
					String firstName = rs.getString(2);
					String lastName = rs.getString(3);
					String email = rs.getString(4);
					Date createAt = rs.getDate(5);	//	java.util.Date
					
					EmailVo vo = new EmailVo(no, firstName, lastName, email, createAt);
					//	리스트에 추가
					list.add(vo);
				}
					
		}catch ( SQLException e ) {
			e.printStackTrace();
		}finally {
			// 자원 정리
			try {
				rs.close();
				stmt.close();
				rs.close();
			} catch (Exception e) {}
		}
		return list;
	}

	@Override
	public int insert(EmailVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long no) {
		// TODO Auto-generated method stub
		return 0;
	}

}