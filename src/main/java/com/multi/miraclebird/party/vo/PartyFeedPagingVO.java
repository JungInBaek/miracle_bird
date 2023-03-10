package com.multi.miraclebird.party.vo;

import java.time.LocalDate;

public class PartyFeedPagingVO {

	private Integer partyId;
	private LocalDate today;

	// 현재페이지, 시작페이지, 끝페이지, 게시글 총 갯수, 페이지당 글 갯수, 마지막페이지, SQL쿼리에 쓸 start, end
	private Integer nowPage, startPage, endPage, total, cntPerPage, lastPage, start, end;
	private Integer cntPage = 5;

	public PartyFeedPagingVO() {
	}

	public PartyFeedPagingVO(Integer partyId, LocalDate today, Integer total, Integer nowPage, Integer cntPerPage) {
		setPartyId(partyId);
		setToday(today);
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}

	// 제일 마지막 페이지 계산
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double) total / (double) cntPerPage));
	}

	// 시작, 끝 페이지 계산
	public void calcStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int) Math.ceil((double) nowPage / (double) cntPage)) * cntPage);
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}

	// DB 쿼리에서 사용할 start, end값 계산
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

	public LocalDate getToday() {
		return today;
	}

	public void setToday(LocalDate today) {
		this.today = today;
	}

	public Integer getNowPage() {
		return nowPage;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCntPerPage() {
		return cntPerPage;
	}

	public void setCntPerPage(Integer cntPerPage) {
		this.cntPerPage = cntPerPage;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer setCntPage() {
		return cntPage;
	}

	public void getCntPage(Integer cntPage) {
		this.cntPage = cntPage;
	}

	@Override
	public String toString() {
		return "PartyFeedPagingVO [partyId=" + partyId + ", today=" + today + ", nowPage=" + nowPage +
				", startPage=" + startPage + ", endPage=" + endPage + ", total=" + total + ", cntPerPage=" + cntPerPage + 
				", lastPage=" + lastPage + ", start=" + start + ", end=" + end + ", cntPage=" + cntPage + "]";
	}

}
