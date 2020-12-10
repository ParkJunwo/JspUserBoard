package kr.co.jsp.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO implements IUserDAO {

	private DataSource ds;
	
	
	private UserDAO() {
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/myOracle");
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static UserDAO dao = new UserDAO();
	
	public static UserDAO getInstance() {
		if(dao==null) {
			dao = new UserDAO();
		}
		return dao;
	}
	
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	
	/////////////////////////////////////////////////////////
	
	@Override
	public boolean confirmId(String id) {
		boolean flag = false;
		String sql = "SELECT * FROM my_user WHERE user_id=?";
		
		//try with resource 문법(자바 1.7버전 이후로 사용가능
		// try 뒤에 소괄호를 열고 try 블록에서 사용할 객체를 괄호 안에서 생성
		//AutoCloseable인터페이스를 구현하거나 상속하고 있는 객체는 try with resource
		//문법 하에서 try문이 종료된후 실행
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) flag = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
		
		return flag;
	}

	@Override
	public void insertUser(UserVO vo) {
		String sql = "INSERT INTO my_user VALUES(?,?,?,?,?)";
		
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	@Override
	public int userCheck(String id, String pw) {
		
		
		String sql = "SELECT * FROM my_user WHERE user_id =?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {//아이디가 존재하면
				if(rs.getString("user_pw").equals(pw)) {//비밀번호가 같다면
					return 1;
				}else {
					return 0;
				}
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return -1;

		

	}

	@Override
	public UserVO getUserInfo(String id) {
		UserVO user = null;
		String sql = "SELECT * FROM my_user WHERE user_id=?";
		
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserVO(
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"),
						rs.getString("user_email"),
						rs.getString("user_address")
						
						);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}

	@Override
	public void changePassword(String id, String newPw) {
		String sql = "UPDATE my_user SET user_PW=? WHERE user_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			 	pstmt.setString(1, newPw);
			 	pstmt.setString(2,id);
			 	pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}


	}

	@Override
	public void updateUser(UserVO vo) {
		String sql = "UPDATE my_user "
				+ "SET user_name=?,user_email=?,user_address=?"
				+ " WHERE user_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getId());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void deleteUser(String id) {
		String sql = "DELETE FROM my_user WHERE user_id=?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
