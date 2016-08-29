package com.google.GroupFundDeployment;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;


@SuppressWarnings("serial")
public class OperationServletBankingOfficer extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	System.out.println("Servlet Accessed");
	response.getWriter().println("Servlet Accessed");
	RequestDispatcher rd = request.getRequestDispatcher("BankingOfficerTable.jsp");

	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	
	String buttontypeOne=request.getParameter("AddButton");
	String buttontypeTwo=request.getParameter("ModifyButton");
	String buttontypeThree=request.getParameter("DeleteButton");
	
	
	
   if(buttontypeOne!=null){	
	   int eCode = Integer.parseInt(request.getParameter("AddCode"));
	   String eName = request.getParameter("AddName");
	   String eUsername = request.getParameter("AddUsername");
	   String ePassword = request.getParameter("AddPassword");
	   String keyvalue = "8790"+eCode;
	   
	   Entity bankingofficer = new Entity("BankingOfficerTable",keyvalue);
	   
	   bankingofficer.setProperty("ocode",eCode);
	   bankingofficer.setProperty("oname",eName);
	   bankingofficer.setProperty("username",eUsername);
	   bankingofficer.setProperty("password",ePassword);
	   bankingofficer.setProperty("key", keyvalue);
		
	 ds.put(bankingofficer);

   }
	else if(buttontypeTwo!=null){
		int eCode = Integer.parseInt(request.getParameter("ModifyCode"));
		   String eName = request.getParameter("ModifyName");
		   String eUsername = request.getParameter("ModifyUsername");
		   String ePassword = request.getParameter("ModifyPassword");
		   
		   String keyvalue = "8790"+eCode;
		   
		   Entity bankingofficer = new Entity("BankingOfficerTable",keyvalue);
		   
		   bankingofficer.setProperty("ocode",eCode);
		   bankingofficer.setProperty("oname",eName);
		   bankingofficer.setProperty("username",eUsername);
		   bankingofficer.setProperty("password",ePassword);
		   bankingofficer.setProperty("key", keyvalue);
			
		 ds.put(bankingofficer);
				 
		
	   }
	else if(buttontypeThree!=null){
		int eCode = Integer.parseInt(request.getParameter("DeleteCode"));
		String keyvalue = "8790"+eCode;
		Key keysecond = KeyFactory.createKey("BankingOfficerTable",keyvalue);
		
		ds.delete(keysecond);

	}
   rd.forward(request, response);
	}
}
