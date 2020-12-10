<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
	아이디: ${user.id }<br><!-- 세션의 user객체에서 id변수 출력  -->
	비밀번호: ${user.pw }<br>
	이름: ${user.name }<br>
	주소: ${user.address }<br>
</p>

</body>
</html>