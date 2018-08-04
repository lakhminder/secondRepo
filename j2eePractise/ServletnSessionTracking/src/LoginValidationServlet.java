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
		HttpSession session=req.getSession();

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/MarksEntryServletAlias");

		if(strUserName.equals("Sanjay") && strPassword.equals("Joshi"))
		{
			ServletContext context = getServletContext();
			//context.setAttribute("Authentication","done");
			session.setAttribute("login","valid");	//to validate that request to MarksEntryServletAlias is 
			//	made after passing through LoginValidationServlet/login.html only
			rd.forward(req,res);
		}
		else
			res.sendRedirect("LoginFailure.html");    
	}	 
}