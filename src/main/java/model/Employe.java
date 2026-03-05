package model;


public class Employe {
    private int id;
    private String nom;
    private double salaireMensuel;
    private Employeur employeur;
    private int nbMoisDeclares;
    private double totalCotisations;

    public Employe() {
        this.employeur = new Employeur();
    }

    public Employe(int id, String nom, double salaireMensuel, Employeur employeur) {
        this.id = id;
        this.nom = nom;
        this.salaireMensuel = salaireMensuel;
        this.employeur = employeur;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public double getSalaireMensuel() { return salaireMensuel; }
    public void setSalaireMensuel(double salaireMensuel) { this.salaireMensuel = salaireMensuel; }
    public Employeur getEmployeur() { return employeur; }
    public void setEmployeur(Employeur employeur) { this.employeur = employeur; }
    public int getNbMoisDeclares() { return nbMoisDeclares; }
    public void setNbMoisDeclares(int n) { this.nbMoisDeclares = n; }
    public double getTotalCotisations() { return totalCotisations; }
    public void setTotalCotisations(double t) { this.totalCotisations = t; }
}