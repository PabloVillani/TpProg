package EventsGestion;

import Citizen.Citizen;
import Util.*;

import java.util.ArrayList;

public class PossibleDiseases {
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    Scanner scanner = new Scanner();
    Writer writer = new Writer();

    public void possibleDiseases(Citizen c){
        int coronavirusChance = 0;
        int sarampionChance = 0;
        int neumoniaChance = 0;
        ArrayList<String[]> symptoms = arrayMaker.fourValueStringMaker("src/DataBase/ModificableBases/UsersSymptoms.txt");
        ArrayList<String[]> diseases = arrayMaker.fourValueStringMaker("src/DataBase/PreexistingBases/DiseasesBase.txt");
        for (int i = 0; i < symptoms.size(); i++) {
            String[] line = symptoms.get(i);
            for (int j = 0; j < diseases.size(); j++) {
                String[] diseaseSymptoms = diseases.get(i);
                for (String diseaseSymptom : diseaseSymptoms) {
                    if (line[1].equals(diseaseSymptom) && diseaseSymptoms[0].equals("Coronavirus")) {
                        coronavirusChance++;
                    } else if (line[1].equals(diseaseSymptom) && diseaseSymptoms[0].equals("Sarampion")) {
                        sarampionChance++;
                    } else if (line[1].equals(diseaseSymptom) && diseaseSymptoms[0].equals("Neumonia")) {
                        neumoniaChance++;
                    }
                }
            }
        }
        if(coronavirusChance >= 3){
            System.out.println("Es probable que usted tenga Coronavirus. Le recomendamos consultar con un doctor.");
        }if(sarampionChance >= 3){
            System.out.println("Es probable que usted tenga Sarampion. Le recomendamos consultar con un doctor.");
        }if(neumoniaChance >= 3){
            System.out.println("Es probable que usted tenga Neumonia. Le recomendamos consultar con un doctor.");
        }
    }
}//
