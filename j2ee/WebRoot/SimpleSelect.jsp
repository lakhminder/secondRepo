<!-- Copyright (c) 1999-2004 by BEA Systems, Inc. All Rights Reserved.-->
<!doctype html public "-//w3c/dtd HTML 4.0//en">

<!-- Creates an HTML page that can be used interactively to take
input from a client and then structure a query with it. -->

<%@ page import="java.util.Properties,
                 java.io.PrintWriter,
                 java.sql.*"
 %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;CHARSET=iso-8859-1">
<meta name="description" content="BEA WebLogic Server">
<meta name="keywords" content="BEA WebLogic Server">
<title>Simple Select</title>
<LINK REL="stylesheet"
TYPE="text/css"
HREF="wls_examples.css"
TITLE="BEA WebLogic Server">
</head>

<body bgcolor="#ffffff" link="#3366cc" vlink="#9999cc" alink="#0000cc">

<!-- top intro paragraph tables -->
<!-- RED LINE -->
<table cellspacing="0" cellpadding="0"  border="0" width="100%">
  <tr>
    <td  width="100%" bgcolor="#ff0000" height="1">
      <p class="small">&nbsp;</p>
    </td>
  </tr>
</table>

<!-- TITLE -->
<table border=0 cellspacing="18" cellpadding="0">
  <tr>
    <td valign="top">
      <a HREF="http://www.bea.com"><IMG SRC="images/logo_tm_onwt.jpg" alt="BEA Logo" border="0"></a>
      <h3>Simple Select</h3>
    </td>
  </tr>
</table>

<!-- RED LINE -->
<table cellspacing="0" cellpadding="0"  border="0" width="100%">
  <tr>
    <td  width="100%" bgcolor="#ff0000" height="1">
      <p class="small">&nbsp;</p>
    </td>
  </tr>
</table>

<!-- EXAMPLE CONTENT -->
<table summary="EXAMPLES_CONTENT" border=0 cellspacing="18" cellpadding="0">
  <tr>
    <td valign="top">
      <p>
<%
  Connection conn  = null;
  Statement stmt = null;
  ResultSet rs = null;
  try {
    Driver myDriver = (Driver) Class.forName("weblogic.jdbc.pool.Driver").newInstance();
    conn = myDriver.connect("jdbc:weblogic:pool:demoPool", null);
    
    stmt = conn.createStatement();
    rs = stmt.executeQuery("select * from emp " + "where sal < 2000 " + "order by empno");
 %>
  <HR>
  <table border=1 cellpadding=5>
  <th>EMPNO</th>
  <th>ENAME</th>
  <th>JOB</th>
  <th>MGR</th>
  <th>HIREDATE</th>
  <th>SAL</th>
  <th>COMM</th>
  <th>DEPTNO</th>

 <%
 	  while (rs.next()) {
      String ename = rs.getString("ename");
 %> 
      <tr>
       <td><%= rs.getString("empno") != null ? rs.getString("empno") : "&nbsp;" %></td>
       <td><%= ename %></td>
       <td><%= rs.getString("job") != null ? rs.getString("job") : "&nbsp;" %></td>
       <td><%= rs.getString("mgr") != null ? rs.getString("mgr") : "&nbsp;" %></td>
       <td><%= rs.getString("hiredate") != null ? rs.getString("hiredate") : "&nbsp;" %></td>
       <td><%= rs.getString("sal") != null ? rs.getString("sal") : "&nbsp;" %></td>
       <td><%= rs.getString("comm") != null ? rs.getString("comm") : "&nbsp;" %></td>
       <td><%= rs.getString("deptno") != null ? rs.getString("deptno") : "&nbsp;" %></td>
      </tr>
 <%
    }
 %>
	</table>
 <%
  }
  catch (Exception ex){
    out.println("<p><b>!! Example Failed !!<br><br> The following exception occur:</b><br><br>");
    ex.printStackTrace(new PrintWriter(out));
  }
  finally {
    try {
      if(rs != null)
        rs.close();
      if(stmt != null)
        stmt.close();
      if(conn != null)
        conn.close();
    } catch (SQLException sqlex){
      out.println("<p><b>!! Example Failed !!<br><br> The following exception occur:</b><br><br>");
      sqlex.printStackTrace(new PrintWriter(out));
    }
  }
%>
    </td>
  </tr>
</table>
<br>

<!-- RED LINE -->
<table cellspacing="0" cellpadding="0"  border="0" width="100%">
  <tr>
    <td  width="100%" bgcolor="#ff0000" height="1">
      <p class="small">&nbsp;</p>
    </td>
  </tr>
</table>

<!-- FOOTER -->
<table cellspacing="0" cellpadding="0" border="0" width="100%">
  <tr>
    <td align="left">
      <p class="copyright">Last updated: March 2004</p>
    </td>
  </tr>
</table>

<!-- RED LINE -->
<table cellspacing="0" cellpadding="0"  border="0" width="100%">
  <tr>
    <td  width="100%" bgcolor="#ff0000" height="1">
      <p class="small">&nbsp;</p>
    </td>
  </tr>
</table>

<p class="copyright"><a href="http://www.bea.com">Home</a> |
  <a href="http://www.bea.com/about/index.html" target="_top">Corporate Info</a> |
  <a href="http://www.bea.com/press/index.html" target="_top">News</a> |
  <a href="http://www.bea.com/solutions/index.html" target="_top">Solutions</a> |
  <a href="http://www.bea.com/products/index.html" target="_top">Products</a> |
  <a href="http://www.bea.com/partners/index.html" target="_top">Partners</a> |
  <a href="http://www.bea.com/services.html" target="_top">Services</a> |
  <a href="http://www.bea.com/events/index.html" target="_top">Events</a> |
  <a href="http://www.bea.com/download.html" target="_top">Download</a> |
  <a href="http://www.bea.com/purchase.html" target="_top">How to Buy</a>
  <br>Copyright 2004, BEA Systems, Inc. All rights reserved.
  <br>Required browser: Netscape 4.0 or higher, or Microsoft Internet Explorer 4.0 or higher.
  <br> <a href="http://www.bea.com/contact/index.html" target="_top">Contact BEA</a>
</p>

</body>
</html>

