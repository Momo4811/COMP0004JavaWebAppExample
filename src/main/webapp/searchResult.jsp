<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>Patient Data App</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h1 id="mainstuff">Search Result</h1>
  <%
    List<List<String>> patients = (List<List<String>>) request.getAttribute("result");
    if (patients.size() !=0)
    {
  %>
    <table>
      <%
      for(List<String> patientRows : patients){
      %>
      <tr onclick="window.location='editPatient.html?id=<%=patientRows.get(0)%>'">
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