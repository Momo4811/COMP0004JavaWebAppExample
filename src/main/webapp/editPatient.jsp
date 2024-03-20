<%@ page import="java.util.List" %>
<head>
  <style>
    body {
      font-family: Arial, sans-serif;
    }
    h1 {
      color: #333;
    }
    form {
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
    input[type="submit"] {
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      border: none;
      cursor: pointer;
      text-align: center;
    }
    input[type="submit"]:hover {
      background-color: #45a049;
    }
    
    label {
      font-weight: bold;
    }
    .button-container {
      text-align: center;
      text-align: center;
      margin-left: 30%; /* adjust this value as needed */
    }
  </style>
</head>
<body>
    <h1>Edit Patient</h1>
    <%
      List<String> patientDetails = (List<String>) request.getAttribute("patientDetails"); 
      List<String> columnNames = (List<String>) request.getAttribute("columnNames");
      String id = (String) request.getAttribute("id");
    %>
    <form action="UpdatePatientServlet" method="post">
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
      <div class="button-container">
        <input type="submit" name="action" value="Update">
        <input type="submit" name="action" value="Delete">
        <input type="submit" name="action" value="Add">
      </div>
    </form>
  </body>
  </html>