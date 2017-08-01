package com.xapi.service;

import java.util.List;

import com.xapi.dao.Cart;
import com.xapi.dao.JingdianDao;
import com.xapi.dao.imp.CartImpl;
import com.xapi.db.DaoFactory;
import com.xapi.domain.JingDian;
import com.xapi.domain.Order;
import com.xapi.domain.User;
import com.xapi.util.PageModel;

public class JingDianServiceImp {
	public static void main(String[] args) {
//		Integer getid = new CartImpl().getid();
//		new CartImpl().insertOrder(getid, 1, 1);
//		new CartImpl().insertOrderDetail(getid, 213, 1);
		List<Order> queryUserCart = new CartImpl().queryUserCart("hxf");
		for (Order user : queryUserCart) {
			System.out.println(user);
		}
	}

	JingdianDao jingdianDao = DaoFactory.getInstance().createDao("com.xapi.dao.imp.JingDianImp", JingdianDao.class);
	Cart cart = DaoFactory.getInstance().createDao("com.xapi.dao.imp.CartImpl", Cart.class);

	public List<JingDian> selectJingDianInfo() {

		return jingdianDao.selectJingDianInfo();
	}

	public JingDian selectJingDianById(Integer id) {

		return jingdianDao.selectJingDianById(id);
	}

	public PageModel queryJingdianInfoForAll(int pageNo, int pageSize) {
		return jingdianDao.queryJingdianInfoForAll(pageNo, pageSize);
	}

	public int getTotalRecords() {
		return jingdianDao.getTotalRecords();

	}

	public PageModel searchLike(int pageNo, int pageSize, String name) {
		
		return jingdianDao.searchLike(pageNo, pageSize, name);

	}

	public Integer getid() {

		return cart.getid();

	}

	public Integer insertOrder(int getId, int userNo, int number) {
		return cart.insertOrder(getId, userNo, number);
	}

	public Integer insertOrderDetail(int getid, int jingdianNo, int itemNum) {

		return cart.insertOrderDetail(getid, jingdianNo, itemNum);
	}

	public List<Order> queryUserCart(String username){
		return cart.queryUserCart(username);
				
	}
}
