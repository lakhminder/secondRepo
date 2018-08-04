import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.ejb.*;

public class StatelessClient extends HttpServlet
{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out=res.getWriter();
		out.println("Welcome to my Servlet");
		int n1=Integer.parseInt(req.getParameter("t1"));
		int n2=Integer.parseInt(req.getParameter("t2"));
		StatelessRem rem=null;
		StatelessHome home=null;
		InitialContext ctx=null;
		try
		{
			ctx=new InitialContext();
		}
		catch(Exception e)
		{
			out.println("First.."+e.toString());
		}

		try
		{
			home=(StatelessHome)ctx.lookup("StatelessBeanJNDI");

			//home=(StatelessHome)obj;
			//home=(StatelessHome)PortableRemoteObject.narrow(obj, StatelessHome.class);
		}
		catch(Exception ee)
		{
				out.println("Second.."+ee.toString());
		}

		try
		{
			rem=home.create();
		}
		catch(Exception eee)
		{
				out.println("Third.."+eee.toString());
		}

		int sum1=rem.sum(n1 ,n2);
		out.println("Sum of two numbers is.."+sum1);

	}
}

