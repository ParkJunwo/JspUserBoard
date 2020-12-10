package kr.co.jsp.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class ContentService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		//BoardDAO.getInstance().upHit(bId);
		/*
		- 조회수 중복 방지용 쿠키 생성
		쿠키의 값으로는 글 번호를 넣고 응답시 쿠키가 전달될 수 있도록
		addCookie를 해줌
		쿠키 수명은 15초로 설정
		
		- 현재 요청에서 넘어온 쿠키를 request에게 모두 받아옵니다
		그 다음, 지금 요청된 글 번호로 된 쿠키가 있는지를 확인해서
		있다면 조회수를 올려주지 않고, 없다면 조회수를 올려줌
		
		
		*/
		boolean flag = false;
		
		String check_bId = request.getParameter("bId");
		Cookie[] cookies = request.getCookies();
		for(Cookie c:cookies) {
			if(c.getValue().equals(check_bId)) {
				flag = true;
				break;
			}

		}

		if(flag== false) {

			Cookie hitCoo = new Cookie("hit_cookie",check_bId);
			hitCoo.setMaxAge(15);
			response.addCookie(hitCoo);
			BoardDAO.getInstance().upHit(bId);
		}
		
		
		
		
		BoardVO vo = BoardDAO.getInstance().contentBoard(bId);
		
		request.setAttribute("article", vo);
	}

}
