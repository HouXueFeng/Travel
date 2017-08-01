package com.xapi.domain;

import java.util.List;
//订单详情类
public class Order_Detail {
	private Integer id;
	private Integer order_no;
	private Integer jingdian_no;
	private Integer items_num;
	private List<JingDian>jingDians;
	
	
	
	public Order_Detail() {
		super();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getOrder_no() {
		return order_no;
	}



	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}



	public Integer getJingdian_no() {
		return jingdian_no;
	}



	public void setJingdian_no(Integer jingdian_no) {
		this.jingdian_no = jingdian_no;
	}



	public Integer getItems_num() {
		return items_num;
	}



	public void setItems_num(Integer items_num) {
		this.items_num = items_num;
	}



	public List<JingDian> getJingDians() {
		return jingDians;
	}



	public void setJingDians(List<JingDian> jingDians) {
		this.jingDians = jingDians;
	}



	public Order_Detail(Integer id, Integer order_no, Integer jingdian_no, Integer items_num,
			List<JingDian> jingDians) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.jingdian_no = jingdian_no;
		this.items_num = items_num;
		this.jingDians = jingDians;
	}



	@Override
	public String toString() {
		return "Order_Detail [id=" + id + ", order_no=" + order_no + ", jingdian_no=" + jingdian_no + ", items_num="
				+ items_num + ", jingDians=" + jingDians + "]";
	}
	
}
