package uk.ac.ucl.servlets;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

@WebServlet("/oldestPerson.html")
public class ViewOldestPersonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Model model = ModelFactory.getModel();
    LinkedHashMap<String, String> oldestPerson = model.getOldestPerson();

    request.setAttribute("oldestPerson", oldestPerson);
    request.getRequestDispatcher("/oldestPerson.jsp").forward(request, response);
}
}