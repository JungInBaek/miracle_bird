package com.multi.miraclebird.store;
public class CategoryPageVO {
	private int categoryId;
	private String categoryName;
	private int start;
	private int end;
	private int page;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public void setStartEnd(int page) {
		start = 1 + (page - 1) * 6;
		end = page * 6;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "CategoryPageVO [categoryId=" + categoryId + ", categoryName=" + categoryName + ", start=" + start
				+ ", end=" + end + ", page=" + page + "]";
	}
	
}