public class Compte_$ extends Compte {
    private int taux;

    public Compte_$() {
    }

    public Compte_$(String nom, long montant, int tauxConversion) {
        super(nom, montant);
        this.taux = tauxConversion;
    }

    @Override
    public long getMontant() {
        return (long) (this.getMontant() * this.taux);
    }
}
