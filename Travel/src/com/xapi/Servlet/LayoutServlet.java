package com.xapi.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LayoutServlet")
public class LayoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LayoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	HttpSession session=request.getSession();
	session.setAttribute("user", null);
	request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
	}

}
