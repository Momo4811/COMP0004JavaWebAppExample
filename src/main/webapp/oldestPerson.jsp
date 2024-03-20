<%@ page import="java.util.LinkedHashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Oldest Person</title>
        <jsp:include page="/meta.jsp" />
    </head>

    <body>
        <h1>Oldest Person</h1>
        <jsp:include page="navbar.jsp" />
        <%
          LinkedHashMap<String, String> oldestPerson = (LinkedHashMap<String, String>) request.getAttribute("oldestPerson");
        %>
        <table>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Birthdate</th>
            <% if (oldestPerson.containsKey("DEATHDATE")) { %>
              <th>Deathdate</th>
            <% } %>
          </tr>
          <tr>
              <td><%= oldestPerson.get("FIRST") %></td>
              <td><%= oldestPerson.get("LAST") %></td>
              <td><%= oldestPerson.get("BIRTHDATE") %></td>
              <% if (oldestPerson.containsKey("DEATHDATE")) { %>
                <td><%= oldestPerson.get("DEATHDATE") %></td>
              <% } %>
          </tr>
      </table>
    </body>
</html>