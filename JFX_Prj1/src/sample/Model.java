package sample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Model {
    public static ArrayList<Boisson> loadBoissons(){
        Boisson boisson1 = new Boisson();
        boisson1.prix = 4.5;
        boisson1.nom = "Coca";
        Boisson boisson2 = new Boisson();
        boisson2.prix = 1.5;
        boisson2.nom = "Orangina";

        ArrayList<Boisson> lstBoissons = new ArrayList(Arrays.asList(boisson1, boisson2));

        return lstBoissons;
    }

    public static ArrayList<Boisson> loadBoissonsFromJson() throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        try(Reader reader = new FileReader("C:\\Users\\Sully\\Documents\\Java\\JFX_Prj1\\src\\sample\\data.json")){
            /*JSONObject jsonObject = (JSONObject)parser.parse(reader);
            System.out.println(jsonObject);

            String nom = (String)jsonObject.get("nom");
            System.out.println(nom);
            String prix = (String)jsonObject.get("nom");
            System.out.println(prix);*/

            // Loop array
            ArrayList<Boisson> lstBoissons = new ArrayList();
            JSONArray jsonArray = (JSONArray)parser.parse(reader);
            for(Object o: jsonArray){
                JSONObject jsonObject = (JSONObject)o;
                lstBoissons.add(new Boisson((Double)jsonObject.get("prix"), (String)jsonObject.get("nom")));
                System.out.println(jsonObject.get("nom"));
            }

            return lstBoissons;
        }catch(IOException e){
            e.printStackTrace();
        }

        return (new ArrayList<Boisson>());
    }
}
