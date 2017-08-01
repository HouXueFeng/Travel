package com.xapi.dao;

import java.util.List;

import com.xapi.domain.GongGao;

public interface GongGaoDao {
	//查询所有公告信息
	public List<GongGao> selectGongGaoInfo();
	//查询单个公告
	public GongGao selectGonggaoById(Integer id);
}
