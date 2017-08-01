package com.xapi.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xapi.dao.UserDao;
import com.xapi.db.JdbcUtils;
import com.xapi.domain.User;

public class UserDaoImpl implements UserDao {
	public static void main(String[] args) {
		int selectUserId = new UserDaoImpl().selectUserId("hxf");
		System.out.println(selectUserId);
	}

	/**
	 * 注册
	 */
	@Override
	public int register(User user) {
		int update = 0;
		PreparedStatement sta = null;
		Connection con = null;
		try {
			con = JdbcUtils.getConnection();
			if (con != null) {
				sta = con.prepareStatement(
						"insert into user_tb(user_no,user_username,user_password,user_truename)values(user_seq.nextval,?,?,?)");
				sta.setString(1, user.getUsername());
				sta.setString(2, user.getPassword());
				sta.setString(3, user.getTrueName());
				update = sta.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, sta, null);
		}
		return update;
	}

	/**
	 *登录
	 */
	@Override
	public int login(String username, String password) {
		String string = null;
		PreparedStatement sta = null;
		Connection con = null;
		ResultSet set = null;
		int flag = 0;
		try {

			con = JdbcUtils.getConnection();
			sta = con.prepareStatement("select count(*) from user_tb where user_username=? and user_password=?");
			sta.setString(1, username);
			sta.setString(2, password);
			ResultSet res = sta.executeQuery();
			if (res.next()) {
				string = res.getString("count(*)");
			}
			if (string.equals("1")) {
				flag = 1;
			} else {
				flag = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, sta, set);
		}
		return flag;
	}
	/**
	 * 用户是否存在
	 */
	@Override
	public boolean exitUsername(String username) {
		PreparedStatement sta = null;
		Connection con = null;
		String string = null;
		ResultSet res = null;
		boolean flag = false;
		try {
			con = JdbcUtils.getConnection();
			sta = con.prepareStatement("select count(*) from user_tb where user_username=?");
			sta.setString(1, username);
			res = sta.executeQuery();
			if (res.next()) {
				string = res.getString("count(*)");
			}
			if (string.equals("1")) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JdbcUtils.close(con, sta, res);

		}
		return flag;
	}

	/**
	 * 查询用户号
	 */
	@Override
	public int selectUserId(String userNo){
		PreparedStatement sta = null;
		Connection con = null;
		ResultSet res = null;
		int flag = 0;
			try {
				con = JdbcUtils.getConnection();
				sta = con.prepareStatement("select USER_NO from user_tb where USER_USERNAME=?");
				sta.setString(1, userNo);
				res = sta.executeQuery();
				while (res.next()) {
					flag = res.getInt("USER_NO");
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return flag;
	}
}
