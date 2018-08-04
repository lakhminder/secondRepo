import javax.servlet.*;
import java.io.*;

public class testing extends GenericServlet
{
	ServletContext ctx;
	ServletConfig cfig;
	/*public void init(ServletConfig cfig)throws ServletException
	{
		ctx = cfig.getServletContext();
	}
	/*public void service(ServletRequest req,ServletResponse res) throws ServletException
	{
		ctx = cfig.getServletContext();
	}*/
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		ctx=getServletConfig().getServletContext();
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		ctx.setAttribute("Name","Xyz Technologies");
		pw.println("<B> Name has been set by using Setting CTX servlet</B>");
		pw.close();
	}
}