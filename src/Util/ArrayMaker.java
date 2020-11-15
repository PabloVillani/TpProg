package Util;

import Citizen.Citizen;
import Events.Symptom;
import EventsGestion.Location;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Crea los diferentes ArrayList<String[]>
public class ArrayMaker {
    public ArrayMaker() {
    }


    //-------------- Crea el ArrayList<String[]> de la base de datos de los archivos de dos valores.
    public ArrayList<String[]> arrayListStringMaker(String path) {
        ArrayList<String[]> array = new ArrayList<String[]>();
        String line; //Lee el txt
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
            String head = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) { //Mientras que haya texto
                String[] strings = line.split(",");//Copiara los datos a un String[]
                array.add(strings);                           //Y los agrega al ArrayList<String[]>
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public List<String> singleStringMaker(String path) {
        List<String> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                line = br.readLine(); //lee la primer linea y despues pasa a la siguiente, si no hay más devuelve null, y se termina el while.
                list.add(line);//Crea el array de Strings.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Symptom> stringToSymptoms(List<String> symptomsStrings) {
        ArrayList<Symptom> symptoms = new ArrayList<>();
        for (int i = 0; i < symptomsStrings.size(); i++) {
            if (symptomsStrings.get(i) != null) {
                symptoms.add(new Symptom(symptomsStrings.get(i)));
            }
        }
        return symptoms;
    }

    public ArrayList<Citizen> stringsToCitizen(ArrayList<String[]> citizensStrings){
        ArrayList<Citizen> citizens = new ArrayList<>();
        for (int i = 0; i < citizensStrings.size(); i++) {
            String[] line = citizensStrings.get(i);
            if (line[0] != null && line[1] != null && line[2] != null && line[3] != null) {
                citizens.add(new Citizen(line[0], line[1], line[2],new Location(line[3])));
            }
        }
        return citizens;
    }

}

