<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login 7</title>
</head>
<body>

<s:form action="example7/login">
	<s:textfield label="Login ID 7" key="userId" />
	<s:password label="Password 7" key="password" />
	<s:submit/>
</s:form>
</body>
</html>