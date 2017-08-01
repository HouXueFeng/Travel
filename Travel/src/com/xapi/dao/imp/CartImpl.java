package com.xapi.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.xapi.dao.Cart;
import com.xapi.db.JdbcUtils;
import com.xapi.domain.JingDian;
import com.xapi.domain.Order;
import com.xapi.domain.Order_Detail;
import com.xapi.domain.User;

public class CartImpl implements Cart {

	public static void main(String[] args) {
		//模拟测试
//		Integer delete_detail = new CartImpl().delete_detail(396);
		Integer delete_order = new CartImpl().delete_order(396);
		System.out.println(delete_order);
	}

	/**
	 * 订单关联用户和订单详情，订单详情关联景点列表信息
	 */
	@Override
	public List<Order> queryUserCart(String username) {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		List<Order> ordersList = new ArrayList<>();
		List<JingDian> jingDians = new ArrayList<>();
		User user = new User();
		try {
			con = JdbcUtils.getConnection();
			sta = con.prepareStatement(
					"select user_tb.*,JINGDIAN_TB.JINGDIAN_NO,JINGDIAN_TITLE,JINGDIAN_PRICE,ORDER_TB.ORDER_NO,ORDER_TB.ORDER_NUMBER,ORDER_TB.ORDER_CREATETIME FROM USER_TB,ORDER_TB,JINGDIAN_TB,ORDER_DETAIL WHERE JINGDIAN_TB.JINGDIAN_NO=ORDER_DETAIL.JINGDIAN_NO and USER_TB.USER_NO=ORDER_TB.USER_NO and ORDER_TB.ORDER_NO=ORDER_DETAIL.ORDERS_NO and user_tb.user_username=?");
			sta.setString(1, username);
			res = sta.executeQuery();
			while (res.next()) {
				user.setUsername(res.getString("USER_USERNAME"));
				user.setId(res.getInt("USER_NO"));
				user.setTrueName(res.getString("USER_TRUENAME"));
				int order_no = res.getInt("ORDER_NO");
				int order_number = res.getInt("ORDER_NUMBER");
				String creatTime = res.getString("ORDER_CREATETIME");
				int jingdian_no = res.getInt("JINGDIAN_NO");
				String jingdian_title = res.getString("JINGDIAN_TITLE");
				int jingdian_price = res.getInt("JINGDIAN_PRICE");
				Order order = new Order();
				order.setOrder_createTime(creatTime);
				order.setOrder_number(order_number);
				order.setOrder_no(order_no);
				order.setUser(user);
				Order_Detail detail = new Order_Detail();
				detail.setOrder_no(order_no);
				JingDian dian = new JingDian();
				dian.setJingdianNo(jingdian_no);
				dian.setJingdianTitle(jingdian_title);
				dian.setJingdianPrice(jingdian_price);
				jingDians.add(dian);
				detail.setJingDians(jingDians);
				order.setDetail(detail);
				ordersList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, sta, res);
		}
		return ordersList;
	}

	/**
	 * 插入订单
	 * 这里的getId是主键返回的id
	 */ 
	@Override
	public Integer insertOrder(int getId, int userNo, int number) {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		int flag = 0;
		try {
			con = JdbcUtils.getConnection();
			sta = con.prepareStatement("insert into ORDER_TB values(?,?,?,?)");
			sta.setInt(1, getId);
			sta.setInt(2, userNo);
			sta.setInt(3, number);
			sta.setString(4, new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(new Date()));
			flag = sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, sta, res);
		}
		return flag;
	}
	/**
	 * 主键返回
	 */
	public Integer getid() {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		int flag = 0;
		try {
			con = JdbcUtils.getConnection();
			sta = con.prepareStatement("select order_seq.nextval from dual");
			res = sta.executeQuery();
			while (res.next()) {
				flag = res.getInt("NEXTVAL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, sta, res);
		}
		return flag;
	}

	
	/**
	 * 插入订单关联详情
	 */
	public Integer insertOrderDetail(int getid, int jingdianNo, int itemNum) {

		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		int flag = 0;
		try {
			con = JdbcUtils.getConnection();
			sta = con.prepareStatement("insert into order_detail values(order_detail_seq.nextval,?,?,?)");
			sta.setInt(1, getid);
			sta.setInt(2, jingdianNo);
			sta.setInt(3, itemNum);

			flag = sta.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, sta, res);
		}
		return flag;
	}

	
	 /**
	  * 删除订单详情按照订单号
	  */
	@Override
	public Integer delete_detail(int order_no) {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		int flag = 0;
		try {
			con = JdbcUtils.getConnection();
			sta= con.prepareStatement("delete from order_detail where orders_no=?");
			sta.setInt(1, order_no);
			flag = sta.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();			
		}finally {
			JdbcUtils.close(con, sta, res);
		}
		return flag;
	}

	/**
	 * 	  删除订单按照订单号
	 */
	@Override
	public Integer delete_order(int order_no) {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		int flag = 0;
		try {
			con = JdbcUtils.getConnection();
			sta= con.prepareStatement("DELETE from order_tb where order_no=?");
			sta.setInt(1, order_no);
			flag = sta.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();			
		}finally {
			JdbcUtils.close(con, sta, res);
		}
		return flag;
	}

	/**
	 * 删除全部订单详情
	 */
	@Override
	public Integer delete_detailAll() {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		int flag = 0;
		try {
			con = JdbcUtils.getConnection();
			sta= con.prepareStatement("delete from order_detail");
			flag = sta.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();			
		}finally {
			JdbcUtils.close(con, sta, res);
		}
		return flag;
	}

	/**
	 * 删除全部订单
	 */
	@Override
	public Integer delete_orderAll() {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		int flag = 0;
		try {
			con = JdbcUtils.getConnection();
			sta= con.prepareStatement("delete from order_tb");
			flag = sta.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();			
		}finally {
			JdbcUtils.close(con, sta, res);
		}
		return flag;
	}

}