package kr.co.jsp.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO implements IBoardDAO {

	private DataSource ds;
	
	private BoardDAO(){
		
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	
	////////////////////////////////////////////////////////
	
	
	@Override
	public void regist(String writer, String title, String content) {
		String sql = "INSERT INTO my_board(board_id, writer,title,content)"
				+ " VALUES (board_seq.NEXTVAL,?,?,?)";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content.replace("<br>", "\r\n"));//교체
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public List<BoardVO> listBoard() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		String sql = "SELECT * FROM my_board ORDER BY board_id DESC";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date"),
						rs.getInt("hit")
						);
				boardList.add(vo);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return boardList;
	}

	@Override
	public BoardVO contentBoard(int bId) {
		
		String sql = "SELECT * FROM my_board WHERE board_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bId);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content").replace("\r\n", "<br>"),
						rs.getTimestamp("reg_date"),
						rs.getInt("hit")
						);
				return vo;
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public void updateBoard(String title, String content, int bId) {
		// TODO Auto-generated method stub
		String sql = "UPDATE my_board SET title=?,content=?"
				+ " WHERE board_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, title);
			pstmt.setString(2,content);
			pstmt.setInt(3, bId);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void deleteBoard(int bId) {
		
		String sql ="DELETE FROM my_board WHERE board_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bId);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

	}

	
	@Override
	public List<BoardVO> searchBoard(String title,String category) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		String sql = "SELECT * FROM my_board WHERE "+ category +" LIKE ?";
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			title="%"+title+"%";
			pstmt.setString(1, title);
			System.out.println("여기");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date"),
						rs.getInt("hit")
						);
				
				boardList.add(vo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return boardList;
	}
	
	
	
	@Override
	public void upHit(int bId) {//조회수 증가
		String sql = "UPDATE my_board SET hit=hit+1 WHERE board_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt= conn.prepareStatement(sql)) {
			pstmt.setInt(1, bId);
			pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
