package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class LoginService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	    
	    UserDAO dao = UserDAO.getInstance();
	    
	    
	    response.setContentType("text/html; charset=UTF-8");////////
		PrintWriter out;///////
	    
		
		try {
			request.setCharacterEncoding("utf-8");
			   
		    String id = request.getParameter("id");
		    String pw = request.getParameter("pw");
			
			out = response.getWriter();/////////
			int checkNum =dao.userCheck(id, pw);
		    
			if(checkNum == -1 ){
		    	
		    	String htmlCode="<script> \r\n"
						+ "alert(\"존재하지 않는 아이디입니다\");\r\n"
						+ "location.href=\"user_login.jsp\";\r\n"
						+ "</script>";// \r: 커서를 앞으로 당김////////
				
		    	out.print(htmlCode);
				out.flush();
		    	
		    }
		    else if(checkNum == 0){
		    	String htmlCode="<script> \r\n"
					+ "alert(\"비밀번호가 틀렸습니다\");\r\n"
					+ "history.back();\r\n"
					+ "</script>";
	    	
		    	out.print(htmlCode);
				out.flush();
		    }
		    else if(checkNum == 1){
		    	UserVO vo = dao.getUserInfo(id);
		    	HttpSession session = request.getSession();
		    	session.setAttribute("user", vo);
		    	response.sendRedirect("/MyWeb/mypage.user");
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
