<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@page import="kr.co.jsp.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
   <%
   /* 	
   	1. 파라미터값 얻어오기(id,pw)
   	2. DAO 주소값 얻어오기
   	3. 로그인 유효성 검증 메서드 userCheck()호출
   		- 아이디가 없다면 스크립트로 경고창 출력후 로그인페이지로 이동(-1)
   		- 비밀번호가 틀렸다면 비밀번호가 틀렸다고 경고창 출력 후 뒤로가기(0)
   		- 로그인 성공 시 user_mypage.jsp로 리다이렉팅(1)

   	4. 로그인 성공 시 페이지 이동전에 getUserInfo()를 호출하여
   	로그인을 성공한 회원의 모든 정보를 받아와서 세션으로 저장
   	세션이름:user, 저장할 값: UserVO 객체 자체
    */
    request.setCharacterEncoding("utf-8");
   
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
    
    UserDAO dao = UserDAO.getInstance();
    int checkNum =dao.userCheck(id, pw);
    
    if(checkNum == -1 ){%>
    	<script>
    		alert("존재하지 않는 아이디입니다");
    		location.href="user_login.jsp";
    	
    	</script>
    <%}
    else if(checkNum == 0){%>
    	<script>
    		alert("비밀번호가 틀렸습니다");
    		history.back();
    	</script>
    <%}
    else if(checkNum == 1){
    	UserVO vo = dao.getUserInfo(id);
    	session.setAttribute("user", vo);
    	response.sendRedirect("user_mypage.jsp");
    }
    
    %>