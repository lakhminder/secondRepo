import javax.servlet.*;
import java.io.*;

public class RecieveCtx extends GenericServlet
{
	ServletContext ctx;
	ServletConfig cfig;
	/*public void init(ServletConfig cfig)throws ServletException
	{
		ctx = cfig.getServletContext();
	}*/
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		ctx=getServletConfig().getServletContext();
		res.setContentType("text/html");
		String name;
		PrintWriter pw = res.getWriter();
		name = (String)ctx.getAttribute("Name");
		pw.println("<B> The Name is" + name +" </B>");
		pw.close();
	}
}