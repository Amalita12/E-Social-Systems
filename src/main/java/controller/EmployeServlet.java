package controller;

import dao.EmployeDAO;
import dao.EmployeurDAO;
import model.Employe;
import model.Employeur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employe") // C'est l'URL pour accéder à cette servlet
public class EmployeServlet extends HttpServlet {

    private EmployeDAO employeDAO;
    private EmployeurDAO employeurDAO;

    @Override
    public void init() {
        employeDAO = new EmployeDAO();
        employeurDAO = new EmployeurDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("nouveau".equals(action)) {
            request.setAttribute("listeEmployeurs", employeurDAO.consulterListeDesEmployeurs());
            request.getRequestDispatcher("/formEmploye.jsp").forward(request, response);

        } else if ("droits".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Employe e = employeDAO.consulterDroit(id);

            request.setAttribute("assure", e);
            request.getRequestDispatcher("/consulterDroits.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("ajouter".equals(action)) {
            String nom = request.getParameter("nom");
            double salaire = Double.parseDouble(request.getParameter("salaire"));
            int idEmployeur = Integer.parseInt(request.getParameter("idEmployeur"));

            Employe emp = new Employe();
            emp.setNom(nom);
            emp.setSalaireMensuel(salaire);

            Employeur boss = new Employeur();
            boss.setId(idEmployeur);
            emp.setEmployeur(boss);

            employeDAO.ajouterEmploye(emp);

            response.sendRedirect("employeur?action=details&id=" + idEmployeur);
        }
    }
}