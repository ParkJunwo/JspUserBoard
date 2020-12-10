package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class DeleteService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		
		try {
			request.setCharacterEncoding("utf-8");
			
			String pw = request.getParameter("check_pw");
			HttpSession session = request.getSession();
			UserVO vo = (UserVO)session.getAttribute("user");

			UserDAO dao = UserDAO.getInstance();
			String id = vo.getId();
			
			
			
			request.setCharacterEncoding("utf-8");
			out = response.getWriter();
			
			if(dao.userCheck(id, pw)==1) {
				
				dao.deleteUser(id);
				String htmlCode="<script> \r\n"
						+ "alert(\"회원정보 삭제가 완료되었습니다\");\r\n"
						+ "location.href=\"/MyWeb/login.user\";\r\n"
						+ "</script>";
		    	
			    	out.print(htmlCode);
					out.flush();
				
				
			}
			else {
				String htmlCode="<script> \r\n"
						+ "alert(\"비밀번호를 틀리셨습니다\");\r\n"
						+ "history.back();\r\n"
						+ "</script>";
		    	
			    	out.print(htmlCode);
					out.flush();
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
