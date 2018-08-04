<B> Hello from me </B>
<%
  out.println("<B>HeLlO</b>");
  if ((request.getParameter("userName").equals("Richard")) &&
      (request.getParameter("password").equals("xyzzy"))) {
%>

<jsp:forward page="forward2.jsp" />

<% } else { %>

<%@ include file="forward.html" %>

<% } %>