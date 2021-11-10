package com.tyranitar.product.dto;

public class ProductDTO {
	
	private int product_no; //상품 번호
	private String product_name; //상품 이름
	private String product_mainInfo; //상품 정보
	private String product_stock; //상품 재고
	private String product_kind;
	private String product_count; //조회수
	private String product_image_fileName;
	private String product_image_filetype;
	private int product_image_no;
	private int rownum;
	
	public ProductDTO() {}
	
	public ProductDTO(int product_no, String product_name, String product_mainInfo, String product_stock,
			String product_kind, String product_count, String product_image_fileName, String product_image_filetype,
			int product_image_no, int rownum) {
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_mainInfo = product_mainInfo;
		this.product_stock = product_stock;
		this.product_kind = product_kind;
		this.product_count = product_count;
		this.product_image_fileName = product_image_fileName;
		this.product_image_filetype = product_image_filetype;
		this.product_image_no = product_image_no;
		this.rownum = rownum;
	}

	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_mainInfo() {
		return product_mainInfo;
	}
	public void setProduct_mainInfo(String product_mainInfo) {
		this.product_mainInfo = product_mainInfo;
	}
	public String getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(String product_stock) {
		this.product_stock = product_stock;
	}
	public String getProduct_kind() {
		return product_kind;
	}

	public void setProduct_kind(String product_kind) {
		this.product_kind = product_kind;
	}

	public String getProduct_count() {
		return product_count;
	}
	public void setProduct_count(String product_count) {
		this.product_count = product_count;
	}
	public String getProduct_image_fileName() {
		return product_image_fileName;
	}
	public void setProduct_image_fileName(String product_image_fileName) {
		this.product_image_fileName = product_image_fileName;
	}
	public String getProduct_image_filetype() {
		return product_image_filetype;
	}
	public void setProduct_image_filetype(String product_image_filetype) {
		this.product_image_filetype = product_image_filetype;
	}
	public int getProduct_image_no() {
		return product_image_no;
	}
	public void setProduct_image_no(int product_image_no) {
		this.product_image_no = product_image_no;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	@Override
	public String toString() {
		return "ProductDTO [product_no=" + product_no + ", product_name=" + product_name + ", product_mainInfo="
				+ product_mainInfo + ", product_stock=" + product_stock + ", product_kind=" + product_kind
				+ ", product_count=" + product_count + ", product_image_fileName=" + product_image_fileName
				+ ", product_image_filetype=" + product_image_filetype + ", product_image_no=" + product_image_no
				+ ", rownum=" + rownum + "]";
	}
	
	
}
