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
import java.util.List;
@WebServlet("/editPatient.html")
public class EditPatientServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Model model = ModelFactory.getModel();

    
    String id = request.getParameter("id");
    
    // Use the id to retrieve the patient's details
    List<String> patientDetails = model.getPatientDetailsById(id);
    request.setAttribute("patientDetails", patientDetails);

    // Retrieve the column names
    List<String> columnNames = model.getHeaderNames(); 
    request.setAttribute("columnNames", columnNames);

    // Forward the request to the JSP
    RequestDispatcher dispatcher = request.getRequestDispatcher("/editPatient.jsp");
    dispatcher.forward(request, response);
  }
}