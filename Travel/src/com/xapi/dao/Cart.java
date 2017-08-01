package com.xapi.dao;

import java.util.List;

import com.xapi.domain.Order;

public interface Cart {
	public List<Order> queryUserCart(String username);// 用户订单的购物车信息查询

	public Integer insertOrder(int getId, int userNo, int number);//下订单

	public Integer getid();// 主键返回

	public Integer insertOrderDetail(int getid, int jingdianNo, int itemNum);// 订单关联订单详情插入

	public Integer delete_detail(int order_no);//按照订单号删除订单详情（外键表）

	public Integer delete_order(int order_no);//按照订单号删除订单（主键表）

	public Integer delete_detailAll();//删除全部订单信息

	public Integer delete_orderAll(); //删除全部订单信息
}
