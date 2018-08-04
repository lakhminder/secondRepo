import javax.servlet.http.*;
import java.io.*;

public class MarksEntryServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException
	{
		HttpSession session=request.getSession();
		String login=(String)session.getAttribute("login");
		
		if(login==null || !login.equals("valid")) //to confirm that request is coming from LoginValidationServlet only 
		{
			response.sendRedirect("LoginFailure.html"); 
		}
		else
		{
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<title>Data Entry for Marks</title>");
			out.println("<body>");
			out.println("<form method=post action=ResultCalculationServletAlias>");
			out.println("<p>Marks for Maths <input type=text name=MathMarks>");
			out.println("<p>Marks for English <input type=text name=EngMarks>");
			out.println("<p>Marks for Computer <input type=text name=CompMarks>"); 
			out.println("<p><input type=submit>");
			out.println("<input type=reset>");
			out.println("</form>");
			out.println("</html>");
			
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException
	{
		doPost(request,response);
	}
}