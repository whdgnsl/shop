package com.tyranitar.order.dto;

import java.util.Date;

public class OrderDTO {
	
	private int orderId; //orderId_seq.nextval
	private String members_id;
	private String order_addr;
	private String members_addr;
	private String order_tel;
	private int order_price;
	private Date orderDate;
	
	public OrderDTO() {}
	public OrderDTO(int orderId, String members_id, String order_addr, String members_addr, String order_tel,
			int order_price, Date orderDate) {
		this.orderId = orderId;
		this.members_id = members_id;
		this.order_addr = order_addr;
		this.members_addr = members_addr;
		this.order_tel = order_tel;
		this.order_price = order_price;
		this.orderDate = orderDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getMembers_id() {
		return members_id;
	}
	public void setMembers_id(String members_id) {
		this.members_id = members_id;
	}
	public String getOrder_addr() {
		return order_addr;
	}
	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}
	public String getMembers_addr() {
		return members_addr;
	}
	public void setMembers_addr(String members_addr) {
		this.members_addr = members_addr;
	}
	public String getOrder_tel() {
		return order_tel;
	}
	public void setOrder_tel(String order_tel) {
		this.order_tel = order_tel;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", members_id=" + members_id + ", order_addr=" + order_addr
				+ ", members_addr=" + members_addr + ", order_tel=" + order_tel + ", order_price=" + order_price
				+ ", orderDate=" + orderDate + "]";
	}
	
	
	
}
