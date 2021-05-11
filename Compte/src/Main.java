import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList; // Ou java.util.*


public class Main {
    public static void main(String[] args) {
        // OOP - Modèle Compte, Compte_€, Compte_$
        Compte compte = new Compte();
        compte.setNom("CCP");
        compte.setMontant(12345);
        compte.getStatement();

        Compte compte_€ = new Compte_€("Compte €", 12345456, 12);
        Compte compte_$ = new Compte_$("Compte $", 12345456, 8);
        Compte compte_$$ = new Compte_€("Compte $", 12345456, 8);
        ((Compte_€)compte_$$).payer();

//        System.out.println(Compte.count);
//
//        LinkedList<Compte> comptes = new LinkedList<Compte>();
//        //comptes.add(compte_$);
//        //comptes.add(compte_€);
//        comptes.addAll(new ArrayList<Compte>(Arrays.asList(compte_$, compte_€)));
//        comptes.forEach((c) -> System.out.println(c.getNom()));
//
//        compte_€€ = compte_€;
//        compte_€€.setNom("Compto");
//        System.out.println(compte_€.getNom());
//        //Compte deleteCompte = comptes.removeFirst();
//        //System.out.println(deleteCompte);
//        //System.out.println(comptes);
//
//        //System.out.println("Deleted: " + deleteCompte.getNom());
    }
}
