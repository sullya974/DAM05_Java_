public class Compte {
    private String nom;
    private long montant;
    protected static int count;

    public Compte() {
    }

    public Compte(String nom, long montant) {
        this.nom = nom;
        this.montant = montant;
    }

    public long getMontant() {
        return montant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMontant(long montant) {
        this.montant = montant;
    }

    public long getStatement() {
        return this.montant;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
