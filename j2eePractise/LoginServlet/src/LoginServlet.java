import javax.servlet.*;
import javax.servlet.http.*;

import weblogic.logging.NonCatalogLogger;

import java.io.*;
import java.net.MalformedURLException;

public class LoginServlet extends HttpServlet
{
	NonCatalogLogger logger = null;

	private String contextPath = "";
	public void init(final ServletConfig servConfig) throws ServletException {
		super.init(servConfig);
		try {
			logger = new NonCatalogLogger("Logger");
			contextPath = servConfig.getServletContext().getResource("/").toString();
			logger.debug (servConfig.getServletContext().toString());
			System.out.println("System print:" + contextPath);
		} catch (MalformedURLException me) {
			me.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// getting parameters
		String strUserID = request.getParameter("uid");
		String strPassword = request.getParameter("password");  

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