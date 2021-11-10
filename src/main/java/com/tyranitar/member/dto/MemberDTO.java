package com.tyranitar.member.dto;

import org.springframework.stereotype.Component;

@Component("memberDTO")
public class MemberDTO {

	private int members_no;
	private String members_id;
	private String members_full_name;
	private String members_nickname;
	private String members_pw;
	private String members_email;
	private String members_tel;
	private int members_point;
	private char members_isshow;
	private String members_kind;
	private String members_addr;
	
	public MemberDTO() {}


	public MemberDTO(int members_no, String members_id, String members_full_name, String members_nickname,
			String members_pw, String members_email, String members_tel, int members_point, char members_isshow,
			String members_kind, String members_addr) {
		this.members_no = members_no;
		this.members_id = members_id;
		this.members_full_name = members_full_name;
		this.members_nickname = members_nickname;
		this.members_pw = members_pw;
		this.members_email = members_email;
		this.members_tel = members_tel;
		this.members_point = members_point;
		this.members_isshow = members_isshow;
		this.members_kind = members_kind;
		this.members_addr = members_addr;
	}


	public int getMembers_no() {
		return members_no;
	}
	public void setMembers_no(int members_no) {
		this.members_no = members_no;
	}
	public String getMembers_kind() {
		return members_kind;
	}


	public void setMembers_kind(String members_kind) {
		this.members_kind = members_kind;
	}


	public String getMembers_addr() {
		return members_addr;
	}


	public void setMembers_addr(String members_addr) {
		this.members_addr = members_addr;
	}


	public String getMembers_id() {
		return members_id;
	}
	public void setMembers_id(String members_id) {
		this.members_id = members_id;
	}
	public String getMembers_full_name() {
		return members_full_name;
	}
	public void setMembers_full_name(String members_full_name) {
		this.members_full_name = members_full_name;
	}
	public String getMembers_nickname() {
		return members_nickname;
	}
	public void setMembers_nickname(String members_nickname) {
		this.members_nickname = members_nickname;
	}
	public String getMembers_pw() {
		return members_pw;
	}
	public void setMembers_pw(String members_pw) {
		this.members_pw = members_pw;
	}
	public String getMembers_email() {
		return members_email;
	}
	public void setMembers_email(String members_email) {
		this.members_email = members_email;
	}
	public String getMembers_tel() {
		return members_tel;
	}
	public void setMembers_tel(String members_tel) {
		this.members_tel = members_tel;
	}
	public int getMembers_point() {
		return members_point;
	}
	public void setMembers_point(int members_point) {
		this.members_point = members_point;
	}
	public char getMembers_isshow() {
		return members_isshow;
	}
	public void setMembers_isshow(char members_isshow) {
		this.members_isshow = members_isshow;
	}
	@Override
	public String toString() {
		return "MemberDTO [members_no=" + members_no + ", members_id=" + members_id + ", members_full_name="
				+ members_full_name + ", members_nickname=" + members_nickname + ", members_pw=" + members_pw
				+ ", members_email=" + members_email + ", members_tel=" + members_tel + ", members_point="
				+ members_point + ", members_isshow=" + members_isshow + ", members_kind=" + members_kind
				+ ", members_addr=" + members_addr + "]";
	}
	
	
}
