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
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Key;


	public class OperationServletBranch extends HttpServlet {
		private static final long serialVersionUID = 1L;
	  
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.setContentType("text/html");
			System.out.println("Servlet Accessed");
			response.getWriter().println("Servlet Accessed");
			RequestDispatcher rd = request.getRequestDispatcher("BranchTable.jsp");

			DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
			
			String buttontypeOne=request.getParameter("AddBbutton");
			String buttontypeTwo=request.getParameter("ModifyBbutton");
			String buttontypeThree=request.getParameter("DeleteBbutton");
			
			  		
		   if(buttontypeOne!=null){	
			   int bCode = Integer.parseInt(request.getParameter("AddBcode"));
			   String bLocation = request.getParameter("AddBlocation");
			   String keybranch = "879075"+bCode;

			   Entity branch = new Entity("BranchTable",keybranch);
			   
			   branch.setProperty("bcode",bCode);
			   branch.setProperty("blocation",bLocation);
		
				ds.put(branch);
		   }
			else if(buttontypeTwo!=null){
				int bCode = Integer.parseInt(request.getParameter("ModifyBcode"));
				String bLocation = request.getParameter("ModifyBlocation");
				
				 String keybranch = "879075"+bCode;

				   Entity branch = new Entity("BranchTable",keybranch);
				   
				   branch.setProperty("bcode",bCode);
				   branch.setProperty("blocation",bLocation);
			
					ds.put(branch);
	
			
	
			   }
			else if(buttontypeThree!=null){
				   int bCode = Integer.parseInt(request.getParameter("DeleteBcode"));
				   String keybranch = "879075"+bCode;

				   Key keyString = KeyFactory.createKey("BranchTable",keybranch);
				  
				   ds.delete(keyString);
		
			}
		   rd.forward(request, response);
			}

}
