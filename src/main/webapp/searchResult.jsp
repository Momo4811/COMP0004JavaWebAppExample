<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data</title>
  <style>
    h2 {
      font-family: "Helvetica Neue", Arial, sans-serif;
      font-weight: 1;
      font-size: 30px;
      color: #333; /* Change the color to a dark grey */
    }
    input[type="submit"] {
      margin-left: 0px;
      border-radius: 4px;
      font-family: Arial, sans-serif;
      font-size: 16px;
      padding:  5px;
      background-color:#444;
      color: white;
      cursor: pointer;
    }
    
    input[type="submit"]:hover {
      background-color:#666;
    }
    table{
      width:1%;
      margin:0;
    }

  </style>
</head>
<body>
<div>
  <h1 >Patient Data</h1>
  <jsp:include page="navbar.jsp" />

  <div class="clearBoth"></div>
</div>

<div class="main">
  <h2>Select a patient to edit information</h2>

  <form action="runsearch.html" method="get">
    <input type="hidden" name="saveAsJson" value="true">
    <input type="submit" value="Save as JSON">
  </form>
  
  <%
  List<List<String>> patients = (List<List<String>>) request.getAttribute("result");
  List<String> columnNames = (List<String>) request.getAttribute("columnNames");

  if (patients.size() != 0) {
%>
    <table>
      <% for(String columnName : columnNames) { %>
        <th><%= columnName %></th>
      <% } %>
      <% for(List<String> patientRows : patients) { %>
        <tr onclick="window.location='editPatient.html?id=<%=patientRows.get(0)%>'">
          <% for (String patient : patientRows) { %>
            <td><%=patient%></td>
          <% } %>
        </tr>
      <% } %>
    </table>
<% } else { %>
    <p>Nothing found</p>
<% } %>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>