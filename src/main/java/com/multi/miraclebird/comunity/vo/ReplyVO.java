package com.multi.miraclebird.comunity.vo;

import java.time.LocalDateTime;

public class ReplyVO {
	private int reply_id;
	private int board_id;
	private String reply_writer;
	private String reply_content;
	private LocalDateTime write_date;
	private LocalDateTime update_date;
	
	public int getReply_id() {
		return reply_id;
	}
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getReply_writer() {
		return reply_writer;
	}
	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public LocalDateTime getWrite_date() {
		return write_date;
	}
	public void setWrite_date(LocalDateTime write_date) {
		this.write_date = write_date;
	}
	public LocalDateTime getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(LocalDateTime update_date) {
		this.update_date = update_date;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [reply_id=" + reply_id + ", board_id=" + board_id + ", reply_writer=" + reply_writer
				+ ", reply_content=" + reply_content + ", write_date=" + write_date + ", update_date=" + update_date
				+ "]";
	}
	
}
