import javax.servlet.*;
import java.io.*;

public class SettingCTX extends GenericServlet
{
	ServletContext ctx;
	ServletConfig cfig;
	public void init(ServletConfig cfig)throws ServletException
	{
		ctx = cfig.getServletContext();
	}
	/*public void service(ServletRequest req,ServletResponse res) throws ServletException
	{
		ctx = cfig.getServletContext();
	}*/
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		ctx.setAttribute("Name","karROX Technologies");
		pw.println("<B> Name has been set by using Setting CTX servlet</B>");
		pw.close();
	}
}