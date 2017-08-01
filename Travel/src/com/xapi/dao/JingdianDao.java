package com.xapi.dao;

import java.util.List;

import com.xapi.domain.JingDian;
import com.xapi.util.PageModel;

public interface JingdianDao {
	public List<JingDian> selectJingDianInfo();//查询景点信息集合
	public JingDian selectJingDianById(Integer id);//查询景点信息按照景点编号查找
	public PageModel queryJingdianInfoForAll( int pageNo, int pageSize);//分页查询景点信息列表
	public int getTotalRecords(); //得到总记录条数
	public PageModel searchLike(int pageNo, int pageSize,String name);//分页查询景点（模糊查询）
}
