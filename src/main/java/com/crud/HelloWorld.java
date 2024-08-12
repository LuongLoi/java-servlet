package com.crud;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Start Servlet");
	}
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println(req.getMethod());
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");  
		PrintWriter pw=resp.getWriter();  
		  
		String name=req.getParameter("name");//will return value  
		  
		String context_root = req.getContextPath();
		pw.println("Welcome "+ name +" " +context_root );
		pw.close();
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("End Servlet");
	}
}
