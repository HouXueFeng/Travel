package com.xapi.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xapi.domain.GongGao;
import com.xapi.service.GongGaoServiceImp;
import com.xapi.service.JingDianServiceImp;
import com.xapi.util.PageModel;

/**
 * Servlet implementation class GoIndexServlet
 */
@WebServlet("/GoIndexServlet")
public class GoIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public GoIndexServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//得到当前是第几页。
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		//页面显示条数
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		//景点名字
		String name = request.getParameter("jingdianName");
		//pagebean
		PageModel pageModel=null;
		JingDianServiceImp dianServiceImp=new JingDianServiceImp();
		GongGaoServiceImp gonggao = new GongGaoServiceImp();
		//分页查询出来的集合set到客户端
		List<GongGao> searchGonggaoInfo = gonggao.searchGonggaoInfo();
		request.setAttribute("gonggaoList", searchGonggaoInfo);
		if (name==null) {
			pageModel=dianServiceImp.queryJingdianInfoForAll(pageNo, pageSize);
		}else{
			//分页查询出来模糊查询的集合set到客户端
			pageModel=dianServiceImp.searchLike(pageNo, pageSize, name);
		}
		request.setAttribute("pageModel", pageModel);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

}
