package com.google.BankingOfficer;

	import java.io.IOException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.*;

	@SuppressWarnings("serial")
	public class BankingOfficerLogOut extends HttpServlet implements java.io.Serializable{
		
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
			
			RequestDispatcher rd1 = request.getRequestDispatcher("Homepage.html");
			
			Cookie[] cookies = request.getCookies();
	    	if(cookies != null){
	    	for(Cookie cookie : cookies){
	    		if(cookie.getName().equals("JSESSIONID")){
	    		 			break;
	    		}
	    	}
	    	}
	    	//invalidate the session if exists
	    	HttpSession session = request.getSession(false);
	    	    	if(session != null){
	    		session.invalidate();
	    	}
			 rd1.forward(request, response);
		}
	}