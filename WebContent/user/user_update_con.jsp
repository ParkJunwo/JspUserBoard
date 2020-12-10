<%@page import="kr.co.jsp.user.model.UserDAO"%>
<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
/* 
	2.DAO연동을 통해 updateUser()라는메서드를 호출해 회원정보를 수정

 */
 
	request.setCharacterEncoding("utf-8");
	UserVO vo = new UserVO();
	vo.setId(request.getParameter("id"));
	vo.setName(request.getParameter("name"));
 	vo.setEmail(request.getParameter("email"));
 	vo.setAddress(request.getParameter("address"));
 	//입력받은 값들을 vo 객체로 싸서 
 	
 	
 	UserDAO dao = UserDAO.getInstance();
 	dao.updateUser(vo);//업데이트 하도록 넘겨준다
 	
 	UserVO user = dao.getUserInfo(vo.getId());
 	session.setAttribute("user", user);//세션 없데이트
 	
 	
%>
	<script>
		alert("회원 정보가 수정되었습니다");
		location.href="user_mypage.jsp";
	
	</script>
