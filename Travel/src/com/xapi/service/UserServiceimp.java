package com.xapi.service;

import com.xapi.dao.UserDao;
import com.xapi.db.DaoFactory;
import com.xapi.domain.User;

public class UserServiceimp {
	public static void main(String[] args) {
		int selectUserId = new UserServiceimp().selectUserId("hxf");
		System.out.println(selectUserId);
	}
	//反射得到类实例对象

	UserDao userDao = DaoFactory.getInstance().createDao("com.xapi.dao.imp.UserDaoImpl", UserDao.class);

	public int register(User user) {

		return userDao.register(user);
	}
	
	public boolean exitUsername(String username){
		
		return userDao.equals(username);
		
	}
	public int selectUserId(String userNo){
		return userDao.selectUserId(userNo);
	}

}
