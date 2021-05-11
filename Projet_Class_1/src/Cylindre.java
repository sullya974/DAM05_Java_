public class Cylindre {
    private double rayon;
    private double hauteur;
    private double volume;

    public Cylindre() {
    }

    public Cylindre(double rayon, double hauteur) {
        this.rayon = rayon;
        this.hauteur = hauteur;
    }

    public double getRayon() {
        return rayon;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getVolume(){
        return Math.PI * Math.pow(this.rayon, 2) * this.hauteur;
    }
}
