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
        letter-spacing: 1px; /* Increase the spacing between letters */
      }
      body {
          font-family: Arial, sans-serif; /* Set the font for the entire page */
      }
      table {
          width: 50%; /* Limit the width of the table */
          margin: auto; /* Center the table */
          border-collapse: collapse; /* Remove the space between the borders of adjacent cells */
      }
      th, td {
          padding: 10px; /* Add some padding to cells */
          text-align: center; /* Center the text */
          border: 1px solid #ddd; /* Add a border to the cells */
      }
      th {
          background-color: #f0f0f0; /* Add a background color to headers */
      }
      form {
        text-align: center; /* Center the buttons */
    }

    /* Style the buttons */
    .sort {
        background-color: #333; /* Adjust to a darker color for contrast */
        color: #fff; /* Adjust to white for contrast */
        padding: 10px 20px; /* Adjust padding */
        border: none; /* Remove the border */
        cursor: pointer; /* Change the cursor when hovering over the button */
        text-decoration: none; /* Remove the underline */
        transition: 0.3s; /* Add a transition effect */
        font-size: 1.1em; /* Increase font size */
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