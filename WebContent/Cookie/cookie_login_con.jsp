<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> -->
	<%
		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String check = request.getParameter("id_remember");
		
	
		if(id.equals("abc1234") && pw.equals("aaa1111")){
			Cookie loginCoo=new Cookie("login_cookie",id);
			loginCoo.setMaxAge(5);
			response.addCookie(loginCoo);
			
			if(check!=null){//체크가 되어있다면
				Cookie idMemory= new Cookie("remember_id",id);
				idMemory.setMaxAge(30);
				response.addCookie(idMemory);
				
			}
			
			
			response.sendRedirect("cookie_welcome.jsp");
			
			
		}
		else{
			response.sendRedirect("cookie_login.jsp");
			
		}
		
	%>
<!-- </body>
</html> -->