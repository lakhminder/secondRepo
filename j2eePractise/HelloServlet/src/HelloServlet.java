import javax.servlet.*;
import java.io.*;
public class HelloServlet extends GenericServlet
{
 public void service(ServletRequest req, ServletResponse res) throws IOException
 {
  PrintWriter out=res.getWriter();
  res.setContentType("text/html");
  out.println("<html>");
  out.println("<B>Hello World!!!</B>");
  out.println("</html>");
 }
}