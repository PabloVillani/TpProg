package EventsGestion;

import Events.Disease;
import Events.Symptom;
import Util.ArrayMaker;
import Util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class Location {
    String name;
    ArrayList<Symptom> symptoms;
    ArrayList<Disease> diseases;
    ArrayMaker arrayMaker = new ArrayMaker();
    Scanner scanner = new Scanner();

    public Location(){}

    public Location(String name, ArrayList<Symptom> symptoms, ArrayList<Disease> diseases){
        this.name = name;
        this.symptoms = symptoms;
        this.diseases = diseases;
    }
    public String locationChooser() {
        List<String> ubications = arrayMaker.singleStringMaker("src/DataBase/PreexistingBases/Ubications.txt");
        System.out.println();
        String linea = "";
        int i = scanner.getInt("Elija su ubicacion: ");
        if (i < 0 || i > 5) {
            System.out.println("Numero Invalido."); //Recursion en caso de ingresar un numero invalido.
            locationChooser();
        } else {
            if (i == 1) {
                linea = "Escobar";
            }
            if (i == 2) {
                linea = "Gral. Rodriguez";
            }
            if (i == 3) {
                linea = "Pilar";
            }
            if (i == 4) {
                linea = "Tigre";
            }
            if (i == 5) {
                linea = "Zarate";
            }
        }
        return linea;
    }
}
