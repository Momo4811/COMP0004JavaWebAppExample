<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Patient Data App</title>
  <jsp:include page="/meta.jsp"/>

  <style>
    form {
      display: flex;
      justify-content: center;
      align-items: center;
      gap: 10px;
    }
    input[type="text"], select {
      margin-top: 30px;
      padding: 10px;
      width: 30%;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    select{
      width: 10%;
    }
    #SubmitSearch {
      margin-top: 30px;
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      background-color: #4CAF50;
      color: white;
      cursor: pointer;
    }
    #SubmitSearch:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <h1>Search</h1>
  <jsp:include page="navbar.jsp" />

  <form method="POST" action="/runsearch.html">
    <input type="text" name="searchString" placeholder="Enter search keyword here"/>
    <select name="columnSelection">
      <%
      List<String> headerNames = (List<String>) request.getAttribute("headerNames");
      for (String header : headerNames)
      {%>
      <option value="<%=header%>"><%=header%></option>
      <% } %>
    </select>
    <input id="SubmitSearch" type="submit" value="Search"/>
  </form>
</body>
</html>