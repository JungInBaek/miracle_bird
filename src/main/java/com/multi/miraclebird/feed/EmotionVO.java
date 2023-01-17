package com.multi.miraclebird.feed;

public class EmotionVO {

	private int total;
	private String coment;
	private String img;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getComent() {
		return coment;
	}
	public void setComent(String coment) {
		this.coment = coment;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "EmotionVO [total=" + total + ", coment=" + coment + ", img=" + img + "]";
	}
	
}
