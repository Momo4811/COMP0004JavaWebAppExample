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

// The servlet invoked to perform a search.
// The url http://localhost:8080/runsearch.html is mapped to calling doPost on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet("/runsearch.html")
public class SearchResultsServlet extends HttpServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  { 
    // Searches for every patient
    Model model = ModelFactory.getModel();

    if (request.getParameter("saveAsJson") != null) {
      model.saveDataAsJson("data/patients100.json");
    }

        
    List<String> columnNames = model.getHeaderNames();
    request.setAttribute("columnNames", columnNames);
    
    List<List<String>> searchResult = model.searchFor("ID", "");
    request.setAttribute("result", searchResult);

    // Sends results to webpage
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/searchResult.jsp");
    dispatch.forward(request, response);
  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    // Searches for a specific patient
    Model model = ModelFactory.getModel();

    String headerName = request.getParameter("columnSelection");
    String searchString = request.getParameter("searchString");

    List<String> columnNames = model.getHeaderNames();
    request.setAttribute("columnNames", columnNames);

    List<List<String>> searchResult = model.searchFor(headerName, searchString);
    request.setAttribute("result", searchResult);

    // Invoke the JSP page.
    RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/searchResult.jsp");
    dispatch.forward(request, response);
  }
}
