package EventsGestion;

import Util.ArrayMaker;
import Util.Finder;

import java.util.*;

public class StatsManager {
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    Location location = new Location();

    public void topSymptoms(String locationName) {
        List<String> list = arrayMaker.singleStringMaker("src/DataBase/ModificableBases/LocationsSymptoms/" + locationName + "Symptoms.txt");
        Set<String> distinct = new HashSet<>(list);
        for (String s: distinct) {
            System.out.println(s + ": " + Collections.frequency(list, s));
        }
        //        Map<String, Integer> hm = new HashMap<String, Integer>();
//        for (String i : list) {
//            Integer j = hm.get(i);
//            hm.put(i, (j == null) ? 1 : j + 1);
//        }
//        int s = 1;
//        for (Map.Entry<String, Integer> val : hm.entrySet()) {
//            for (int i = 0; i < 2; i++) {
//                System.out.println(s + ". " + val.getKey() + ": " + val.getValue() + " reportes.");
//                s++;
//            }
//        }
    }
}
