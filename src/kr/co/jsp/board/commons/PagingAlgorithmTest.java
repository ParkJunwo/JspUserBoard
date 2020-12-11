package kr.co.jsp.board.commons;

import kr.co.jsp.board.model.BoardDAO;

public class PagingAlgorithmTest {
	/*
	
	SELECT * FROM (
    SELECT ROWNUM AS rn, board_id, writer, content, reg_date, hit
    FROM (SELECT * FROM my_board ORDER BY board_id DESC)
    )
	WHERE rn > 10 AND rn <= 20;

	--총 게시물 수
	SELECT COUNT(*) FROM my_board;

	*/
	
	
	/*
		***페이징 알고리즘 만들기***
	# 1. 사용자가 보게 될 페이지 화면
	- 한 화면에 페이지 버튼을 10개씩 끊어서 보여줌
	ex) 	1 2 3 4 .... 9 10 [다음]
	ex) [이전] 31 32 33 34 .... 39 40 [다음]
	
	- 만약 총 게시물의 개수가 67개라면
	ex) 1 2 3 4 5 6 7
		
	- 만약 총 게시물의 개수가 142개이고, 현재 12페이지라면
	[이전] 11 12 13 14 15
	
	
	
	# 2. 우선 총 게시물의 수를 조회해야함
	 DB로부터 총 게시물의 수를 불러옴
	
	
	# 3. 사용자가 현재 위치한 페이지를 기준으로
	끝 페이지 번호를 계산하는 로직 작성
	- 만약 현재 사용자가 보고 있는 페이지가 3페이지고,
	한 화면에 보여줄 페이지가 10페이지씩이라면
	-> 끝 페이지 번호? 10페이지
	
	- 만약 현재 페이지가 36페이지고 한 화면에 보여줄 페이지 수가
	20페이지라면?
	-> 끝 페이지 번호?? 40페이지
	
	==> 끝 페이지를 구하는 공식:
	 Math.cell(현재 위치한 페이지 번호/한 화면당 보여질 페이지수 )
	  		* 한 화면당 보여질 페이지 수   (올림처리)
	
	
	# 4. 시작 페이지 계산하기
	-현재 위치한 페이지가 15페이지, 한 화면에 보여줄 페이지가 10개씩이라면
	시작페이지는? 11
	=> (끝 페이지 - 한 화면당 페이지) +1
	
	
	# 5. 끝 페이지 보정
	- 총 게시물 수가 324개이고, 한 페이지 당 10개의 게시물을 보여준다.
	- 그리고 이 사람은 31페이지를 현재 보고 있따.
	-그리고 한 화면에 페이지 버튼은 10개가 배치된다
	- 그렇다면 위 공식에 의한 끝 페이지는 몇번으로 계산되는가? -> 40번
	
	# 5-1. 이전 버튼 활성 여부 설정
	- 시작페이지가 1인 부분만 비활성, 나머지는 활성
	
	
	# 5-2. 다음 버튼 활성 여부 설정
	- 공식: 보정 전 끝 페이지 번호 * 한페이지에 들어갈 게시물 수 >= 총 게시물 수 ==> 비활성
	
	
	# 5-3. 끝 페이지 값 보정
	- 다음 버튼이 비활성화 되었다면 총 게시물 수에 맞춰 끝 페이지 번호를 재 보정합니다
	- 공식 : Math.ceil(총 게시물 수 / 한 페이지에 보여줄 게시물 수)
	*/
	
	
	public static void main(String[] args) {
		
		//총 게시물 수 구하는 테스트
//		System.out.println("-------------");
//		System.out.println(BoardDAO.getInstance().countArticles());
//		System.out.println("-------------");
		
		
	}
}
