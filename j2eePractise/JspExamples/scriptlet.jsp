<html>
  <head>
    <title>Scriptlet test page</title>
  </head>
  <body>
    <h1>Scriptlet test page</h1>

    <%
      for(int i=0;i< 10;i++) {
        out.println("<b>Hello World. This is a scriptlet test " + i +
                    "</b><br>");
        System.out.println("This goes to the System.out stream " + i);
      }
    %>

  </body>
</html>