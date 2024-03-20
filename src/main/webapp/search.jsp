<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Patient Data App</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }
    .main {
      width: 80%;
      margin: 0 auto;
      padding: 20px;
      box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
    }
    h1 {
      text-align: center;
      color: #333;
    }
    form {
      display: flex;
      justify-content: center;
      align-items: center;
      gap: 10px;
    }
    input[type="text"], select {
      padding: 10px;
      width: 200px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    input[type="submit"] {
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      background-color: #4CAF50;
      color: white;
      cursor: pointer;
    }
    input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
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