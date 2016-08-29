package com.google.GroupFundDeployment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class AdminLogout extends HttpServlet implements java.io.Serializable{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		RequestDispatcher rd1 = request.getRequestDispatcher("Homepage.html");
		
	    	//invalidate the session if exists
    	HttpSession session = request.getSession(false);
    	if(session != null){
    		session.invalidate();
    	}
		 rd1.forward(request, response);
	}
}
