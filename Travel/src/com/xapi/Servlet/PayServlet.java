package com.xapi.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xapi.service.CartServiceImp;
import com.xapi.service.JingDianServiceImp;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PayServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String money = request.getParameter("money");
		//得到支付的money。
		CartServiceImp cartServiceImp=new CartServiceImp();
		request.setAttribute("money", money);
		if (Integer.valueOf(money)==0) {
			//如果没有购买商品即购买的钱数为0
			request.setAttribute("msg", null);
			request.getRequestDispatcher("/CartServlet?jingdianNo=").forward(request, response);
			//转发到购物车页面即当前页面
		}else{
			//支付成功删除用户购买的信息
		cartServiceImp.delete_detailAll();
		cartServiceImp.delete_orderAll();
		request.getRequestDispatcher("WEB-INF/jsp/success.jsp").forward(request, response);
		}
	}

}
