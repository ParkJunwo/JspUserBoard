package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class JoinService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		UserDAO dao	= UserDAO.getInstance();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			
			String id = request.getParameter("id");
			if(dao.confirmId(id)) {
				
				
				String htmlCode="<script> \r\n"
						+ "alert(\"이미 존재하는 아이디 입니다\");\r\n"
						+ "history.back();\r\n"
						+ "</script>";// \r: 커서를 앞으로 당김
				
				out.print(htmlCode);
				out.flush();
			}
			else {
				UserVO vo = new UserVO(
						id,
						request.getParameter("pw"),
						request.getParameter("name"),
						request.getParameter("email"),
						request.getParameter("address")
						);
				
				dao.insertUser(vo);
				
				
				String htmlCode="<script> \r\n"
						+ "alert(\"회원가입을 환영합니다\");\r\n"
						+ "location.href='/MyWeb/joinSuccess.user';\r\n"
						+ "</script>";// \r: 커서를 앞으로 당김
				
				out.print(htmlCode);
				out.flush();
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
