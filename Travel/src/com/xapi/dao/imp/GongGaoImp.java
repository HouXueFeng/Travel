package com.xapi.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xapi.dao.GongGaoDao;
import com.xapi.db.JdbcUtils;
import com.xapi.domain.GongGao;

public class GongGaoImp implements GongGaoDao {
	public static void main(String[] args) {
		/*List<GongGao> selectGongGaoInfo = new GongGaoImp().selectGongGaoInfo();
		for (GongGao gongGao : selectGongGaoInfo) {
			System.out.println(gongGao);
		}*/
		GongGao id = new GongGaoImp().selectGonggaoById(6);
		System.out.println(id);
	}

	
	/**
	 * 查询公告信息列表
	 */
	@Override
	public List<GongGao> selectGongGaoInfo() {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		List<GongGao> gaos = new ArrayList<>();
		try {
			con = JdbcUtils.getConnection();
			sta = con.prepareStatement("select * from gonggao_tb");
			res = sta.executeQuery();
			while (res.next()) {
				GongGao	gao = new GongGao(res.getInt("GONGGAO_NO"), res.getString("GONGGAO_TITLE"),
				res.getString("GONGGAO_CONTENT"), res.getString("GONGGAO_TIME"), res.getString("GONGGAO_PIC"),
				res.getInt("JINGDIAN_NO"));
				gaos.add(gao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(con, sta, res);
		}
		return gaos;
	}

	/**
	 * 查询单个公告详情
	 */
	@Override
	public GongGao selectGonggaoById(Integer id) {

		GongGao gao = null;
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			con = JdbcUtils.getConnection();
			sta = con.prepareStatement("select * from gonggao_tb where GONGGAO_NO=?");
			sta.setInt(1, id);
			res = sta.executeQuery();
			while (res.next()) {
				gao = new GongGao(res.getInt("GONGGAO_NO"), res.getString("GONGGAO_TITLE"),
						res.getString("GONGGAO_CONTENT"), res.getString("GONGGAO_TIME"), res.getString("GONGGAO_PIC"),
						res.getInt("JINGDIAN_NO"));
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			JdbcUtils.close(con, sta, res);
		}
		return gao;
	}
}
