package uk.ac.ucl.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import uk.ac.ucl.model.Model;

@WebServlet("/saveJSON")
public class SaveAsJSONServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        Model model = (Model) request.getSession().getAttribute("model");
        model.saveDataAsJson("data/patients100.json");

        request.getRequestDispatcher("/runsearch.html").forward(request, response);
        

    }
}