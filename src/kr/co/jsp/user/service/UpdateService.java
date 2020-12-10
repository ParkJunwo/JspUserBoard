package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class UpdateService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		
		try {
			
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setName(name);
			vo.setEmail(email);
			vo.setAddress(address);
			UserDAO.getInstance().updateUser(vo);
			
			
			HttpSession session = request.getSession();
			UserVO user = UserDAO.getInstance().getUserInfo(id);
			session.setAttribute("user", user);
			
			
			
			request.setCharacterEncoding("utf-8");
			out = response.getWriter();
			String htmlCode="<script> \r\n"
					+ "alert(\"회원정보 수정이 완료되었습니다\");\r\n"
					+ "location.href=\"/MyWeb/mypage.user\";\r\n"
					+ "</script>";
	    	
		    	out.print(htmlCode);
				out.flush();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
