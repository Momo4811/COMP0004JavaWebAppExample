package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;

@WebServlet("/locationStatistics.html")
public class ViewLocationStatisticsServlet extends HttpServlet {
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
    request.getRequestDispatcher("/locationStatistics.jsp").forward(request, response);
  }
}