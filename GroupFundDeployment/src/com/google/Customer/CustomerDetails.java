package com.google.Customer;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class CustomerDetails extends HttpServlet {
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cName = request.getParameter("Cname");
		String cMobile = request.getParameter("Cmobile");
		String cEmail = request.getParameter("Cemail");
		int cTransid = Integer.parseInt(request.getParameter("Ctransid"));
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Date date = new Date();

		Entity customerdetail = new Entity("CustomerDetailsTable");
		customerdetail.setProperty("name",cName);
		customerdetail.setProperty("mobileno",cMobile);
		customerdetail.setProperty("emailid",cEmail);
		customerdetail.setProperty("transactionid",cTransid);
		customerdetail.setProperty("date",date.toString());
		
		ds.put(customerdetail);
		
		RequestDispatcher rd = request.getRequestDispatcher("CustomerGenerateToken.html");
		
		rd.forward(request, response);
		
	}
}