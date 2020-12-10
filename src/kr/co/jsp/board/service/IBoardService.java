package kr.co.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IBoardService {

	
	//모든 서비스 객체가 하나의 인터페이스 타입의 변수로 객체를 생성할 수 있고,
	//같은 이름의 메서드로 동작할 수 있게끔 인테페이스를 제작
	void execute(HttpServletRequest request, HttpServletResponse response);
	
}
