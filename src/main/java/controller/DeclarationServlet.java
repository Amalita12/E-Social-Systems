package controller;

import dao.DeclarationDAO;
import dao.EmployeurDAO;
import model.Declaration;
import model.Employeur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/declaration")
public class DeclarationServlet extends HttpServlet {

    private DeclarationDAO declarationDAO;
    private EmployeurDAO employeurDAO;

    @Override
    public void init() {
        declarationDAO = new DeclarationDAO();
        employeurDAO = new EmployeurDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.setAttribute("listeEmployeurs", employeurDAO.consulterListeDesEmployeurs());
        request.getRequestDispatcher("/formDeclaration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idEmployeur = Integer.parseInt(request.getParameter("idEmployeur"));
        int mois = Integer.parseInt(request.getParameter("mois"));
        int annee = Integer.parseInt(request.getParameter("annee"));

        boolean estUnique = declarationDAO.verifierUniciteDeDeclaration(idEmployeur, mois, annee);

        if (estUnique) {
            Employeur emp = employeurDAO.consulterEmployeur(idEmployeur);
            Declaration dec = new Declaration();
            dec.setMois(mois);
            dec.setAnnee(annee);
            dec.setDateDeclaration(LocalDate.now()); // Date du jour
            dec.setEmployeur(emp);

            declarationDAO.creerDeclaration(dec);


            declarationDAO.ajouterSalaires(dec);

            request.setAttribute("message", "Déclaration effectuée avec succès pour " + emp.getRaisonSociale());
            request.getRequestDispatcher("/succes.jsp").forward(request, response);

        } else {
            request.setAttribute("erreur", "Erreur : Une déclaration existe déjà pour cette période !");
            request.setAttribute("listeEmployeurs", employeurDAO.consulterListeDesEmployeurs());
            request.getRequestDispatcher("/formDeclaration.jsp").forward(request, response);
        }
    }
}
