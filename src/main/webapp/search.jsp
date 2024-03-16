<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
  <title>Patient D11ata App</title>
</head>
<body>
<div class="main">
  <h1>Search</h1>
  <form method="POST" action="/runsearch.html">
    <input type="text" name="searchString" placeholder="Enter search keyword here"/>
    <input type="submit" value="Search"/>
    <select name="columnSelection">
      <%
      List<String> headerNames = (List<String>) request.getAttribute("headerNames");
      for (String header : headerNames)
      {%>
      <option value="<%=header%>"><%=header%></option>
      <% } %>
    </select>
  </form>
</div>
</body>
</html>