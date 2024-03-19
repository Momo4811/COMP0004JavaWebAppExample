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
import java.util.LinkedHashMap;
import java.util.List;

// The servlet invoked to display a list of patients. Note that this data is just example data,
// you replace it with your data.
// The url http://localhost:8080/patientList.html is mapped to calling doGet on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet("/statistics.html")
public class ViewStatisticsServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    Model model = ModelFactory.getModel();
    String sortType = request.getParameter("sortType");
    if (sortType == null) {
      sortType = "CITY";
    }else if(sortType.equals("Sort by State")){
      sortType = "STATE";
    }
    else {
      sortType = "CITY";
    }
    LinkedHashMap<String, Integer> sortedPeoplePerPlace = model.getPeoplePerPlaceSorted(sortType);

    request.setAttribute("sortedPeoplePerPlace", sortedPeoplePerPlace);
    request.getRequestDispatcher("/statistics.jsp").forward(request, response);
  }
}