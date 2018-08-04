import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginValidationServlet extends HttpServlet
{
  public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException,IOException
  {
    doPost(req,res);	
  }	 
  public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException,IOException
  {
   	String strUserName = req.getParameter("uname");
   	String strPassword = req.getParameter("pass");
            	
   	RequestDispatcher rd = getServletContext().getRequestDispatcher("/MarksEntryServletAlias");
   	
   	if(strUserName.equals("Sanjay") && strPassword.equals("Joshi"))
   	{
     	  ServletContext context = getServletContext();
     	  //context.setAttribute("Authentication","done");
     	  rd.forward(req,res);
   	 }
    	else
      	  res.sendRedirect("LoginFailure.html");    
  }	 
}