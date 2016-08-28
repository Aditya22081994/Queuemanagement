package com.google.Customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;

@SuppressWarnings("serial")
public class CustomerToken extends HttpServlet {
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		

		Query q = new Query("CustomerToken");
		q.addSort("token",SortDirection.DESCENDING);
		
		PreparedQuery pq = ds.prepare(q);
		List<Entity> token = pq.asList(FetchOptions.Builder.withLimit(1));
		
		Entity result = token.get(0);
		long value = (long) result.getProperty("token");
		
		long incrementvalue = value+1;
		
		String sColumn = "8125860544"+incrementvalue;
		
		Entity customertoken = new Entity("CustomerToken",sColumn);
		customertoken.setProperty("token",incrementvalue);
		customertoken.setProperty("tokenkey",sColumn);
		ds.put(customertoken);
		
		request.setAttribute("TokenNo",incrementvalue);
		RequestDispatcher rd= request.getRequestDispatcher("TokenDisplay.jsp");
		
		rd.forward(request, response);
		
		
		
	}

}

