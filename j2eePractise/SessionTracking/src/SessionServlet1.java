import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionServlet1 extends HttpServlet
{

  public void doGet(HttpServletRequest request, HttpServletResponse response)
  			throws ServletException,IOException
  {
  	 HttpSession session = request.getSession(false);// if not don't create and return null
  	 response.setContentType("text/plain");
  	 PrintWriter out = response.getWriter();
  	 
  	 if(session == null)
               {
                  session = request.getSession(true); // if not create new
  	    out.println("It is new Session" + session);
               }
  	 else
  	  out.println("It is the old Session");   
  	 
  }
  public void doPost(HttpServletRequest request, HttpServletResponse response)
  			throws ServletException,IOException
  {
  	doGet(request,response);
  }
}