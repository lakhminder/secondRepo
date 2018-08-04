import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ActionProcessorServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException
	{
		

		String strAction = request.getParameter("button");
		
		
		
		if(strAction.equals("Add to Cart"))
		{
		  //code to place the order in Session variables
		
		HttpSession session = request.getSession(true);
		ArrayList list = (ArrayList) session.getAttribute("CartItems");		
 		  
		if(list == null)  //check that adding first item
		  {
			//create the new object of ArrayList
		  	ArrayList newList = new ArrayList();
		  	String strProdName = request.getParameter("ProductCombo");
		  	String strQty = request.getParameter("QtyOrdered");
		  	Product p = new Product(strProdName,Integer.parseInt(strQty));
			newList.add(p);   	
			//save the ArrayList object as session attribute
			session.setAttribute("CartItems",newList);
		  	System.out.println("new order");
		  }
		  else
		  {
		  	String strProdName = request.getParameter("ProductCombo");
		  	String strQty = request.getParameter("QtyOrdered");
		  	Product p = new Product(strProdName,Integer.parseInt(strQty));
			list.add(p);   	
		    System.out.println("existing order");
		  }
		  
		  RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddItemsServletAlias");	
		  rd.forward(request,response);
		}
		else if(strAction.equals("View Cart"))
		{
		  RequestDispatcher rd = getServletContext().getRequestDispatcher("/ShowItemsServletAlias");	
		  rd.forward(request,response);
		}
		else //Reset Cart
		{
		      //remove the session attribute
		      HttpSession session = request.getSession(true);
		     session.removeAttribute("CartItems");

    		     //stay at the same page
		     RequestDispatcher rd = getServletContext().getRequestDispatcher("/AddItemsServletAlias");	
		     rd.forward(request,response);
	
		}
	 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException
	{
		doPost(request,response);				
	}
}

