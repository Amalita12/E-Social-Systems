package controller;

import dao.CotisationDAO;
import dao.DeclarationDAO;
import model.Cotisation;
import model.Declaration;
import model.Employe;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cotisation")
public class CotisationServlet extends HttpServlet {

    private CotisationDAO cotisationDAO;
    private DeclarationDAO declarationDAO;

    @Override
    public void init() {
        cotisationDAO = new CotisationDAO();
        declarationDAO = new DeclarationDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("calculer".equals(action)) {

            double salaire = Double.parseDouble(request.getParameter("salaire"));

            Employe tempEmp = new Employe();
            tempEmp.setSalaireMensuel(salaire);

            Cotisation resultat = cotisationDAO.calculCotisation(tempEmp);

            request.setAttribute("cotis", resultat);
            request.getRequestDispatcher("/resultatCalcul.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("enregistrerMassif".equals(action)) {
            int idDeclaration = Integer.parseInt(request.getParameter("idDeclaration"));

            Declaration dec = declarationDAO.consulterDeclaration(idDeclaration);


            declarationDAO.ajouterSalaires(dec);

            double totalGen = cotisationDAO.calculTotalParEmployeur(
                    dec.getEmployeur().getId(),
                    dec.getId()
            );

            request.setAttribute("totalGlobal", totalGen);
            request.getRequestDispatcher("/confirmationDeclaration.jsp").forward(request, response);
        }
    }
}