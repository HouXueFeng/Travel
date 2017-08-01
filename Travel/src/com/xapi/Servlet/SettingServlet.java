package com.xapi.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xapi.domain.Order;
import com.xapi.domain.User;
import com.xapi.service.CartServiceImp;

/**
 * Servlet implementation class SettingServlet
 */
@WebServlet("/SettingServlet")
public class SettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SettingServlet() {
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
		CartServiceImp cart = new CartServiceImp();
			//点击取消按钮删除当前订单和详情
			cart.delete_detail(Integer.valueOf(request.getParameter("orderno")));
			cart.delete_order(Integer.valueOf(request.getParameter("orderno")));
			request.getRequestDispatcher("/CartServlet?jingdianNo=").forward(request, response);
	}

}
