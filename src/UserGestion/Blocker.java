package UserGestion;

import Citizen.Citizen;
import Util.ArrayMaker;
import Util.Finder;
import Util.Writer;
import java.util.ArrayList;

public class Blocker {
    Finder finder = new Finder();
    ArrayMaker arrayMaker = new ArrayMaker();
    Writer writer = new Writer();

    public void blocker(Citizen c) {
        ArrayList<String[]> rejectedRequests = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/RejectedRequests.txt");
        ArrayList<String[]> blockedUsers = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/BlockedUsers.txt");
        if (finder.doubleValueFinder(c.cuil, "5", rejectedRequests)) {
            if (!finder.doubleValueFinder(c.cuil, "true", blockedUsers)) {
                writer.replace("src/DataBase/ModificableBases/BlockedUsers.txt", c.cuil + ",false", c.cuil + ",true");
                blockedUsers = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/BlockedUsers.txt");
            }
            if (finder.doubleValueFinder(c.cuil, "true", blockedUsers)) {
                c.setBlocked(true);
            }
        }
    }
}

