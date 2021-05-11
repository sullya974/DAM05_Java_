package sample;

public class Boisson {
    public double prix;
    public String nom;

    public Boisson() {
    }

    public Boisson(double prix, String nom) {
        this.prix = prix;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom + " - " + this.prix;
    }
}
