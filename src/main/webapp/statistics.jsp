<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Statistics</title>
    <style>
      body {
          font-family: Arial, sans-serif; /* Set the font for the entire page */
          margin: 0; /* Remove the default margin */
          padding: 0; /* Remove the default padding */
          background-color: #f5f5f5; /* Set a background color for the entire page */
      }
      h1 {
          text-align: center;
          color: #333; /* Set the color of the h1 tag */
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
    input[type="submit"] {
        background-color: #333; /* Adjust to a darker color for contrast */
        color: #fff; /* Adjust to white for contrast */
        padding: 10px 20px; /* Adjust padding */
        border: none; /* Remove the border */
        cursor: pointer; /* Change the cursor when hovering over the button */
        text-decoration: none; /* Remove the underline */
        margin: 10px 2px; /* Adjust margin */
        transition: 0.3s; /* Add a transition effect */
    }

    /* Change the background color when hovering over the button */
    input[type="submit"]:hover {
        background-color: #555; /* Adjust to a slightly lighter color when hovering */
    }
  </style>
</head>
</head>
<body>
<h1>People Per Place</h1>
<form method="POST" action="/statistics.html">
  <input type="submit" name="sortType" value="Sort by State"/>
  <input type="submit" name="sortType" value="Sort by City"/>
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