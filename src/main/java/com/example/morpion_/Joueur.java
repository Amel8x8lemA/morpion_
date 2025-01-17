package com.example.morpion_;

public class Joueur {

    String nom;
    int nbVictoire;
    Boolean tour;

    public Joueur() {
        this.nbVictoire = 0;
        this.tour = true;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbVictoire() {
        return nbVictoire;
    }

    public void addVictoire() {
        this.nbVictoire++;
    }

    public Boolean getTour() {
        return tour;
    }

    public void setTour(Boolean tour) {
        this.tour = tour;
    }

    public void changeTour() {
        tour = !tour;
    }
}
