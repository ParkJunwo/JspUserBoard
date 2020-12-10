package com.jsp.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.action")//뒤에 .action으로 끝나는 요청을 모두 받음
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request,response);

	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();//어떤 요청인지
		//System.out.println(uri);// /MyWeb/write.action 이렇게 저장된다
		
		String conPath = request.getContextPath();// -> /MyWeb
		uri = uri.substring(conPath.length()+1,uri.lastIndexOf("."));
		System.out.println(uri);
		
		switch(uri) {
		case "write":
			System.out.println("글 작성 요청이 들어옴");
			break;
		
		case "list":
			System.out.println("글 목록 요청이 들어옴");
			break;
		
		case "modify":
			System.out.println("글 수정 요청이 들어옴");
			break;
		
		case "delete":
			System.out.println("글 삭제 요청이 들어옴");
			break;
		}


	}

}
