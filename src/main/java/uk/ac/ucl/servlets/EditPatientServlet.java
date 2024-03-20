package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/editPatient.html")
public class EditPatientServlet extends HttpServlet {
  private int patientIndex;
  String id;
  Model model;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if ("Update".equals(action)) {
      Map<String, String> newValues = new HashMap<>();
      Enumeration<String> parameterNames = request.getParameterNames();

      while (parameterNames.hasMoreElements()) {
        String paramName = parameterNames.nextElement();
        if (!"action".equals(paramName) && !"id".equals(paramName)) {
          String paramValue = request.getParameter(paramName);
          newValues.put(paramName, paramValue);
        }
      }
      model.updateRecord(patientIndex, newValues);
    } else if ("Delete".equals(action)) {
      model.deleteRecord(patientIndex);
      
    }
    model.updateCSV();
    response.sendRedirect("runsearch.html");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    model = ModelFactory.getModel();

    id = request.getParameter("id");
    // Use the id to retrieve the patient's details
    patientIndex = model.getPatientRecordIndex(id);
    List<String> patientDetails = model.getPatientRecord(patientIndex);
    request.setAttribute("patientDetails", patientDetails);

    // Retrieve the column names
    List<String> columnNames = model.getHeaderNames();
    request.setAttribute("columnNames", columnNames);

    // Forward the request to the JSP
    RequestDispatcher dispatcher = request.getRequestDispatcher("/editPatient.jsp");
    dispatcher.forward(request, response);
  }
}