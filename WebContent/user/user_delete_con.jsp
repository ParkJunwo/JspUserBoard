<%@page import="kr.co.jsp.user.model.UserDAO"%>
<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    
 <%
 	request.setCharacterEncoding("utf-8");
 
 	UserVO vo = (UserVO)session.getAttribute("user");
 	String check_pw = request.getParameter("check_pw");
 	
 	if(vo.getPw().equals(check_pw)){
 		UserDAO.getInstance().deleteUser(vo.getId());
 		response.sendRedirect("user_login.jsp");
 	}else{%>
 		<script>
 			alert("비밀번호를 틀렸습니다.")
 			location.href="user_mypage.jsp";
 		
 		</script>
 		
 		
 	<%}
 	
 
  %>