package com.xapi.Servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xapi.dao.imp.UserDaoImpl;
import com.xapi.domain.User;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class RegisterRegex
 */
@WebServlet("/RegisterRegex")
public class RegisterRegex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterRegex() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDaoImpl userAction = new UserDaoImpl();
		response.setContentType("application/json; charset=UTF-8");
		HashMap<Object, Object> hashMap = new HashMap<>();
		HashMap<Object, Object> hashMap2 = new HashMap<>();
		HashMap<Object, Object> hashMap3 = new HashMap<>();
		HashMap<Object, Object> hashMap4 = new HashMap<>();
		HashMap<Object, Object> hashMap5 = new HashMap<>();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String truename = request.getParameter("truename");
		String yanzhengma = request.getParameter("yanzhengma");
		User user2 = new User(user, pass, truename);
		if ("".equals(user)  || user == null || "".equals(pass)  || pass == null || yanzhengma.equals("")
				|| yanzhengma == null || "".equals(truename)  || truename == null) {
			hashMap.put("msg", "注册信息不能为空");
			hashMap.put("success", false);
			JSONObject object = JSONObject.fromObject(hashMap);
			response.getWriter().print(object.toString());
		} else {
			if (userAction.exitUsername(user)) {
				hashMap2.put("msg", "用户已存在！");
				hashMap2.put("success", false);
				JSONObject object = JSONObject.fromObject(hashMap2);
				response.getWriter().print(object.toString());
			} else if (!(yanzhengma).equals(RegisterServlet.buffers2().toString())) {
				hashMap3.put("msg", "验证码错误！");
				hashMap3.put("success", false);

				JSONObject object = JSONObject.fromObject(hashMap3);
				response.getWriter().print(object.toString());
			} else {
				int register = userAction.register(user2);
				if (register == 1) {
					hashMap4.put("msg", "注册成功");
					hashMap4.put("success", true);

					JSONObject object = JSONObject.fromObject(hashMap4);
					response.getWriter().print(object.toString());
				} else {
					hashMap5.put("msg", "系统异常");
					hashMap5.put("success", false);

					JSONObject object = JSONObject.fromObject(hashMap5);
					response.getWriter().print(object.toString());
				}

			}
		}
	}
}
