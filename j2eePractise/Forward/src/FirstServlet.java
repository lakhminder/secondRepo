import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FirstServlet extends HttpServlet
{

	public void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("Welcome user");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/SecondServletAlias");
		rd.forward(req,res);
                                           
	}
	
}



