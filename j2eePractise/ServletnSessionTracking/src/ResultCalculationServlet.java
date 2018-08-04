import javax.servlet.http.*;
import java.io.*;

public class ResultCalculationServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException
	{
		HttpSession session=request.getSession();
		String login=(String)session.getAttribute("login");
		if(login.equals("valid"))
		{
			int nMathsMarks,nEngMarks,nCompMarks;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<title> Result Calculation System</title>");
			out.println("<body>");

			nMathsMarks=Integer.parseInt(request.getParameter("MathMarks"));
			nEngMarks = Integer.parseInt(request.getParameter("EngMarks"));
			nCompMarks = Integer.parseInt(request.getParameter("CompMarks"));

			out.println("<p><b>Maths Marks:</b>"+nMathsMarks);
			out.println("<p><b>English Marks:</b>"+nEngMarks);
			out.println("<p><b>Computer Marks:</b>"+nCompMarks);
			out.println("</body>");
			out.println("</html>");
		}
		else
		{
			response.sendRedirect("LoginFailure.html"); 
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException
	{
		doPost(request,response);	
	}

}