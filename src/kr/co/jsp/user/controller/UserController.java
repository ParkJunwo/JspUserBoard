package kr.co.jsp.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;
import kr.co.jsp.user.service.ChangePwService;
import kr.co.jsp.user.service.DeleteService;
import kr.co.jsp.user.service.IUserService;
import kr.co.jsp.user.service.JoinService;
import kr.co.jsp.user.service.LoginService;
import kr.co.jsp.user.service.UpdateService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 public UserController() {
	 
  }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			doRequest(request, response);
			
	}
	

	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath=request.getContextPath();
		uri = uri.substring(conPath.length()+1,uri.lastIndexOf("."));
		System.out.println(uri);
		IUserService sv =null;
		
		
		switch(uri) {
		case"join":
			System.out.println("회원가입 요청이 들어옴");
			sv = new JoinService();
			sv.execute(request, response);
			break;
			
		case"joinSuccess":
			System.out.println("로그인 화면으로 이동");
			response.sendRedirect("user/user_login.jsp");
			break;
		case"login":
			System.out.println("로그인 요청이 들어옴!");
			
			sv = new LoginService();
			sv.execute(request, response);
			
			
			break;
		
		case"mypage":
			System.out.println("마이페이지 이동 요청");
			response.sendRedirect("user/user_mypage.jsp");
			
			break;
			
		case"chgPw":
			System.out.println("비밀번호 변경요청 페이지 이동 요청");
			response.sendRedirect("user/user_change_pw.jsp");
			break;
			
		case "changePw":
			System.out.println("비밀번호 변경 요청이 들어옴");
			
			sv = new ChangePwService();
			sv.execute(request, response);
			break;
			
		case "modify":
			System.out.println("수정 페이지로 이동 요청");
			response.sendRedirect("user/user_update.jsp");

			break;
		
			
		case "update":
			System.out.println("회원 정보 수정 요청");
			
			sv = new UpdateService();
			sv.execute(request, response);
			
			break;
		
			
		case "delete":
			System.out.println("탈퇴 페이지로 이동 요청");
			response.sendRedirect("user/user_delete.jsp");
			break;
			
			
		case "delUser":
			System.out.println("회원 정보 삭제 요청");
			
			sv = new DeleteService();
			sv.execute(request, response);
			
			break;
			
		
		}
		
		
	}
}
