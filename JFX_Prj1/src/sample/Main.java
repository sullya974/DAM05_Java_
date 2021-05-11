package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.text.html.ListView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 570, 275);
        primaryStage.setScene(scene);
//
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);

        Main test = new Main();

        // Avec déclaration de type des paramètres
        MathOperation addition = (int a, int b) -> a + b;
        // Sans déclaration de type des paramètres
        MathOperation substraction = (int a, int b) -> a - b;

        // Avec un retour à l'intérieur des accolades
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        //

    }
}
