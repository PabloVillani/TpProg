package EventsGestion;

import Citizen.Citizen;
import Events.Outbreak;
import Util.ArrayMaker;
import Util.Finder;
import java.util.*;

public class StatsManager {
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    Location location = new Location();

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

//    public Outbreak possibleOutbreak(Location location){
//        ArrayList<String[]> possibleOutbreak = new ArrayList<>();
//        ArrayList<Citizen> citizensInvolved = new ArrayList<Citizen>();
//        int a = 0;
//        int b = 0;
//        ArrayList<String[]> possibleContagion = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/PossibleContagion" + location.getName() + ".txt");
//        for (int i = 0; i < possibleContagion.size(); i++) {
//            String[] line1 = possibleContagion.get(i);
//            for (int j = 0; j < possibleContagion.size(); j++) {
//                String[] line2 = possibleContagion.get(j);
//                if(line1[0].equals(line2[0])){
//                    possibleOutbreak.add(line2);
//
//                    a++;
//                    for (int k = 0; k < possibleContagion.size(); k++) {
//                        String[] line3 = possibleContagion.get(k);
//                        if(line2[1].equals(line3[0]) && line1[2].equals(line3[3])){
//                            possibleOutbreak.add(line3);
//                            b++;
//                        }
//                    }
//                }
//            }
//
//        }if(a < 4 && a+b >= 5){
//            return new Outbreak()
//        }
//    }

}

