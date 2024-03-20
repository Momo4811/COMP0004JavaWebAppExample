package uk.ac.ucl.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Model;

import java.util.Map;

@WebServlet("/commonLetterStatistics.html")
public class ViewCommonLetterStatisticsServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    Model model = ModelFactory.getModel();
    String columnType = request.getParameter("columnType");
    
    if (columnType == null) {
      columnType = "FIRST";
    }
    Map<Character, Integer> letterOccurrences = model.getLetterOccurrencesSorted(columnType);

    request.setAttribute("letterOccurrences", letterOccurrences);
    request.getRequestDispatcher("/commonLetterStatistics.jsp").forward(request, response);
  }
}