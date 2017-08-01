package com.xapi.service;

import java.util.List;

import com.xapi.dao.GongGaoDao;
import com.xapi.dao.imp.CartImpl;
import com.xapi.db.DaoFactory;
import com.xapi.domain.Order;
import com.xapi.domain.User;

public class CartServiceImp {
	public static void main(String[] args) {
		List<Order> order = new CartServiceImp().queryUserCart("hxf");
		for (Order order1 : order) {
			System.out.println(order1);

		}
	}
	//反射得到类实例对象
	CartImpl cartImpl = DaoFactory.getInstance().createDao("com.xapi.dao.imp.CartImpl", CartImpl.class);
	public List<Order> queryUserCart(String username) {
		return cartImpl.queryUserCart(username);
	}
	public Integer delete_detail(int order_no){
		return cartImpl.delete_detail(order_no);
	}
	public Integer delete_order(int order_no){
		return cartImpl.delete_order(order_no);
	}
	public Integer delete_detailAll(){
		return cartImpl.delete_detailAll();
	}
	public Integer delete_orderAll(){
		return cartImpl.delete_orderAll();
	}
}
