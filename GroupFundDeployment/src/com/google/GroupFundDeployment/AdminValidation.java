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
		
	System.out.println("Servlet Accessed");
	String username=request.getParameter("Ausername");
	String password=request.getParameter("Apassword");
	
	RequestDispatcher rd1 = request.getRequestDispatcher("AdminSuccess.jsp");
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	
	Query q = new Query("AdminTable");
	
	Filter filter=new FilterPredicate("username",Query.FilterOperator.EQUAL,username);
	q.setFilter(filter);
	q.addSort("username");
	
	String dPass=null;
	PreparedQuery pq = ds.prepare(q);
	for(Entity result : pq.asIterable()){
		dPass = result.getProperty("password").toString();
		System.out.println("Obtained Password: "+ dPass);
	}
	
	if(password.equals(dPass)){
       request.setAttribute("Admin",username);
       
		rd1.forward(request, response);
	} else {
		response.getWriter().println("Unsuccessful LogIn");
	}
	
	
	
	}
}
