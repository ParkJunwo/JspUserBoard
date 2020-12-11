package kr.co.jsp.board.model;

import java.util.List;

import kr.co.jsp.board.commons.PageVO;

public interface IBoardDAO {
	
	//글 등록 메서드
	void regist(String writer, String title, String content);
	
	//글 목록을 가지고 오는 메서드
	List<BoardVO> listBoard(PageVO paging);
	
	
	//글 상세보기 요청 처리할 메서드
	BoardVO contentBoard(int bId);
	
	
	//글 수정 요청 처리할 메서드
	void updateBoard(String title, String content, int bId);
	
	
	//글 삭제 요청 처리할 메서드
	void deleteBoard(int bId);
	
	
	//글 검색 요청 처리할 메서드
	List<BoardVO> searchBoard(String title,String category);
	
	
	//조회수를 올려주는 메서드
	void upHit(int bId);
	
	//총 게시물의 개수를 구하는 메서드
	int countArticles();
	
	
	
	
}
