package com.xapi.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xapi.domain.Order;
import com.xapi.domain.User;
import com.xapi.service.JingDianServiceImp;
import com.xapi.service.UserServiceimp;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public CartServlet() {
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
		String jingdianNo = request.getParameter("jingdianNo");
		JingDianServiceImp dianServiceImp = new JingDianServiceImp();
		//得到返回的自增主键
		Integer getid = dianServiceImp.getid();
		System.out.println(getid);
		 //得到session存的userId
		User user = (User) request.getSession().getAttribute("user");
		Integer id = user.getId();
		List<Order> userCart=null;
		System.out.println(id + "----->>>>>>>>>>");
		if (jingdianNo == null || ("").equals(jingdianNo)) {
			userCart= dianServiceImp.queryUserCart(user.getUsername());
			//如果jingdianno为空的话，查询当前用户的购物车
		} else {
			//根据返回的自增主键（orderno）进行插入订单
			dianServiceImp.insertOrder(getid, id, 1);
			//根据返回的自增主键（ordernotail）进行插入订单详情
			dianServiceImp.insertOrderDetail(getid, Integer.valueOf(jingdianNo), 1);
			//根据用户名查询订单列表
			userCart = dianServiceImp.queryUserCart(user.getUsername());
		}
		request.setAttribute("userCart", userCart);
		request.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(request, response);
	}

}
