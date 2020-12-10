package com.jsp.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

//서블릿이란 웹 페이지를 자바 클래스로만 구성하는 기법입니다.
//즉, jsp파일을 자바 언어로만 구성하는 것입니다

//# 서블릿 클래스를 만드는 방법
// 1. HttpServlet 클래스를 상속

public class ServletBasic extends HttpServlet{
	//서블릿으로 등록 필요(web.xml에 가상 url생성)

	//2. 생성자 선언	
	public ServletBasic() {
			System.out.println("페이지가 생성됨");
		}
	
	
	//3. HttpServlet이 제공하는 상속 메서드를 오버라이딩
	//init() doGet() doPost() destroy()
		
	
	public void init() throws ServletException{
		/*
		- 페이지 요청이 들어왔을 때 처음 실행할 로직을 작성하는 곳
		- init() 메서드는 컨테이너(서버)에 의해 서블릿 객체가 생성될 때
		최초 1회 자동으로 호출됩니다.
		- 객체의 생성자와 비슷한 역할을 수행
		
		
		*/
		System.out.println("init메서드 호출");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//http통신 중 get요청 발생 시 자동으로 호출되는 메서드
		
		System.out.println("doGet 메서드 호출!");
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http통신 중 post 요청이 발생 시 자동으로 호출되는 메서드
		System.out.println("doPost메서드 호출");
		
		request.setCharacterEncoding("utf-8");
		String account =request.getParameter("account");
		UserVO vo = UserDAO.getInstance().getUserInfo(account);
		
		HttpSession session = request.getSession();
		session.setAttribute("user", vo);
		
		response.sendRedirect("/MyWeb/servlet/info.jsp");
	
	}
	
	
	@Override
	public void destroy() {
		/*
		- 서블릿 객체 소멸 또는 마무리 작업이 필요할 때 호출하는 메서드
		(객체 소멸시 1회 자동 호출)
		- 대부분 객체 반납이나 소멸에 사용
		*/
		System.out.println("destroy호출");
	
	}
	
	
}


/*web.xml에 매핑 필요

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" id="WebApp_ID" version="4.0">
  <display-name>MyWeb</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  <servlet>
  	<servlet-name>basic</servlet-name><!-- 아무렇게나 지어도 됨 -->
  	<servlet-class>com.jsp.servlet.basic.ServletBasic</servlet-class>
  	
  </servlet>
  
  <servlet-mapping>
  	<servlet-name>basic</servlet-name>
  	<url-pattern>/basic</url-pattern><!-- 해당 url에 매핑 -->
  </servlet-mapping>
  
</web-app>

*/