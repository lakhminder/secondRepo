import  javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionServlet3 extends HttpServlet
{
	Integer counter;
public void init(ServletConfig config)throws ServletException
{
	super.init(config);
}

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
{
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<html><h1>");
	HttpSession session = request.getSession(false);
	if(session==null)
	{	
		session=request.getSession(true);
		out.println("Welcome new Comer");
		out.println("You are visiting for first time");
		out.println("Session id is="+session.getId());
		counter = new Integer(1);
		session.setAttribute("COUNTER",counter);
	}
	else
	{
		out.println("You are existin member");
		Integer tempCount = (Integer) session.getAttribute("COUNTER");
		int count=tempCount.intValue();
		session.setAttribute("COUNTER",new Integer(++count));
		out.println("You visited this site "+count+" times");
	}
}

}