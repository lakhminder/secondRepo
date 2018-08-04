import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


public class CsamPerformance extends HttpServlet {

	PreparedStatement pstmt=null,pstmt1=null;
	Connection conn=null;
	ResultSet rset=null,rset1=null;
	PrintWriter out=null;
	Calendar startDate = Calendar.getInstance();
	Calendar endDate = Calendar.getInstance();
	SimpleDateFormat sdf;
	String reqParam="";
	String reqParamMonth="";
	String reqParamYear="";
	/**
	 * The JNDI context factory to use. This is server specific, change if not
	 * using WebLogic
	 */
	private static final String JNDI_FACTORY = "weblogic.jndi.WLInitialContextFactory";

	/** URL of the server to connect. */
	private String serverUrl = null;

	/**conf file from where to load specifications  */
	private static final String CONF_FILE="config/conf";
	//private static final String CONF_FILE="C:/Documents and Settings/ls0021890/Desktop/amod_boyd/conf.properties";
	/**Datasource name to be used  */
	private String ct_dataSource="";

	/** Username to login to weblogic server. */
	private String userName = null;

	/** Login password for weblogic. */
	private String password = null;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html");
		out = response.getWriter();
		reqParamMonth=request.getParameter("lmonth");
		reqParamYear=request.getParameter("tyear");
		try
		{
			ResourceBundle resource = null;
			resource = ResourceBundle.getBundle(CONF_FILE);
			serverUrl = resource.getString("serverUrl");
			userName = resource.getString("username"); 			//not necessary
			password = resource.getString("password");			//not necessary
			ct_dataSource = resource.getString("ct_datasource");
		}catch(MissingResourceException e)
		{
			System.out.println("Inside Missing resource");
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			Hashtable env=new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,JNDI_FACTORY);						
			env.put(Context.PROVIDER_URL,serverUrl);
			env.put(Context.SECURITY_PRINCIPAL,userName);
			env.put(Context.SECURITY_CREDENTIALS,password);
			DataSource dataSource = (DataSource) (new InitialContext(env)).lookup(ct_dataSource);
			conn = dataSource.getConnection();
			if((reqParam=request.getParameter("CT")).equalsIgnoreCase("ct"))
			{
				pstmt = conn.prepareStatement("select sum(A_TASK_COUNT),sum(total),NAMESPACE_DESCRIPTION,sum(total)/sum(A_TASK_COUNT) avg_ct,max(DURATION_AUTO_MAX)" +
						" from" +
						" (" +
						" select (DURATION_AUTO * A_TASK_COUNT) as total,NAMESPACE_DESCRIPTION,A_TASK_COUNT,DURATION_AUTO_MAX" +
						" from" +
						" csam_ct" +
						//" where trunc(COMPLETION_DATE,'mm') between to_date('01-April-2008','dd-Mon-yyyy') and to_date('01-April-2008','dd-Mon-yyyy')" +
						" where trunc(COMPLETION_DATE,'mm') between ? and ? " +
						" )" +
						" group by NAMESPACE_DESCRIPTION" );
				//pstmt.setDate(1,new java.sql.Date(Integer.parseInt(reqParamYear),Integer.parseInt(reqParamMonth),01));
				System.out.println(startDate.get(Calendar.MONTH));
				startDate.set(Integer.parseInt(reqParamYear), Integer.parseInt(reqParamMonth)-1,1 );
				System.out.println(startDate.get(Calendar.MONTH));
				pstmt.setDate(1,new java.sql.Date(startDate.getTimeInMillis()));
				pstmt.setDate(2,new java.sql.Date(startDate.getTimeInMillis()));

			}else
			{
				pstmt = conn.prepareStatement("select NAMESPACE_DESCRIPTION,sum(T_A_TASK),sum(T_RTO_TASK),((sum(T_A_TASK) - sum(T_RTO_TASK))/sum(T_A_TASK))*100" +
						" from CSAM_RFT" + 
						" where" + 
						" trunc(COMPLETION_DATE,'mm') between to_date('01-April-2008','dd-Mon-yyyy') and to_date('01-April-2008','dd-Mon-yyyy')" + 
						" group by NAMESPACE_DESCRIPTION" + 
						" having sum(T_A_TASK)>0" + 
						" and" + 
						" sum(T_RTO_TASK)>0");

			}
			rset = pstmt.executeQuery();
			displayCommon();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	private void displayCommon()
	{
		sdf = new SimpleDateFormat( "MMMM" );
		//sdf.setCalendar(startDate);
		//sdf.format(startDate.getTime());
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");		
		//out.println("  <p align=center><b> " + reqParam.toUpperCase() + " for the " + startDate.get(Calendar.MONTH) + " month:</b>  ");
		out.println("  <p align=center><b> " + reqParam.toUpperCase() + " for the " + sdf.format(startDate.getTime()) + " month:</b>  ");
		out.println("</p>" +
		"<br>" );

		if(reqParam.equalsIgnoreCase("ct"))
		{
			displayCT();
		}else
		{
			displayRFT();
		}
		out.println("</table>");
		out.println("  </BODY>");
		out.println("</HTML>");

	}
	private void displayCT()
	{
//		CT
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("	<td>SUM(A_TASK_COUNT)</td>	");
		out.println("	<td>SUM(TOTAL)</td>		");
		out.println("	<td>NAMESPACE_DESCRIPTION</td>	");
		out.println("	<td>AVG_CT</td>			");
		out.println("	<td>MAX(DURATION_AUTO_MAX)</td>	");
		out.println("	</tr>				");	
		
		try
		{
			while (rset.next())
			{
				out.println("	</tr>				");
				out.println("	<td>" + rset.getString(1) + "</td>	");
				out.println("	<td>" + rset.getFloat(2) + "</td>	");
				out.println("	<td>" + rset.getString(3) + "</td>	");
				out.println("	<td>" + rset.getFloat(4) + "</td>	");
				out.println("	<td>" + rset.getString(5) + "</td>	");
				out.println("	</tr>				");

			}
			conn.close();
			conn= null;
			out.flush();
			out.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				if(rset != null)
					rset.close();
				if(pstmt != null)
					pstmt.close();
				if(pstmt1 != null)
					pstmt1.close();
				if(conn != null)
					conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

	private void displayRFT()
	{
//		RFT
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("	<td>NAMESPACE_DESCRIPTION</td>	");
		out.println("	<td>SUM(T_A_TASK)</td>		");
		out.println("	<td>SUM(T_RTO_TASK)</td>	");
		out.println("	<td>((SUM(T_A_TASK)-SUM(T_RTO_TASK))/SUM(T_A_TASK))*100</td>			");		
		out.println("	</tr>				");	
		
		try
		{
			while (rset.next())
			{
				out.println("	</tr>				");
				out.println("	<td>" + rset.getString(1) + "</td>	");
				out.println("	<td>" + rset.getInt(2) + "</td>	");
				out.println("	<td>" + rset.getInt(3) + "</td>	");
				out.println("	<td>" + rset.getFloat(4) + "</td>	");				
				out.println("	</tr>				");

			}
			conn.close();
			conn= null;
			out.flush();
			out.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				if(rset != null)
					rset.close();
				if(pstmt != null)
					pstmt.close();
				if(pstmt1 != null)
					pstmt1.close();
				if(conn != null)
					conn.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}
}
