package kr.co.jsp.board.commons;

public class PageVO {
	private int page;
	private int countPerPage;
	
	public PageVO() {
		this.page = 1;//초기 값 1페이지
		this.countPerPage = 10;//보여줄 페이지 수
	}

	public int getPage() {
		
		return page;
	}

	public void setPage(int page) {
		if(page<=0) {//잘못된 값 방지
			this.page=1;
			return;
		}
		this.page = page;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		if(countPerPage <= 0 || countPerPage > 30) {//잘못된 값 방지
			this.countPerPage = 10;
			return;
		}
		this.countPerPage = countPerPage;
	}
	
	
	
}
