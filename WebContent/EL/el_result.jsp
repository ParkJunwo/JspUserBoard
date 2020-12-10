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
		# data1: <%= session.getAttribute("data1") %><br>
		# data2: <%= application.getAttribute("data2") %>
	
	</p>
	<!-- scope를 지정하지 않는다면
		page -> request -> session -> application순서대로 찾는다 
	 -->
	<p>
		# data1: ${sessionScope.data1 }<br>
		# data2: ${data2 }<br>
		
	</p>


</body>
</html>