package com.google.GroupFundDeployment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.*;


@SuppressWarnings("serial")
public class AdminValidation extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		

	String username=request.getParameter("Ausername");
	String password=request.getParameter("Apassword");
	
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	
	Query q = new Query("AdminTable");
	
	Filter filter=new FilterPredicate("username",Query.FilterOperator.EQUAL,username);
	q.setFilter(filter);
	q.addSort("username");
	
	String dPass=null;
	PreparedQuery pq = ds.prepare(q);
	for(Entity result : pq.asIterable()){
		dPass = result.getProperty("password").toString();
	}
	
	if(password.equals(dPass)){
		HttpSession session = request.getSession();
		session.setAttribute("user", username);
		session.setMaxInactiveInterval(30*60);
		
		Cookie userName = new Cookie("user", username);
		userName.setMaxAge(30*60);
		response.addCookie(userName);
		
		response.sendRedirect("AdminSuccess.jsp");
       
	
	} else {
		response.getWriter().println("Unsuccessful LogIn");
	}
	
	
	
	}
}
