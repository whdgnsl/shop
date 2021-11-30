package com.tyranitar.member.dto;

import java.util.List;

public class MemberListDTO {

	private int total; //전체 게시물 수
	private int currentPage; //현재 페이지
	private List<MemberDTO> content; //특정 범위 게시물 조회 결과
	
	private int totalPages; //전체 페이지 수
	private int startPage; //시작페이지
	private int endPage; //끝페이지
	
	public MemberListDTO() {}

	public MemberListDTO(int total, int currentPage, int size, List<MemberDTO> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		
		if(total==0) {
			this.totalPages = 0;
			this.startPage = 0; 
			this.endPage = 0;
		}else {
			this.totalPages = total/size;
			if(total%size>0) {
				totalPages++;
			}
			int modVal = currentPage%5;
			
			this.startPage = currentPage/5*5+1;
			
			if(modVal==0) {
				this.startPage -=5;
			}
			
			this.endPage = startPage+4;
			
			if(endPage>totalPages) {this.endPage = totalPages;}
		}
		
	}

	public int getTotal() {
		return total;
	}
	public boolean hasNoArticles() {
		return total == 0;
	}
	public boolean hasArticles() {
		return total>0;
	}
	public int getCurrentPage() {
		return currentPage;
	}

	public List<MemberDTO> getContent() {
		return content;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	
}
