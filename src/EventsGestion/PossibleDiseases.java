package EventsGestion;

import Citizen.Citizen;
import Events.Disease;
import Util.*;
import java.util.ArrayList;

public class PossibleDiseases {
    ArrayMaker arrayMaker = new ArrayMaker();
    Disease disease = new Disease();
    Finder finder = new Finder();

    public void possibleDiseases(Citizen c) {
        int coronavirusChance = 0;
        int sarampionChance = 0;
        int neumoniaChance = 0;
        ArrayList<String[]> symptoms = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/UsersSymptoms.txt");
        ArrayList<String[]> diseases = arrayMaker.arrayListStringMaker("src/DataBase/PreexistingBases/DiseasesBase.txt");
        for (int i = 0; i < symptoms.size(); i++) {
            String[] line = symptoms.get(i);
            if (line[0].equals(c.getCuil())) {
            for (int j = 0; j < diseases.size(); j++) {
                String[] diseaseSymptoms = diseases.get(j);
                for (int k = 0; k < diseaseSymptoms.length; k++) {
                        if (line[1].equals(diseaseSymptoms[k]) && diseaseSymptoms[0].equals("Coronavirus")) {
                            coronavirusChance++;
                        } else if (line[1].equals(diseaseSymptoms[k]) && diseaseSymptoms[0].equals("Sarampion")) {
                            sarampionChance++;
                        } else if (line[1].equals(diseaseSymptoms[k]) && diseaseSymptoms[0].equals("Neumonia")) {
                            neumoniaChance++;
                        }
                    }
                }
            }
        }
            if(coronavirusChance >= 3) {
                if (c.getDiseases() != null) {
                    if (c.getDiseases() == null) {
                        System.out.println("Es probable que usted tenga Sarampion. Le recomendamos consultar con un doctor.");
                        c.getDiseases().add(disease.coronavirus());
                    } else {
                        if (!finder.diseaseFinder(disease.coronavirus(), c.getDiseases())) {
                            System.out.println("Es probable que usted tenga Coronavirus. Le recomendamos consultar con un doctor.");
                            c.getDiseases().add(disease.coronavirus());
                        }
                    }
                }
            }
            if (sarampionChance >= 3) {
                if (c.getDiseases() == null) {
                    System.out.println("Es probable que usted tenga Sarampion. Le recomendamos consultar con un doctor.");
                    c.getDiseases().add(disease.sarampion());
                } else {
                    if (!finder.diseaseFinder(disease.sarampion(), c.getDiseases())) {
                        System.out.println("Es probable que usted tenga Sarampion. Le recomendamos consultar con un doctor.");
                        c.getDiseases().add(disease.sarampion());
                    }
                }
            }
            if (neumoniaChance >= 3) {
                if (c.getDiseases() == null) {
                    System.out.println("Es probable que usted tenga Neumonia. Le recomendamos consultar con un doctor.");
                    c.getDiseases().add(disease.neumonia());
                }else {
                    if (!finder.diseaseFinder(disease.neumonia(), c.getDiseases())) {
                        System.out.println("Es probable que usted tenga Neumonia. Le recomendamos consultar con un doctor.");
                        c.getDiseases().add(disease.neumonia());
                    }
                }
            }

    }
}

