package UserGestion;

import Citizen.Citizen;
import Util.ArrayMaker;
import Util.Finder;

import java.util.ArrayList;

public class Blocker {
    public static void blocker(Citizen c){
        ArrayList<String[]> rejectedRequests;
        rejectedRequests = ArrayMaker.doubleStringMaker("src/DataBase/ModificableBases/RejectedRequests.txt");
        if(Finder.doubleValueFinder(c.cuil, "5", rejectedRequests)){
            //Escribir true al lado del CUIL en el BlockedUsers.txt
            ArrayList<String[]> blockedUsers;
            blockedUsers = ArrayMaker.doubleStringMaker("src/DataBase/ModificableBases/BlockedUsers.txt");
            if(Finder.doubleValueFinder(c.cuil, "true", blockedUsers)){
                c.setBlocked(true);
            }

        }
    }
}
