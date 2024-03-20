<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Statistics</title>
    <style>
      h1{
        font-family: 'Arial', sans-serif;
        color: black;
        text-align: center;
        font-size: 50px;
        margin-bottom: 20px;
        font-weight: 0;
        letter-spacing: 1px; 
      }
      body {
          font-family: Arial, sans-serif; 
      }
      table {
          width: 50%;
          margin: auto; 
          border-collapse: collapse;
      }
      th, td {
          padding: 10px;
          text-align: center; 
          border: 1px solid #ddd;
      }
      th {
          background-color: #f0f0f0; 
      }
      form {
        text-align: center;
    }

    .sort {
        background-color: #333;
        color: #fff; 
        padding: 10px 20px;
        border: none; 
        cursor: pointer;
        text-decoration: none;
        transition: 0.3s;
        font-size: 1.1em; 
        margin-bottom: 10px;

    }

    .sort:hover {
        background-color: #444; 
    }
  </style>
</head>
</head>
<body>
<h1>People Per Place</h1>
<jsp:include page="navbar.jsp" />
<form method="POST" action="/locationStatistics.html">
  <input class = "sort" type="submit" name="sortType" value="Sort by State"/>
  <input class = "sort" type="submit" name="sortType" value="Sort by City"/>
</form>

<table>
  <tr>
    <th>Place</th>
    <th>Number of People</th>
  </tr>
  <%
  Map<String, Integer> sortedPeoplePerPlace = (Map<String, Integer>) request.getAttribute("sortedPeoplePerPlace");
  for (Map.Entry<String, Integer> entry : sortedPeoplePerPlace.entrySet()) {
  %>
  <tr>
    <td><%= entry.getKey() %></td>
    <td><%= entry.getValue() %></td>
  </tr>
  <% } %>
</table>
</body>
</html>