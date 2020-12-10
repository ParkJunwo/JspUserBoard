<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
		/* 쿠키 생성방법
		1. 쿠키 객체를 생성 - 생성자의 매개값으로 쿠키의 이름과 저장할 데이터를 입력(String)
		*/
    	
		Cookie nameCoo = new Cookie("name_cookie","홍길동");//다음페이지의 request 객체로 전송된다
    	Cookie idCoo = new Cookie("id_cookie","abc1234");
    	
    	//2. 쿠키 클래스의 setter메서드로 쿠키의 속성을 설정
    	nameCoo.setMaxAge(60*60); //쿠키의 유효시간 (수명) 설정(초) - 1시간(60*60)
    	idCoo.setMaxAge(20);
    	
    	//3. http응답 시 response객체에 생성된 쿠키를 탑재하여 클라이언트로 전송
    	response.addCookie(nameCoo);
    	response.addCookie(idCoo);
    
    	
    
    %>
    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="cookie_check.jsp">쿠키 확인하기!</a>
	

</body>
</html>