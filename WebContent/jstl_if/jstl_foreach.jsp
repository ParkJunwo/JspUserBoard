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
<%-- 	<%
		int total = 0;
		for(int i =1;i<=100;i++){
			total+=i;
		}
		out.print("<h4>1부터 100까지의 누적합:"+total+"<h4>");
	
	
	%>
 --%>
 
 	<c:set var = "total" value="0"/>
 	<c:forEach var ="i" begin="1" end="100" step="1">
 	<!-- 1~100까지 1씩 커짐, step 생략 시 1씩 증가 -->
 		<c:set var="total" value="${total+1 }"/><!-- total+=i -->
 		
 	
 	</c:forEach>
 	<h4>1부터 100까지의 누적합 : ${total }</h4>

	<hr>
	

	<c:forEach var="hang" begin="1" end="9">
		4 x ${hang } = ${4*hang }<br>
	</c:forEach>
	
<%-- 	<c:forEach var = "row" begin="1" end="9">
		<c:forEach var = "hang2" begin="1" end= "9">
			${row } x ${hang2 } = ${row*hang2 }<br>
		</c:forEach>
		<hr>
		
	</c:forEach>
	 --%>
	
	<h4>배열이나 컬렉션 내부의 값을 출력</h4>
	
	<c:set var ="arr" value="<%=new int[] {1,3,5,7,9} %>"/>
	
	<c:forEach var="n" items="${arr }">
		${n }&nbsp;
	</c:forEach>
	

</body>
</html>