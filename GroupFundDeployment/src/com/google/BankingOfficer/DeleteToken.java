package com.google.BankingOfficer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


@SuppressWarnings("serial")
public class DeleteToken extends HttpServlet {
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
		
	String keyvalue = request.getParameter("tokenkey");
	
	out.println(keyvalue);
		
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		
		Key keysecond = KeyFactory.createKey("CustomerToken",keyvalue);
		
			
		ds.delete(keysecond);
		
		RequestDispatcher rd = request.getRequestDispatcher("CustomerTokenTable.jsp");
		
		rd.forward(request, response);
		
	}

}