package com.multi.miraclebird.party.vo;

import java.time.LocalDate;

public class PageParam {

	private int page;			// 페이지
	private int amount;			// 가져올 개수
	private int start;			// 시작 번호
	
	private Integer partyId;
	private LocalDate today;
	
	public PageParam() {
		this.page = 1;
		this.amount = 3;
		this.start = 0;
	}
	
	public void setPage(int page) {
		this.page = page;
		this.start = (page - 1) * amount;
	}
	
	public int getPage() {
		return page;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		this.start = (page - 1) * amount;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
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
	
	@Override
	public String toString() {
		return "PageParam [page=" + page + ", amount=" + amount + ", start=" + start + ", partyId=" + partyId
				+ ", today=" + today + "]";
	}
	
}
