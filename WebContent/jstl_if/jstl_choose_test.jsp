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
<!-- 
	jstl choose태그와 el을 활용해
	100점이 넘으면 "점수를 잘못 입력하셨습니다",
	90 : 당신의 학점은 A입니다
	80: B, 70: C, 60: D
	나머지는 F처리
 -->
 <c:choose>
 	<c:when test="${param.point > 100 }">
 		<h4>점수를 잘못 입력하셨습니다</h4>
 	</c:when>
 	<c:when test="${param.point >= 90  }">
 		<h4>당신의 학점은 A입니다</h4>
 	</c:when>
 	<c:when test="${param.point >= 80  }">
 		<h4>당신의 학점은 B입니다</h4>
 	</c:when>
 	<c:when test="${param.point >= 70  }">
 		<h4>당신의 학점은 B입니다</h4>
 	</c:when>
 	<c:when test="${param.point >= 60  }">
 		<h4>당신의 학점은 C입니다</h4>
 	</c:when>
 	<c:otherwise>
 		<h4>당신의 학점은 F입니다</h4>
 	
 	</c:otherwise>
 
 
 </c:choose>
 
 


</body>
</html>