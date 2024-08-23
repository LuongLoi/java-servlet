package com.crud.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public final class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String username = request.getParameter("textUsername");
			String password = request.getParameter("textPassword");
			
			boolean isValid = LoginDAO.checkLogin(username, password);
			
			if (isValid == true) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/list");
				requestDispatcher.forward(request, response);
			} else {
				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login/login.jsp");
				requestDispatcher.forward(request, response);
			}
		} finally {
			out.close();
		}
	}

}
