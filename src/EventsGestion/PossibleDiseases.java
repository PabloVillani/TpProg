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
        ArrayList<String[]> symptoms = arrayMaker.fourValueStringMaker("src/DataBase/ModificableBases/UsersSymptoms.txt");
        ArrayList<String[]> diseases = arrayMaker.fourValueStringMaker("src/DataBase/PreexistingBases/DiseasesBase.txt");
    }
}
