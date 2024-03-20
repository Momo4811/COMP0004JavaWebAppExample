<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Common Letter Statistics</title>
  <jsp:include page="/meta.jsp"/>
  <style>
    table{
      width: 30%;
      margin: auto;
    }
    table td {
      text-align: center;
      font-size: 1.2em;
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
<body>
<h1>Common Letter Statistics</h1>
<jsp:include page="navbar.jsp" />
<form method="POST" action="/commonLetterStatistics.html">
  <input class="sort" type="submit" name="columnType" value="FIRST" title="First Name"/>
  <input class="sort" type="submit" name="columnType" value="LAST" title="Last Name"/>
  <input class="sort" type="submit" name="columnType" value="MAIDEN" title="Maiden Name"/>
</form>
<table>
  <tr>
    <th>Letter</th>
    <th>Occurrences</th>
  </tr>
  <%
  Map<Character, Integer> letterOccurrences = (Map<Character, Integer>) request.getAttribute("letterOccurrences");
  for (Map.Entry<Character, Integer> entry : letterOccurrences.entrySet()) {
  %>
  <tr>
    <td><%= entry.getKey() %></td>
    <td><%= entry.getValue() %></td>
  </tr>
  <% } %>
</table>
</body>
</html>