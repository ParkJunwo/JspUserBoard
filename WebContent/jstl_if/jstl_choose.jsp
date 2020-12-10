<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<c:set var="age" value="${param.age }"/>
		# 이름: ${param.name }<br>
		# 나이: ${age }<br>
		
		<c:choose>
			<c:when test="${age>=20 }">
				<h4>성인입니다</h4>
			</c:when>
			<c:when test="${age>=17 }">
				<h4>고등학생 입니다</h4>
			</c:when>
			<c:when test="${age>=14 }">
				<h4>중학생 입니다</h4>
			</c:when>
			<c:otherwise>
				<h4>당신은 미성년자 입니다.</h4>
			</c:otherwise>
		</c:choose>
		
	</p>

	<p>
		<%int age= Integer.parseInt(request.getParameter("age")); %>
		# 이름: <%=request.getParameter("name") %>
		# 나이: <%=age %>세
		
		<%if(age>=20){ %>
			<h4>당신은 성인입니다</h4>
		<% }else %>
	</p>


</body>
</html>