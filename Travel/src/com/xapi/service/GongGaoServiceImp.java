package com.xapi.service;

import java.util.List;

import com.xapi.dao.GongGaoDao;
import com.xapi.db.DaoFactory;
import com.xapi.domain.GongGao;

public class GongGaoServiceImp {

	public static void main(String[] args) {
		List<GongGao> searchGonggaoInfo = new GongGaoServiceImp().searchGonggaoInfo();
		for (GongGao gongGao : searchGonggaoInfo) {
			System.out.println(gongGao);
		}
	}
	//反射得到类实例对象
	GongGaoDao gongGaoDao = DaoFactory.getInstance().createDao("com.xapi.dao.imp.GongGaoImp", GongGaoDao.class);

	public List<GongGao> searchGonggaoInfo() {
		return gongGaoDao.selectGongGaoInfo();

	}

	public GongGao selectGonggaoById(Integer id) {
		return gongGaoDao.selectGonggaoById(id);

	}
}
