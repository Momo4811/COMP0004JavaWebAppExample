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
@WebServlet("/addPatient.html")
public class AddPatientServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // For adding a new patient record
    
    Model model = ModelFactory.getModel();
    Map<String, String> newPatientDetails = new HashMap<>();
    Enumeration<String> parameterNames = request.getParameterNames();

    while (parameterNames.hasMoreElements()) {
      String paramName = parameterNames.nextElement();
      if (!"action".equals(paramName)) {
        String paramValue = request.getParameter(paramName);
        newPatientDetails.put(paramName, paramValue);
      }
    }
    model.addRecord(newPatientDetails);
    model.updateCSV();
    response.sendRedirect("runsearch.html");
  }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // For displaying the form to add a new patient record

    Model model = ModelFactory.getModel();
    List<String> columnNames = model.getHeaderNames(); 
    request.setAttribute("columnNames", columnNames);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/addPatient.jsp");
    dispatcher.forward(request, response);
  }
}