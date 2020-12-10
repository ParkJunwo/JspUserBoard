package kr.co.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class UpdateService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		System.out.println(bTitle);
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.updateBoard(bTitle, bContent, bId);
		BoardVO vo = dao.contentBoard(bId);
		request.setAttribute("article", vo);
		
		
	}

}
