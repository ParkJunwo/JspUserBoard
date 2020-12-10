package kr.co.jsp.board.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class SearchService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String search = request.getParameter("search");
		String category = request.getParameter("category");
		List<BoardVO> boardList = BoardDAO.getInstance().searchBoard(search,category);
		if(boardList.size() == 0) {
			//자바 클래스에서 html이나 js문법 사용하는법: PrintWriter객체 사용
			response.setContentType("text/html; charset=UTF-8");
			//html 지시어 사용
			
			try {
				PrintWriter out = response.getWriter();
				
				String htmlCode="<script> \r\n"
						+ "alert(\"검색 결과에 따른 게시물이 없습니다.\");\r\n"
						+ "location.href='/MyWeb/list.board';\r\n"
						+ "</script>";// \r: 커서를 앞으로 당김
				
				out.print(htmlCode);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		request.setAttribute("articles", boardList);
		
		
	}

}
