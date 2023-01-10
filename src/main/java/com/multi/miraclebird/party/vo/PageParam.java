package com.multi.miraclebird.party.vo;

import java.time.LocalDate;

public class PageParam {

	private int page;
	private int amount;
	private int start;
	
	private Integer partyId;
	private LocalDate today;
	
	
	public PageParam() {
		this.page = 1;
		this.amount = 3;
		this.start = 0;
	}
	
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		System.out.println("setPage");
		this.page = page;
		this.start = (page - 1) * amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		System.out.println("setAmount");
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
