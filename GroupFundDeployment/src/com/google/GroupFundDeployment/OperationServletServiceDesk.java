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



	public class OperationServletServiceDesk extends HttpServlet {
			private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.setContentType("text/html");
			System.out.println("Servlet Accessed");
			response.getWriter().println("Servlet Accessed");
			RequestDispatcher rd = request.getRequestDispatcher("ServiceDeskTable.jsp");

			DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
			
			String buttontypeOne=request.getParameter("AddSbutton");
			String buttontypeTwo=request.getParameter("ModifySbutton");
			String buttontypeThree=request.getParameter("DeleteSbutton");
			
			
			 		
			 if(buttontypeOne!=null){	
				   int sCode = Integer.parseInt(request.getParameter("AddScode"));
				   int bCode = Integer.parseInt(request.getParameter("AddSbranchCode"));
				   String sStatus = request.getParameter("AddSstatus");
				   String keyservicedesk = "879075228"+sCode;
				
				   Entity servicedesk = new Entity("ServiceDeskTable",keyservicedesk);
				   
					servicedesk.setProperty("scode",sCode);
					servicedesk.setProperty("bcode",bCode);
					servicedesk.setProperty("status",sStatus);
					
				 ds.put(servicedesk);
			   }
				else if(buttontypeTwo!=null){
					int sCode =Integer.parseInt(request.getParameter("ModifyScode"));
					   String bCode = request.getParameter("ModifySbranchCode");
					   String sStatus = request.getParameter("ModifySstatus");
					   
					   String keyservicedesk = "879075228"+sCode;
						
					   Entity servicedesk = new Entity("ServiceDeskTable",keyservicedesk);
					   
						servicedesk.setProperty("scode",sCode);
						servicedesk.setProperty("bcode",bCode);
						servicedesk.setProperty("status",sStatus);
						
					 ds.put(servicedesk);
							 
				
				   }
				else if(buttontypeThree!=null){
					String sCode = request.getParameter("DeleteScode");
					 String keyservicedesk = "879075228"+sCode;
					 
					 Key keyservicedesksecond = KeyFactory.createKey("ServiceDeskTable",keyservicedesk);
					 
					 ds.delete(keyservicedesksecond);
							}
			   rd.forward(request, response);
			   
		}
	}




