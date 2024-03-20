<%@ page import="java.util.List" %>
<html>
  <head>
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
        letter-spacing: 1px;
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

      #AddPatientButton {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        cursor: pointer;
        text-align: center;
        text-align: center;
        text-align: center;
        margin-left: 50%;
      }

      #AddPatientButton:hover {
        background-color: #45a049;
      }

      label {
        font-weight: bold;
      }

    </style>

  </head>

  <body>
    <h1>Add Patient</h1>
    <jsp:include page="navbar.jsp" />

    <% List<String> columnNames = (List<String>) request.getAttribute("columnNames");
        String id = (String) request.getAttribute("id");
        %>
        <div class="patientForm">
        <form (action="editPatient.html?id=" +id) method="post">
          <input type="hidden" name="id" value="<%=id%>">
          <table>
            <% for (int i=0; i < columnNames.size(); i++) { %>
              <tr>
                <td><label for="<%=columnNames.get(i)%>">
                    <%=columnNames.get(i)%>:
                  </label></td>
                <td><input type="text" id="<%=columnNames.get(i)%>" name="<%=columnNames.get(i)%>"></td>
              </tr>
              <% } %>
          </table>
          <input id="AddPatientButton"type="submit" name="action" value="Add Patient">
        </form>
      </div>
  </body>
</html>