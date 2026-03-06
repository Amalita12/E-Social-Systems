package controller;

import dao.EmployeurDAO;
import model.Employeur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employeur")
public class EmployeurServlet extends HttpServlet {
    private EmployeurDAO employeurDAO;

    @Override
    public void init() {
        employeurDAO = new EmployeurDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("list".equals(action) || action == null) {

            List<Employeur> liste = employeurDAO.consulterListeDesEmployeurs();
            request.setAttribute("listeEmployeurs", liste);
            request.getRequestDispatcher("/listeEmployeurs.jsp").forward(request, response);

        } else if ("details".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Employeur e = employeurDAO.consulterEmployeur(id);

            employeurDAO.associerEmployes(e);

            request.setAttribute("employeur", e);
            request.getRequestDispatcher("/detailsEmployeur.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String raisonSociale = request.getParameter("raisonSociale");
        String secteur = request.getParameter("secteurActivite");

        if (raisonSociale != null && secteur != null) {
            Employeur newEmp = new Employeur();
            newEmp.setRaisonSociale(raisonSociale);
            newEmp.setSecteurActivite(secteur);

            employeurDAO.ajouterEmployeur(newEmp);
        }

        response.sendRedirect("employeur?action=list");
    }
}