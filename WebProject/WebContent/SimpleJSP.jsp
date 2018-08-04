<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple JSP</title>
</head>
<body>

<% 
String user = request.getParameter("userName");
if(user != null)
{
	session.setAttribute("sessionUserName", user);//to test nullify the request after setting
	//application scope can be used across multiple jsps
	application.setAttribute("applicationUserName", user);//to test open in another browser after setting
	pageContext.setAttribute("pageUserName", user);//this is for this page only
	//Also pageContext can be used to set/retrieve from any scope(page/request/session/application)
	//for eg to set in session scope usin pageContext
	pageContext.setAttribute("sessionUserName", user, PageContext.SESSION_SCOPE);
	
}
//to find attribute use following in order(page/request/session/application)
String attr = (String)pageContext.findAttribute("applicationUserName");
out.println("*****" + attr );
%>

<br>
User name in request is : <%=request.getParameter("userName") %>
<br>
User name in session is : <%=session.getAttribute("sessionUserName") %>
<br>
User name in application(servlet Context) is : <%=application.getAttribute("applicationUserName") %>
<br>
User name in page is : <%=pageContext.getAttribute("pageUserName") %>

</body>
</html>