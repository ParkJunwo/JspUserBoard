<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
   		//클라이언트에서 전달된 쿠키를 가져오는 방법
   		Cookie[] cookies = request.getCookies();//전달 받은 쿠키를 배열로 가져옴
   		boolean flag = false;
   		
   		
    	if(cookies!= null){
    		for(Cookie c : cookies){
    			//쿠키 이름을 얻어오는 메서드 getName();
    			if(c.getName().equals("id_cookie")){//쿠키의 이름을 확인하고 옳다면
    				out.print("<h3>아이디 쿠키가 존재합니다</h3>");
    				String value = c.getValue();//쿠키 내부의 값을 받아옴
    				out.print("쿠키의 값: "+value);
    				flag = true;
    				break;
    			}
    		}
    		if(!flag){
    			out.print("<h3>아이디 쿠키가 존재하지 않습니다!</h3>");
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
<br>
	<a href="cookie_check_all.jsp">모든 쿠키 확인하기</a>
	
	



</body>
</html>