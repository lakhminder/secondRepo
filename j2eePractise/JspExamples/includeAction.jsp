<html>
  <head>
    <title>Include Action test page</title>
  </head>
  <body>
    <h1>Include Action test page</h1>

      <h2>Using the include directive</h2>

      <%@ include file="included2.html" %>
      <%@ include file="included2.jsp" %>

      <h2>Using the include action</h2>

      <jsp:include page="included2.html"/>
      <jsp:include page="included2.jsp"/>

  </body>
</html>