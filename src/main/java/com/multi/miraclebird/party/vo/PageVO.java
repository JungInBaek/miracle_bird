package com.multi.miraclebird.party.vo;

public class PageVO {

	private int endPage;
	private int startPage;
	private int realEnd;
	private int total;
	
	boolean prev;
	boolean next;
	PageParam pageParam;
	
	
	public PageVO(PageParam pageParam, int total) {
		this.pageParam = pageParam;
		this.total = total;
		
		int current = pageParam.getPage();
		int amount = pageParam.getAmount();
		
		// 페이징 끝번호 구하기
		this.endPage = (int)(Math.ceil((double)current * 0.1)) * 3;
		
		// 페이징 시작번호 구하기 (현재 보이는 페이지의 끝번호) - (한 화면에 보여질 페이지 개수 - 1)
		this.startPage = endPage - 2;
		
		this.realEnd = (int) Math.ceil((double)total / (double)amount);
		
		// 실제 끝번호보다 endPage가 큰 경우 실제 번호로 대입
		if (realEnd < endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = current > 1;
		this.next = current < realEnd;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getRealEnd() {
		return realEnd;
	}

	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean getPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean getNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public PageParam getPageParam() {
		return pageParam;
	}

	public void setPageParam(PageParam pageParam) {
		this.pageParam = pageParam;
	}
	
}
