package com.crud.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Manager extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8918394792511932424L;
	private static final String FILE_ENCODING = "UTF-8";

	Logger logger = LogManager.getLogger(this.getClass());

	private static final String RESOURCE_COMMON_LIST = "layouts/vn/ResourceCommonList.htm";

	private List<String> resourceCommonList = new ArrayList();

	private String appPath = "";
	private Random rand;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.service(req, resp);
//		System.out.println("This is manager.");
		
		String func = "";
		String err = "success";
//		HttpSession session = null;
//		session = request.getSession(false);
//		if (session == null) {
//			err = "Session is NULL";
//			response.sendRedirect(request.getContextPath() + "/login/login.jsp?invalid=1");
//			logger.info(err);
//			return;
//		}
		
		String reqURL= request.getQueryString();
		reqURL=reqURL.replaceAll(",", ";");
		System.out.println(">>>>>>>>> request URL: " + reqURL);
	     
		try {
		      response.setContentType("text/html; charset=utf-8");
//		      String ssId=session.getId();
		      
		   // lay param tren url, sau do lay duong dan file htm
				String cPath = request.getContextPath();
				String appPath = getServletContext().getRealPath(request.getRequestURI());
				System.out.println(">>>>>>>>> cPath: " + cPath + ", appPath: " + appPath);
				if(appPath==null) {
					appPath = getServletContext().getRealPath("/");
					appPath=appPath.replace('\\','/')+"main/";
				} else {
					appPath=appPath.replace('\\','/');
					if ( cPath.length() > 1 )
					{
					   int f1 = appPath.lastIndexOf(cPath);
					   appPath = appPath.substring(0,f1) + appPath.substring(f1 + cPath.length());
					}
					appPath = appPath.substring(0,appPath.lastIndexOf('/')+1);
				}
			
			     func = request.getParameter("func");
			     
			     String sTemplateFileName = func+".htm"; 
			     System.out.println(">>>>>>>>>>>>> sTemplateFileName: " + sTemplateFileName );
			  // lay param tren url, sau do lay duong dan file htm
		} catch (Exception t) {
	    	
	    	logger.info("ERROR-->LOGIN");
	    	response.sendRedirect(request.getContextPath() + "/login/login.jsp");
	    } finally {
	    	logger.info("FINISH");
	    }
	}
}
