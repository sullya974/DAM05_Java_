package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.*;

public class Controller {
    @FXML
    ComboBox comboBox;
    @FXML
    Button btnSelect;
    @FXML
    ListView<Boisson> lstBoisson;
    @FXML
    Label lblSelection;
    @FXML
    Button btnPayer;
    @FXML
    TextField txtPaiement;
    @FXML
    TextArea txtMessagePaiement;
    @FXML
    VBox vBox;

    public void initialize() throws IOException, ParseException {

        // Charge la liste des boissons
        /*ArrayList<Boisson> arrBoissons = Model.loadBoissons();
        lstBoisson.getItems().addAll(arrBoissons);*/

        ArrayList<Boisson> arrBoissonsFromJson = Model.loadBoissonsFromJson();
        lstBoisson.getItems().addAll(arrBoissonsFromJson);

//        for(Boisson boisson: arrBoissons){
//            vBox.getChildren().add(new Button(boisson.nom));
//        }

        // Gestion de la sélection d'une boison
        /*btnSelect.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Boisson selectedBoisson = lstBoisson.getSelectionModel().getSelectedItem();
                lblSelection.setText(selectedBoisson.nom + " - " + selectedBoisson.prix + " €");
            }
        });*/

        // Gère l'action de sélection - Lambda Version
        btnSelect.setOnAction((event) -> {
            System.out.println(event.toString());
            Boisson selectedBoisson = lstBoisson.getSelectionModel().getSelectedItem();
            lblSelection.setText(selectedBoisson.nom + " - " + selectedBoisson.prix + " €");
        });

        // Double click
        lstBoisson.setOnMouseClicked(mouseClick -> {
            if(mouseClick.getClickCount() == 2){
                Boisson selectedBoisson = lstBoisson.getSelectionModel().getSelectedItem();
                System.out.println("Selected : " + selectedBoisson.nom);
                lblSelection.setText(selectedBoisson.nom + " - " + selectedBoisson.prix + " €\n");
            }
        });

        // Gestion du paiement
        btnPayer.setOnAction((event) -> {
            handlePayer();
        });
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        event.consume();
        Boisson selectedBoisson = lstBoisson.getSelectionModel().getSelectedItem();
        lblSelection.setText(selectedBoisson.nom + " - " + selectedBoisson.prix + " €");
    }

    @FXML
    //private void handlePayer(ActionEvent event){
    private void handlePayer(){
        Boisson selectedBoisson = lstBoisson.getSelectionModel().getSelectedItem();
        int selectedIndex = lstBoisson.getSelectionModel().getSelectedIndex();

        int montantPaiement = (txtPaiement.getText() != "") ? Integer.parseInt(txtPaiement.getText())*100 : 0;
        int montantAPayer = (int) (selectedBoisson.prix*100);

        double montantARendre = montantPaiement - selectedBoisson.prix;

        List<Integer> lstMonnaieRendue = ManageMonaieARendre(montantPaiement, montantAPayer);
        System.out.println("============================");
        for(int i : lstMonnaieRendue){
            System.out.println(i);
        }

//        // Cas : Montant payer inférieur au prix - Message : Reste à payer : XXX
//        if(montantPaiement == 0){
//            txtMessagePaiement.setText("Veuillez payer: " + selectedBoisson.prix + " €");
//        }else if(selectedBoisson.prix > montantPaiement){
//            double resteAPayer = selectedBoisson.prix - montantPaiement;
//            txtMessagePaiement.setText("Reste à payer: " + resteAPayer + " €");
//        }else if(selectedBoisson.prix < montantPaiement){ // Cas : Montant payer supérieur au prix - Message : Monnaie rendue: XXX
//            txtMessagePaiement.setText("Monnaie rendue: " + montantARendre + " €\nBonne dégustation ;)");
//            //Enlève la boisson sélectionnée de la liste
//            lstBoisson.getItems().remove(selectedIndex);
//        }else{
//            txtMessagePaiement.setText("Bonne dégustation ;)");
//        }
    }

    // TODO: Vérifier que paiement >= prix

    /**
     *
     * @param montantPaiement: Montant du paiement
     * @param montantAPayer: Prix à payer
     */
    List<Integer> getListMonnaieRendue(int montant, int aRendre, List<Integer> lstMonnaieRendue)
    {
        if(aRendre >= montant && aRendre%montant >= 0){
            lstMonnaieRendue.add(montant);
            aRendre -= montant;
        }
        return lstMonnaieRendue;
    }
    List<Integer> ManageMonaieARendre(int montantPaiement, int montantAPayer){
        int aRendre = montantPaiement - montantAPayer;
        List<Integer> lstMonnaieRendue = new ArrayList<Integer>();
        List<Integer> lstTypePieces = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200));
        Collections.sort(lstTypePieces, Collections.reverseOrder());
        System.out.println("Paiement : " + montantPaiement);
        System.out.println("A payer : " + montantAPayer);
        System.out.println(">>> A rendre : " + aRendre);


        for(int i : lstTypePieces){
            System.out.println("- A rendre : " + aRendre);
            System.out.println(">>> " + i);
            System.out.println("Modulo:" + aRendre%i);
            if(aRendre >= i && aRendre%i >= 0){

                lstMonnaieRendue.add(i);
                aRendre -= i;
            }
        }
        return lstMonnaieRendue;
//
//
//
//        // Tant que aRendre > 0
//        while(aRendre > 0) {
//            // Récupère le montant max à déduire de aRendre à partir de la liste des types
//            int montantADeduire = lstTypePieces.stream().
//            // Calcul le type de pièce à rendre
//            // > Nb Type Pièce = aRendre /
//            // Ajoute le type de pièce à rendre dans la liste monnaie rendue
//        }
    }
}
