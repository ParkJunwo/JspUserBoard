<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@page import="kr.co.jsp.board.model.BoardVO"%>
<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!--FrontcController.java에 요청 보냄  -->
	<a href="/MyWeb/write.action">글 작성 요청</a>
	<a href="/MyWeb/list.action">글 목록 요청</a>
	<a href="/MyWeb/modify.action">글 수정 요청</a>
	<a href="/MyWeb/delete.action">글 삭제 요청</a>



<%--


BoardDAO dao = BoardDAO.getInstance();

for(int i = 1;i<=200;i++){
	BoardVO vo = new BoardVO();
	vo.setWriter("test");
	vo.setTitle("test"+i);
	vo.setContent("테스트 중~~");
	dao.regist(vo.getWriter(),vo.getTitle(),vo.getContent());
	
}


--%>

</body>
</html>