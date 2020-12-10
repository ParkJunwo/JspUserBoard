<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	UserVO vo = new UserVO(
			request.getParameter("id"),
			request.getParameter("pw"),
			request.getParameter("name"),
			request.getParameter("email"),
			request.getParameter("address")
			
			);
	
	session.setAttribute("user", vo);

%>


<a href="el_obj03.jsp">세션 내부의 객체의 값을 출력하기!</a>