package model;

import java.util.ArrayList;
import java.util.List;

public class Employeur {
    private int id;
    private String raisonSociale;
    private String secteurActivite;
    private List<Employe> employes;

    public Employeur() {
        this.employes = new ArrayList<>();
    }

    public Employeur(int id, String raisonSociale, String secteurActivite) {
        this.id = id;
        this.raisonSociale = raisonSociale;
        this.secteurActivite = secteurActivite;
        this.employes = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public void setSecteurActivite(String secteurActivite) { this.secteurActivite = secteurActivite; }
}