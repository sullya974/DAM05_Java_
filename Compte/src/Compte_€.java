public class Compte_€ extends Compte {
    private int taux;

    public Compte_€() {
    }

    public Compte_€(String nom, long montant, int taux) {
        super(nom, montant);
        this.taux = taux;
    }

    @Override
    public long getMontant() {
        return (long) (this.getMontant() * this.taux);
    }

    public void payer(){
        System.out.println("Je paie");
    }
}
