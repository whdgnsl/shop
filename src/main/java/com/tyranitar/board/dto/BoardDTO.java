package com.tyranitar.board.dto;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("boardDTO")
public class BoardDTO {

	private int notice_no;
	private String notice_title;
	private String notice_content;
	private String notice_show;
	private String members_nickname;
	private Date notice_date;
	private int notice_count;
	private String members_id;
	private int num;
	
	public BoardDTO() {}


	public BoardDTO(int notice_no, String notice_title, String notice_content, String notice_show,
			String members_nickname, Date notice_date, int notice_count, int num, String members_id) {
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_content = notice_content;
		this.notice_show = notice_show;
		this.members_nickname = members_nickname;
		this.notice_date = notice_date;
		this.notice_count = notice_count;
		this.num = num;
		this.members_id = members_id;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
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

	public String getMembers_nickname() {
		return members_nickname;
	}

	public void setMembers_nickname(String members_nickname) {
		this.members_nickname = members_nickname;
	}

	public Date getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}

	public int getNotice_count() {
		return notice_count;
	}

	public void setNotice_count(int notice_count) {
		this.notice_count = notice_count;
	}

	public String getMembers_id() {
		return members_id;
	}


	public void setMembers_id(String members_id) {
		this.members_id = members_id;
	}


	@Override
	public String toString() {
		return "BoardDTO [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_show=" + notice_show + ", members_nickname=" + members_nickname
				+ ", notice_date=" + notice_date + ", notice_count=" + notice_count + ", members_id=" + members_id
				+ ", num=" + num + "]";
	}
	
	
}