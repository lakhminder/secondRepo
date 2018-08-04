import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class ShowItemsServlet extends HttpServlet
{
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
  {
     response.setContentType("text/html");
      PrintWriter out = response.getWriter();      
  
      out.println("<html>");
      out.println("<title>Shopping cart items</title>	"); 
      out.println("<body>");
      
      HttpSession session = request.getSession(true);		
      ArrayList list = (ArrayList) session.getAttribute("CartItems");
      System.out.println("in show items");

      if(list == null)
      {
         out.println("<B>No items in the list </B>");
         System.out.println("inside if");
      }
      else
      {
              System.out.println("inside else, list.size()="+list.size());
              
          for(int i=0;i<list.size();i++)
          {
              Product tmpProd = (Product) list.get(i);
              out.println("Product Name :"+tmpProd.getName()+" Qty ordered:  "+tmpProd.getqty()+"<br>") ;
              System.out.println("inside else-for");
          }	
      } 
   out.println("</body>");
   out.println("</html>");
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
  {
     doPost(request,response);
  }
}