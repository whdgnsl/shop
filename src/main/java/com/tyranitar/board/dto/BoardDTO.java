package com.tyranitar.board.dto;

import org.springframework.stereotype.Component;

@Component("boardDTO")
public class BoardDTO {

	private int notice_no;
	private String notice_title;
	private String notice_content;
	private String notice_show;
	private String notice_count;
	
	public BoardDTO() {}

	public BoardDTO(int notice_no, String notice_title, String notice_content, String notice_show,
			String notice_count) {
		super();
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_show = notice_show;
		this.notice_count = notice_count;
	}

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public String getNotice_show() {
		return notice_show;
	}

	public void setNotice_show(String notice_show) {
		this.notice_show = notice_show;
	}

	public String getNotice_count() {
		return notice_count;
	}

	public void setNotice_count(String notice_count) {
		this.notice_count = notice_count;
	}

	@Override
	public String toString() {
		return "BoardDTO [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_show=" + notice_show + ", notice_count=" + notice_count + "]";
	}
	
}