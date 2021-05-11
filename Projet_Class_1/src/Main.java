import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point leSommetDeLaTourEffeil = new Point(12, 4, 16);
        Point leSommetDeLaTourMontparnasse = new Point(12, 23, 78);
        leSommetDeLaTourEffeil.deplace(leSommetDeLaTourEffeil.getX() + 2, leSommetDeLaTourEffeil.getY() - 8, leSommetDeLaTourEffeil.getZ() - 9);


        // ArrayList
        /*
        List<Point> points = new ArrayList<>();
        points.add(leSommetDeLaTourEffeil);
        points.add(leSommetDeLaTourMontparnasse);
        points.add(new Point(12, 23, 78));
        points.forEach((p) -> System.out.println(p.toString()));

        for(Point point: points){
            System.out.println(point.toString());
        }

        DecimalFormat df = new DecimalFormat("###.####");
        System.out.println("Distance Tour Effeil / Tour Montparnasse: " + df.format(leSommetDeLaTourEffeil.distantDe(leSommetDeLaTourMontparnasse)));
         */



        // Héritage =========================================
        Cylindre cylindre = new Cylindre(3, 6);
        System.out.println(String.format("Volume du cylindre: %s", cylindre.getVolume()));

        Rondelle rondelle = new Rondelle(cylindre. getRayon(), cylindre.getHauteur(), 3);
        System.out.println(String.format("Volume du rondelle: %s", rondelle.getVolume()));

        // OOP - Modèle Compte, Compte_€, Compte_$

        Compte compte = new Compte();
        compte.Nom = "CCP",
        compte.Montant = 12345,
        compte.getStatement();
    }
}