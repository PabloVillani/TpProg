package EventsGestion;

import Citizen.Citizen;
import Events.Outbreak;
import Util.ArrayMaker;
import Util.DateManager;
import Util.Finder;
import java.util.*;

public class StatsManager {
    ArrayMaker arrayMaker = new ArrayMaker();
    DateManager dm = new DateManager();

    public HashMap<String, Integer> countSymptoms(Location location) {
        List<String> symptomsLocationList = arrayMaker.singleStringMaker("src/DataBase/ModificableBases/LocationsSymptoms/" + location.getName() + "Symptoms.txt");
        List<String> baseSymptoms = arrayMaker.singleStringMaker("src/DataBase/PreexistingBases/SymptomsBase.txt");
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < baseSymptoms.size(); i++) {
            if (baseSymptoms.get(i) != null) {
                hm.put(baseSymptoms.get(i), 0);
            }
        }
        for (int j = 0; j < symptomsLocationList.size(); j++) {
            String symptom = symptomsLocationList.get(j);
            if (symptom != null) {
                hm.put(symptom, hm.get(symptom) + 1);
            }
        }
        return hm;
    }

    public String top3Symptoms(Location location) {
        HashMap<String, Integer> hm = countSymptoms(location);
        String s = "Top 3 sintomas de " + location.getName() + ": \n";
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }});
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        int i = 1;
        for (String key : temp.keySet()) {
            if (i < 4) {
                s += i + "." + key + ": " + temp.get(key) + "\n";
                i++;
            }
        }
        return s;
    }

    public Outbreak possibleOutbreak(Citizen citizen, Location location){
        Integer citizensInvolved = 0;
        ArrayList<String[]> possibleContagion = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/PossibleContagionInLocation/PossibleContagion" + location.getName() + ".txt");
        int a = 1; //El paciente 0 es el primer involucrado, entonces a = 1 (sino, el sistema lo estaba ignorando).
        int b = 0;
        for (int i = 0; i < possibleContagion.size(); i++) {
            String[] contagiador1 = possibleContagion.get(i);
            if(contagiador1[0].equals(citizen.getCuil())){
                a++;
                for (int j = 0; j < possibleContagion.size(); j++) {
                    String[] contagiador2 = possibleContagion.get(j);
                    if(contagiador2[0].equals(contagiador1[1]) && contagiador2[2].equals(contagiador1[2]) && dm.fourtyEightHoursBetweenDates(dm.stringToDate(contagiador1[3]),dm.stringToDate(contagiador2[3]))){
                        b++;
                    }
                }
            }
        }
        System.out.println(a+b);
        if(a+b >= 5){
            return new Outbreak(a+b,location);
        }
        else {
            return null;
        }
    }
}

