package kr.co.jsp.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.commons.PageCreator;
import kr.co.jsp.board.commons.PageVO;
import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class GetListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		int page;
		int countPerPage;
		
		if(request.getParameter("page") == null) {
			page = 1; countPerPage = 10;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
			countPerPage = Integer.parseInt(request.getParameter("countPerPage"));
		}
		
		System.out.println("page: "+page);
		System.out.println("countPerPage: "+countPerPage);
		
		PageVO vo = new PageVO();
		vo.setPage(page);//사용자가 선택한 페이지 저장
		vo.setCountPerPage(countPerPage);
		List<BoardVO> boardList = dao.listBoard(vo);
		System.out.println("리스트 크기: "+boardList.size());
		
		PageCreator pc = new PageCreator();
		pc.setPaging(vo);
		pc.setArticleTotalCount(dao.countArticles());
		System.out.println(pc);
		

		
		request.setAttribute("articles", boardList);
		request.setAttribute("pc", pc);
	}

}
