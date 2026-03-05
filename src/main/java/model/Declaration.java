package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Declaration {
    private int id;
    private int mois;
    private int annee;
    private LocalDate dateDeclaration;
    private double montantTotal;
    private Employeur employeur;
    private List<Cotisation> listeCotisations;

    public Declaration() {
        this.employeur = new Employeur();
        this.listeCotisations = new ArrayList<>();
    }

    public Declaration(int id, int mois,LocalDate dateDeclaration, int annee, Employeur employeur) {
        this.id = id;
        this.mois = mois;
        this.annee = annee;
        this.dateDeclaration= dateDeclaration;
        this.employeur = employeur;
        this.listeCotisations = new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMois() { return mois; }
    public void setMois(int mois) { this.mois = mois; }

    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }

    public LocalDate getDateDeclaration() { return dateDeclaration; }

    public void setDateDeclaration(LocalDate dateDeclaration) { this.dateDeclaration = dateDeclaration;}

    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }

    public Employeur getEmployeur() { return employeur; }
    public void setEmployeur(Employeur employeur) { this.employeur = employeur; }

    public List<Cotisation> getListeCotisations() { return listeCotisations; }
    public void setListeCotisations(List<Cotisation> listeCotisations) { this.listeCotisations = listeCotisations; }
}