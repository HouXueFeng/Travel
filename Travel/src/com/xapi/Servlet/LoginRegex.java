package com.xapi.Servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xapi.dao.imp.UserDaoImpl;
import com.xapi.domain.User;
import com.xapi.service.UserServiceimp;

import net.sf.json.JSONObject;

@WebServlet("/LoginRegex")
public class LoginRegex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginRegex() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		HttpSession session = request.getSession();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		User user2 = new User();
		user2.setUsername(user);
		System.out.println(new UserServiceimp().selectUserId(user)+"-->>>");
		//seesion存入用户信息
		user2.setId(Integer.valueOf(new UserServiceimp().selectUserId(user)));
		user2.setPassword(pass);
		UserDaoImpl userAction = new UserDaoImpl();
		JSONObject object = null;
		HashMap<Object, Object> hashMap = new HashMap<>();
		HashMap<Object, Object> hashMap2 = new HashMap<>();
		HashMap<Object, Object> hashMap3 = new HashMap<>();
		//把提示信息存到map集合中转化为json显示到前台
		if ("".equals(user) || user == null) {
			hashMap.put("msg", "登录账号不能为空！！");
			hashMap.put("success", 1);
			object = JSONObject.fromObject(hashMap);
			response.getWriter().print(object.toString());
		} else if ("".equals(pass) || pass == null) {
			hashMap.put("msg", "登录密码不能为空！！");
			hashMap.put("success", 2);
			object = JSONObject.fromObject(hashMap);
			response.getWriter().print(object.toString());
		} else{
			
			 if (userAction.login(user, pass) == 0) {
					hashMap2.put("msg", "账号或者密码错误");
					hashMap2.put("success", 3);
					object = JSONObject.fromObject(hashMap2);
					response.getWriter().print(object.toString());
				} else {
					hashMap3.put("msg", "登陆成功！！！");
					session.setAttribute("user", user2);
					hashMap3.put("success", 4);
					object = JSONObject.fromObject(hashMap3);
					response.getWriter().print(object.toString());
				}
			
		}
	}
}