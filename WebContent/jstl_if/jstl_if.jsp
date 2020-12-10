<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- jstl을 사용하려면 taglib선언을 해야한다 -->
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!--기본적인 기능을 담고 있는 core라이브러리 사용 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- JSTL로 변수 선언 시 EL안에서 활용이 가능하며 EL에서 타입을 자동으로 인식 -->
	<c:set var="age" value="${param.age }" /><!-- 변수 선언 -->
	
	<p>
		# 나이: ${age }세<!-- jstl로 선언한 변수명을 el에서 그대로 사용  -->
		
		<c:if test="${age>19 }"><!-- age변수가 19이상인지 확인, else는 없음 -->
			<h4>당신은 성인입니다.</h4>
		</c:if>
		
		<c:if test=""${age<20 }">
			<h4>당신은 미성년자 입니다.</h4>
		</c:if>
	
	</p>
	



</body>
</html>