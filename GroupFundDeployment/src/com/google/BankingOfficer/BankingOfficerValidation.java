package com.google.BankingOfficer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.SortDirection;

@SuppressWarnings("serial")
public class BankingOfficerValidation extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		System.out.println("Servlet Accessed");
		String username=request.getParameter("Busername");
		String password=request.getParameter("Bpassword");
		
		RequestDispatcher rd1 = request.getRequestDispatcher("BankingSuccess.jsp");
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		
		Query q = new Query("BankingOfficerTable");
		
		Filter filter=new FilterPredicate("username",Query.FilterOperator.EQUAL,username);
		q.setFilter(filter);
		q.addSort("username",SortDirection.ASCENDING);
		
		String dPass=null;
		PreparedQuery pq = ds.prepare(q);
		for(Entity result : pq.asIterable()){
			dPass = result.getProperty("password").toString();
		}
		
		if(password.equals(dPass)){
			HttpSession session = request.getSession();
			session.setAttribute("banking", username);
			
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", username);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			
			response.sendRedirect("BankingSuccess.jsp");
		} else {
			response.getWriter().println("Unsuccessful LogIn");
		}
		
}
}