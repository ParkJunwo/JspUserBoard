<%@page import="kr.co.jsp.user.model.UserDAO"%>
<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    /* 	
    1. 폼 데이터 처리(기존 비번, 변경 비번)
    2. dao 주소값을 받아오고, userCheck()를 활용하여 기존 비번과
    	아이디 정보를 바탕으로 해당 비밀번호가 일치하는지를 확인(id는 세션에서)

    3. 비밀번호가 일치한다면 비밀번호를 바꾸는 메서드 changePassword()호출
    4. "비밀번호가 정상적으로 변경되었습니다" 경고창 출력 후 mypage이동
    5. 현재 비밀번호가 불일치 -> 현재 비밀번호가 다릅니다 출력 후 뒤로가기
     */
    
     request.setCharacterEncoding("utf-8");
    
    UserVO vo = (UserVO) session.getAttribute("user");
    
    String oldPw = request.getParameter("old_pw");
    String newPw = request.getParameter("new_pw");
     
    UserDAO dao = UserDAO.getInstance();
    
    int result = dao.userCheck(vo.getId(),oldPw);
     
    if(result == 1){ //로그인 유효성 검증 성공
    	dao.changePassword(vo.getId(),newPw); %>
    	<script>
    		alert("비밀번호가 정상적으로 변경되었습니다.");
    		location.href="user_mypage.jsp";
    	</script>
    	<%}else{//로그인 유효성 검증 실패 %>
    	<script>
    		alert("현재 비밀번호를 확인하세요.");
    		history.back();
    	</script>
    <%}%>
     
     
    