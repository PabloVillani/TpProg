package EventsGestion;

import Citizen.Citizen;
import Events.Disease;
import Events.Symptom;
import Util.ArrayMaker;
import Util.Scanner;

import java.util.*;

public class Location {
    String name;
    ArrayList<Citizen> citizens;
    ArrayMaker arrayMaker = new ArrayMaker();
    Scanner scanner = new Scanner();

    public Location(){
    }

    public Location(String name){
        this.name = name;
    }

    public Location(String name, ArrayList<Citizen> citizens) {
        this.name = name;
        this.citizens = citizens;
    }

    public String getName() {
        return name;
    }

    public String locationChooser() {
        List<String> ubications = arrayMaker.singleStringMaker("src/DataBase/PreexistingBases/Ubications.txt");
        for (int i = 0; i < ubications.size(); i++) {
            System.out.println(ubications.get(i));
        }
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
                linea = "Derqui";
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

    public void topSymptoms(String locationName) {
        List<String> list = arrayMaker.singleStringMaker("src/DataBase/ModificableBases/LocationsSymptoms/" + locationName + "Symptoms.txt");
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for (String i : list) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
        int s = 1;
        for (Map.Entry<String, Integer> val : hm.entrySet()) {
            for (int i = 0; i < 2; i++) {
                System.out.println(s + ". " + val.getKey() + ": " + val.getValue() + " reportes.");
                s++;
            }
        }
    }
}