<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${user ==null }">
	<script>
		alert("회원만 이용 가능한 페이지입니다. 로그인 해주세요");
		location.href="/MyWeb/login.user";
	</script>
</c:if>
    <%--
    	//주소를 치고 강제로 들어오는 접근 막기
    	if(session.getAttribute("user")==null){
    		response.sendRedirect("user_login.jsp");
    		
    	}else{
    		UserVO vo = (UserVO)session.getAttribute("user");
    		--%>
    		
 <head>   		
<title>
</head>
<body>

	<%@include file ="../include/header.jsp" %>
	<div align="center">
		<h2>My page</h2>
		<hr>
		<p>
			<strong>${user.name }(${user.id })님의 정보를 관리합니다.</strong>
		</p>
		<hr>
		<br>
		<p>
			<a href="/MyWeb/chgPw.user">비밀번호 변경</a>&nbsp;
			<a href="/MyWeb/modify.user">회원 정보 수정</a>&nbsp;
			<a href="/MyWeb/delete.user">회원 탈퇴</a>
		</p>
	
	
	</div>

	


	<%@include file ="../include/header.jsp" %>
</body>
  
  

</title>


<%--} --%>