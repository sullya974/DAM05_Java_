public class Rondelle extends Cylindre {
    public Rondelle(double rayon, double hauteur, int rayon_perce) {
        super(rayon, hauteur);
        this.rayon_perce = rayon_perce;
    }

    private int rayon_perce;

    @Override
    public double getVolume() {
        return super.getVolume() - (Math.PI * Math.pow(this.rayon_perce, 2) * this.getHauteur());
    }
}
