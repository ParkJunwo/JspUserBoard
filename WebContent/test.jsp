<%@page import="kr.co.jsp.board.commons.PageVO"%>
<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		out.print("-------------------------<br>");
		out.print("# 총 게시물 수: "+BoardDAO.getInstance().countArticles()+"<br>");		
		out.print("-------------------------<br>");
		
		//끝 페이지 번호 계산 테스트
		PageVO paging = new PageVO();
		paging.setPage(5);//현재 보고있는 페이지 번호
		paging.setCountPerPage(20);
		int displayPage = 10;
		
		int endPage = (int)Math.ceil(paging.getPage()/(double)displayPage)*displayPage;
		out.print("끝 페이지 번호: " +endPage+" 번<br>");
		
		//시작 페이지 번호 계산 테스트
		int beginPage = (endPage - displayPage) +1;
		out.print("시작 페이지 번호: " +beginPage+" 번<br>");
		
		//이전 버튼 활성, 비활성 여부
		boolean isPrev = (beginPage == 1)?false:true;
		out.print("이전 버튼 활성화 여부: "+isPrev+"<br>");
		
		//다음 버튼 활성, 비활성 여부
		boolean isNext = (BoardDAO.getInstance().countArticles()<=(endPage*paging.getCountPerPage()))
		?false:true;
		out.print("다음 버튼 활성화 여부: "+isNext+"<br>");
		
		if(!isNext){
			endPage=(int)Math.ceil(BoardDAO.getInstance().countArticles()/(double)paging.getCountPerPage());
			
		}
			out.print("보정 후 끝 페이지 번호: "+endPage+"<br>");
	%>


</body>
</html>