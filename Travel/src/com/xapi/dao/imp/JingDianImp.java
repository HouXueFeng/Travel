package com.xapi.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xapi.dao.JingdianDao;
import com.xapi.db.JdbcUtils;
import com.xapi.domain.JingDian;
import com.xapi.util.PageModel;

public class JingDianImp implements JingdianDao {

	public static void main(String[] args) {
		// int i = new JingDianImp().getTotalRecords();
		// System.out.println(i);
		PageModel page = new JingDianImp().searchLike(1, 5, "亚龙");
		List<?> list = page.getList();
		for (Object object : list) {
			System.out.println(object);
		}
	}
	/**
	 * 
	 * 查出所有景点信息
	 */
	@Override
	public List<JingDian> selectJingDianInfo() {
		JingDian dian = null;
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		List<JingDian> dians = new ArrayList<>();
		try {
			con = JdbcUtils.getConnection();
			sta = con.prepareStatement("select * from jingdian_tb");
			res = sta.executeQuery();
			while (res.next()) {
				dian = new JingDian(res.getInt("JINGDIAN_NO"), res.getString("JINGDIAN_TITLE"),
						res.getString("JINGDIAN_ADDRESS"), res.getInt("JINGDIAN_PRICE"), res.getString("JINGDIAN_DESC"),
						res.getString("JINGDIAN_DETAIL"), res.getString("JINGDIAN_PIC"),
						res.getString("JINGDIAN_TIME"));
				dians.add(dian);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, sta, res);
		}
		return dians;
	}

	/**
	 * 
	 * 按照id查询景点（景点详细信息）
	 */
	@Override
	public JingDian selectJingDianById(Integer id) {
		JingDian jingDian = null;
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			con = JdbcUtils.getConnection();
			sta = con.prepareStatement("select * from jingdian_tb where jingdian_No=?");
			sta.setInt(1, id);
			res = sta.executeQuery();
			while (res.next()) {
				jingDian = new JingDian(res.getInt("JINGDIAN_NO"), res.getString("JINGDIAN_TITLE"),
						res.getString("JINGDIAN_ADDRESS"), res.getInt("JINGDIAN_PRICE"), res.getString("JINGDIAN_DESC"),
						res.getString("JINGDIAN_DETAIL"), res.getString("JINGDIAN_PIC"),
						res.getString("JINGDIAN_TIME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, sta, res);

		}
		return jingDian;
	}

	/**
	 * 分页查询景点信息
	 */
	@Override
	public PageModel queryJingdianInfoForAll(int pageNo, int pageSize) {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		PageModel model = null;
		List<JingDian> dians = new ArrayList<>();
		try {
			con = JdbcUtils.getConnection();
			sta = con.prepareStatement(
					"select a1.* from(select rownum rn,JINGDIAN_TB.* from JINGDIAN_TB where rownum <= ?)a1 where rn >= ? ");
			sta.setInt(1, pageNo * pageSize);
			sta.setInt(2, (pageNo - 1) * pageSize);
			res = sta.executeQuery();
			while (res.next()) {

				JingDian jingDian = new JingDian(res.getInt("JINGDIAN_NO"), res.getString("JINGDIAN_TITLE"),
						res.getString("JINGDIAN_ADDRESS"), res.getInt("JINGDIAN_PRICE"), res.getString("JINGDIAN_DESC"),
						res.getString("JINGDIAN_DETAIL"), res.getString("JINGDIAN_PIC"),
						res.getString("JINGDIAN_TIME"));
				dians.add(jingDian);
			}
			model = new PageModel();
			model.setList(dians);
			model.setTotalRecords(getTotalRecords());
			model.setPageSize(pageSize);
			model.setPageNo(pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, sta, res);
		}
		return model;
	}

	/**
	 * 
	 * 查询总条数
	 */
	public int getTotalRecords() {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		int count = 0;
		try {
			con = JdbcUtils.getConnection();
			sta = con.prepareStatement("select count(*) from jingdian_tb");
			res = sta.executeQuery();
			while (res.next()) {
				count = res.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, sta, res);

		}
		return count;
	}

	/**
	 * 模糊查询分页（条件分页）
	 */
	@Override
	public PageModel searchLike(int pageNo, int pageSize, String name) {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		PageModel model = null;
		List<JingDian> dians = new ArrayList<>();
		try {
			con = JdbcUtils.getConnection();
			sta = con.prepareStatement(
					"select a1.* from(select rownum rn,JINGDIAN_TB.* from JINGDIAN_TB where rownum <= ? and jingdian_title like ?)a1 where rn >= ?");

			sta.setInt(1, pageNo * pageSize);
			sta.setString(2, "%" + name + "%");
			sta.setInt(3, (pageNo - 1) * pageSize);

			res = sta.executeQuery();
			while (res.next()) {

				JingDian jingDian = new JingDian(res.getInt("JINGDIAN_NO"), res.getString("JINGDIAN_TITLE"),
						res.getString("JINGDIAN_ADDRESS"), res.getInt("JINGDIAN_PRICE"), res.getString("JINGDIAN_DESC"),
						res.getString("JINGDIAN_DETAIL"), res.getString("JINGDIAN_PIC"),
						res.getString("JINGDIAN_TIME"));
				dians.add(jingDian);
			}
			model = new PageModel();
			model.setList(dians);
			model.setTotalRecords(getTotalRecords());
			model.setPageSize(pageSize);
			model.setPageNo(pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, sta, res);
		}
		return model;
	}
}
