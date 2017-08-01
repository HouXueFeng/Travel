package com.xapi.dao;

import com.xapi.domain.User;

public interface UserDao {

	public int register(User user);//注册
	
	public int login(String username,String password);//登陆
	
	public boolean exitUsername(String username);//是否存在该用户
	
	public int selectUserId(String userNo); //查询id号
	
}
