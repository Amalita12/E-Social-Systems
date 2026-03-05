package model;

public class Cotisation {
    private int id;
    private double montantSalarial;
    private double montantPatronal;
    private Employe employe;
    private Declaration declaration;

    public Cotisation() {
        this.employe = new Employe();
        this.declaration = new Declaration();
    }

    public Cotisation(double montantSalarial, double montantPatronal, Employe employe, Declaration declaration) {
        this.montantSalarial = montantSalarial;
        this.montantPatronal = montantPatronal;
        this.employe = employe;
        this.declaration = declaration;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getMontantSalarial() { return montantSalarial; }
    public void setMontantSalarial(double montantSalarial) { this.montantSalarial = montantSalarial; }

    public double getMontantPatronal() { return montantPatronal; }
    public void setMontantPatronal(double montantPatronal) { this.montantPatronal = montantPatronal; }

    public Employe getEmploye() { return employe; }
    public void setEmploye(Employe employe) { this.employe = employe; }

    public Declaration getDeclaration() { return declaration; }
    public void setDeclaration(Declaration declaration) { this.declaration = declaration; }

    public double getMontantTotalLigne() {
        return this.montantSalarial + this.montantPatronal;
    }
}