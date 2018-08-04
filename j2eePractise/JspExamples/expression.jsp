<html>
  <head>
    <title>Expression test page</title>
  </head>
  <body>
    <h1>Expression test page</h1>

    <%! int i=0 ; %>

    <%
      i++;
    %>

    Hello World!
    <%= "This JSP has been accessed " + i + " times" %>

  </body>
</html>