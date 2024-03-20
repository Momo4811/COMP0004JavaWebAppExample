<%@ page import="java.util.List" %>
<head>
  <include file="/meta.jsp"/>
  <title>Edit Patient Data</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }
    
    h1{
      font-family: 'Arial', sans-serif;
      color: black;
      text-align: center;
      font-size: 50px;
      font-weight: 0;
      margin-bottom: 20px;
      letter-spacing: 1px; /* Increase the spacing between letters */
    }

    .patientForm {
      width: 50%;
      margin: 0 auto;
    }

    table {
      width: 100%;
      margin-bottom: 20px;
    }

    input[type="text"] {
      width: 100%;
      padding: 10px;
    }

    .patientButton {
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      border: none;
      cursor: pointer;
      text-align: center;
      text-align: center;
      text-align: center;
    }

    .buttonContainer {
      margin-left: 50%;
    }
    .patientButton:hover {
      background-color: #45a049;
    }

    label {
      font-weight: bold;
    }

  </style>
  </style>
</head>
<body>
    <h1>Edit Patient</h1>
    <jsp:include page="/navbar.jsp"/>
    <%
      List<String> patientDetails = (List<String>) request.getAttribute("patientDetails"); 
      List<String> columnNames = (List<String>) request.getAttribute("columnNames");
      String id = (String) request.getAttribute("id");
    %>
    <form class="patientForm" (action="editPatient.html?id="+id) method="post">
      <input type="hidden" name="id" value="<%=id%>">
      <table>
      <% 
      for (int i = 0; i < columnNames.size(); i++) {
      %>
        <tr>
          <td><label for="<%=columnNames.get(i)%>"><%=columnNames.get(i)%>:</label></td>
          <td><input type="text" id="<%=columnNames.get(i)%>" name="<%=columnNames.get(i)%>" value="<%=patientDetails.get(i)%>"></td>
        </tr>
      <% 
      }
      %>
      </table>
      <div class="buttonContainer">
        <input class="patientButton" type="submit" name="action" value="Update">
        <input class="patientButton" type="submit" name="action" value="Delete">
      </div>
    </form>
  </body>
  </html>