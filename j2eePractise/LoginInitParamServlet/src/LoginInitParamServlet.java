import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class LoginInitParamServlet extends HttpServlet
{
  public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
{
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
 
  // getting parameters
  String strUserID = request.getParameter("uid");
  String strPassword = request.getParameter("password");  
  if(strUserID.length() == 0 || strPassword.length() == 0)
  {
     strUserID = getInitParameter("UserID");	//method from ServletConfig interface
     strPassword = getInitParameter("Password");	
  } 
  out.println("<html>");
  out.println("<title>Servlet working with parameters</title>");
  out.println("<body");
  
  out.println("<p><b>User id = "+strUserID+"</b>");
  out.println("<p><b>Password = "+strPassword+"</b>");

  out.println("</body>");
  out.println("</html>");
}
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
{
  doPost(request,response);
}
}