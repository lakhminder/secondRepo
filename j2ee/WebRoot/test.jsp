<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<%@ page import="java.sql.*,
				javax.sql.*,
				javax.naming.Context,
				javax.naming.InitialContext,
				java.util.*"
 %>
<HTML>
<HEAD>
<TITLE> New Document </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
</HEAD>

<BODY>
<!-- top intro paragraph tables -->
<!-- RED LINE -->
<table cellspacing="0" cellpadding="0"  border="0" width="100%">
  <tr>
    <td  width="100%" bgcolor="#ff0000" height="1">
      <p class="small">&nbsp</p>
    </td>
  </tr>
</table>

<%
	Statement stmt=null;
	Connection conn=null;
	ResultSet rset=null;

	
	try
		{
			Hashtable env=new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");//when using WEBLOGIC								
			DataSource dataSource = (DataSource) (new InitialContext(env)).lookup("luckydatasource");
			conn = dataSource.getConnection();
			stmt = conn.createStatement();		    
			rset = stmt.executeQuery ("select * from temp");
%>
<HR>
<table border=1 cellpadding=5>
  <th>ROLLNO</th>
  <th>NAME</th>
<%
 	  while (rset.next ()) {
      String name = rset.getString(2);
      String rollno = rset.getString(1);
%>
<tr>
       <td><%=  rollno != null ? rollno : "&nbsp;" %></td>
       <td><%= name %></td>
</tr>
<%
					      }
%>
</table>
<%
			rset.close();
			rset =  null;
			
			// Close the Statement
			stmt.close();
			stmt = null;
			conn.close();
			conn= null;
		}catch(Exception e)
		{
			System.out.println("<p>e.printStackTrace()</p>");
		}finally
		{
			try {
			      if(rset != null)
			        rset.close();
			      if(stmt != null)
			        stmt.close();
			      if(conn != null)
			        conn.close();
			    }catch(Exception e)
			    {
			    	System.out.println("<p>e.printStackTrace()</p>");
			    }
		}
%>

</BODY>
</HTML>
