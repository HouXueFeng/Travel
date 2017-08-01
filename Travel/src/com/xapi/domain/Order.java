package com.xapi.domain;

public class Order {
	private Integer order_no;
	private Integer user_no;
	private Integer order_number;
	private String order_createTime;
	private Order_Detail detail;
	private User user;
	
	
	public Order() {
		super();
	}
	public Integer getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}
	public Integer getUser_no() {
		return user_no;
	}
	public void setUser_no(Integer user_no) {
		this.user_no = user_no;
	}
	public Integer getOrder_number() {
		return order_number;
	}
	public void setOrder_number(Integer order_number) {
		this.order_number = order_number;
	}
	public String getOrder_createTime() {
		return order_createTime;
	}
	public void setOrder_createTime(String order_createTime) {
		this.order_createTime = order_createTime;
	}
	public Order_Detail getDetail() {
		return detail;
	}
	public void setDetail(Order_Detail detail) {
		this.detail = detail;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Order(Integer order_no, Integer user_no, Integer order_number, String order_createTime, Order_Detail detail,
			User user) {
		super();
		this.order_no = order_no;
		this.user_no = user_no;
		this.order_number = order_number;
		this.order_createTime = order_createTime;
		this.detail = detail;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Order [order_no=" + order_no + ", user_no=" + user_no + ", order_number=" + order_number
				+ ", order_createTime=" + order_createTime + ", detail=" + detail + ", user=" + user + "]";
	}
	
}
