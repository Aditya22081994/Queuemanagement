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
public class OperationServletProduct extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		System.out.println("Servlet Accessed");
		response.getWriter().println("Servlet Accessed");
		RequestDispatcher rd = request.getRequestDispatcher("ProductTable.jsp");

		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		
		String buttontypeOne=request.getParameter("AddPbutton");
		String buttontypeTwo=request.getParameter("ModifyPbutton");
		String buttontypeThree=request.getParameter("DeletePbutton");
		
		 		
	   if(buttontypeOne!=null){	
		   int pCode = Integer.parseInt(request.getParameter("AddPcode"));
		   String pDescription = request.getParameter("AddPdescription");
		   String keyproduct = "8790752"+pCode;

		   Entity product = new Entity("TransactionTable",keyproduct);
		   product.setProperty("transactionid",pCode);
		   product.setProperty("transactiondescription",pDescription);
		   
		   ds.put(product);
	   }
		else if(buttontypeTwo!=null){
			int pCode = Integer.parseInt(request.getParameter("ModifyPcode"));
			String pDescription = request.getParameter("ModifyPdescription");
			 String keyproduct = "8790752"+pCode;

			   Entity product = new Entity("TransactionTable",keyproduct);
			   product.setProperty("transactionid",pCode);
			   product.setProperty("transactiondescription",pDescription);
			   
			   ds.put(product);
			  
		   }
		else if(buttontypeThree!=null){
			String pCode = request.getParameter("DeletePcode");
			   String keyproduct = "8790752"+pCode;

			   Key keyproductsecond = KeyFactory.createKey("TransactionTable",keyproduct);
		  
			   ds.delete(keyproductsecond);
	
		}
	   
	   rd.forward(request, response);
		}
	}



