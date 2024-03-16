<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
  <link rel="stylesheet" type="text/css" href = "styles.css">
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h1>Search Result</h1>
  <%
    List<List<String>> patients = (List<List<String>>) request.getAttribute("result");
    if (patients.size() !=0)
    {
  %>
    <table name = "results">
      <%
      for(List<String> patientRows : patients){
      %>
      <tr>
        <%
        for (String patient : patientRows) {
        %>
        <td><%=patient%></td>
        <% }
        %>
      </tr>
      <% }
    } else
    {%>
      <p>Nothing found</p>
  <%}%>
  </table>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>