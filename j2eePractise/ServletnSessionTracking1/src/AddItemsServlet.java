import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class AddItemsServlet extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
  {
     doPost(request,response);
  }
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
 {
    Connection con;
    Statement stmt;
    ResultSet rs;         
   try
   { 
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
      con = DriverManager.getConnection("jdbc:odbc:MyDSN","","");
      stmt = con.createStatement();
      rs = stmt.executeQuery("select * from product_master");
      response.setContentType("text/html");	
      PrintWriter out = response.getWriter();
      out.println("<html>");
      out.println("<title>Add Item to Shopping Cart</title>");
      out.println("<body>");
      out.println("<form method=post action=ActionProcessorServletAlias>");
      out.println("<select name=ProductCombo>");
    
      while(rs.next())
      {
        out.println("<option>"+rs.getString("ProductName")+"</option>");
      }
       out.println("</select>");
       out.println("<p>Quantity <input type=text name=QtyOrdered>");
       out.println("<p><input type=submit name=button value='Add to Cart'>");
       out.println("<p><input type=submit name=button value='View Cart'>");
       out.println("<p><input type=submit name=button value='Reset Cart'>");
       out.println("</form>");
       out.println("</body>");
       out.println("</html>"); 
    
       rs.close();
      stmt.close();
      con.close();
   }catch(Exception e)
  {
    e.printStackTrace();
   }
 }
}