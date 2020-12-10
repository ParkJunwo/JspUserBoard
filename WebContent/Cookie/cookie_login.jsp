<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	boolean flag = false;
    	String userId = "";
    	Cookie[] cookies = request.getCookies();
    	for(Cookie c:cookies){
    		if(c.getName().equals("login_cookie")){
    			flag = true;
    			break;
    		}
    		if(c.getName().equals("remember_id")){
    			userId = c.getValue();
    		}
    	}
    
    %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%if(!flag){%>
		<form action = "cookie_login_con.jsp" method="post">
		
		<input type="text" name = "id" size="10" placeholder="ID" value="<%=userId%>">
		<input type="checkbox" name="id_remember" value="true"><small>아이디 기억하기</small><br>
		<input type="password" name = "pw" size="10" placeholder="PW"><br>
		<input type = "submit" value="로그인">
	
		</form>
		
	<%} else{ %>
		<p>
			<a href="cookie_welcome.jsp">이미 로그인한 사용자입니다.</a>
		</p>
	
	<%} %>




</body>
</html>