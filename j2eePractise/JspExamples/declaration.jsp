<%!
  int numTimes = 3;

  public String sayHello(String name) {
    return "Hello, " + name + "!";
  }
%>

<html>
  <head>
    <title>Declaration test page</title>
  </head>
  <body>
    <h1>Declaration test page</h1>

    <p>The value of numTimes is <%= numTimes %>.</p>
    <p>Saying hello to reader: "<%= sayHello("reader") %>".</p>
  </body>
</html>