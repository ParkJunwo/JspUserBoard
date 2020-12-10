<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		UserVO vo = (UserVO) session.getAttribute("user");
	
	%>
	
	# 이름: <%=vo.getName() %><br>
	# 아이디: <%=vo.getId() %><br>
	# 비밀번호: <%=vo.getPw()%><br>
	# 이메일: <%=vo.getEmail() %><br>
	# 주소: <%=vo.getAddress() %>
	
	<hr>
	
	<p>
		# 이름: ${sessionScope.user.name }<br><!-- user객체의 name -->
		# 아이디: ${user.id }<br>
		# 이메일: ${user.email }<br>
		# 주소: ${user.address }<br>
	</p>

</body>
</html>