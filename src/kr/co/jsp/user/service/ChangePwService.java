package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class ChangePwService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		 
		response.setContentType("text/html; charset=UTF-8");////////
		PrintWriter out;///////
		
		
		UserDAO dao = UserDAO.getInstance();
		
		
		String newPw = request.getParameter("new_pw");
		String oldPw = request.getParameter("old_pw");
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO)session.getAttribute("user");
		String id = vo.getId();
		int checkNum = dao.userCheck(id, oldPw);
		
		
		try {
			request.setCharacterEncoding("utf-8");
			out = response.getWriter();/////////
			
			if(checkNum == 0) {
				
				String htmlCode="<script> \r\n"
						+ "alert(\"비밀번호가 틀렸습니다.\");\r\n"
						+ "history.back();\r\n"
						+ "</script>";// \r: 커서를 앞으로 당김////////
				
				
				out.print(htmlCode);
				out.flush();
			}
			else {
				dao.changePassword(id, newPw);
				String htmlCode="<script> \r\n"
						+ "alert(\"비밀번호가 성공적으로 변경되었습니다.\");\r\n"
						+ "location.href=\"/MyWeb/mypage.user\";\r\n"
						+ "</script>";// \r: 커서를 앞으로 당김////////
				
				
				out.print(htmlCode);
				out.flush();
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
