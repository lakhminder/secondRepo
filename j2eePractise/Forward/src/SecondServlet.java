import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SecondServlet extends HttpServlet
{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<form> welcome "+req.getParameter("name")+" from"+req.getParameter("city"));
		out.println("Enter age :<input type='text' name='age'> <br>");
		out.println("Enter phone:<input type='text' name='phone'> <br></form>");
	}
}