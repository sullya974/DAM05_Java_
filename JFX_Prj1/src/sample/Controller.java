package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        double montantPaiement = (txtPaiement.getText() != "") ? Double.parseDouble(txtPaiement.getText()) : 0;

        Boisson selectedBoisson = lstBoisson.getSelectionModel().getSelectedItem();
        int selectedIndex = lstBoisson.getSelectionModel().getSelectedIndex();
        double montantARendre = montantPaiement - selectedBoisson.prix;

        // Cas : Montant payer inférieur au prix - Message : Reste à payer : XXX
        if(montantPaiement == 0){
            txtMessagePaiement.setText("Veuillez payer: " + selectedBoisson.prix + " €");
        }else if(selectedBoisson.prix > montantPaiement){
            txtMessagePaiement.setText("Monnaie rendue: " + montantARendre + " €\nBonne dégustation ;)");
        }else if(selectedBoisson.prix < montantPaiement){ // Cas : Montant payer supérieur au prix - Message : Monnaie rendue: XXX
            txtMessagePaiement.setText("Monnaie rendue: " + montantARendre + " €\nBonne dégustation ;)");
        }else{
            txtMessagePaiement.setText("Bonne dégustation ;)");
        }
        //Enlève la boisson sélectionnée de la liste
        lstBoisson.getItems().remove(selectedIndex);
    }
}
