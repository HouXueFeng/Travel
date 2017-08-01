package com.xapi.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xapi.dao.imp.JingDianImp;
import com.xapi.domain.GongGao;
import com.xapi.domain.JingDian;
import com.xapi.service.GongGaoServiceImp;

/**
 * Servlet implementation class SingleJingDianServlet
 */
@WebServlet("/SingleJingDianServlet")
public class SingleJingDianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SingleJingDianServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//单个信息景点展示，转化到页面
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		JingDianImp dianImp=new JingDianImp();
		JingDian jingDian = dianImp.selectJingDianById(Integer.valueOf(request.getParameter("jingdianNo")));
		request.setAttribute("jingDian", jingDian);
		request.getRequestDispatcher("WEB-INF/jsp/single.jsp").forward(request, response);
	}
}
