<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 클래스 경로랑 jsp경로랑 별도이므로 action에서 호출하도록 url매핑 필요-->
	<!-- ServletBasic.java파일에 매핑 내용 첨부 -->
	<form action ="/MyWeb/basic" method ="post">
	<!-- jsp를 거치지 않고 바로 메서드 호출 가능 -->
		# 아이디: <input type="text" name="account">
		<input type="submit" value="서블릿 페이지 열어보기">
	</form>

</body>
</html>