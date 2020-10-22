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
        ArrayList<String[]> rejectedRequests = arrayMaker.doubleStringMaker("src/DataBase/ModificableBases/RejectedRequests.txt");
        if (finder.doubleValueFinder(c.cuil, "5", rejectedRequests)) {
            ArrayList<String[]> blockedUsers = arrayMaker.doubleStringMaker("src/DataBase/ModificableBases/BlockedUsers.txt");
            if (!finder.doubleValueFinder(c.cuil, "true", blockedUsers)) {
                System.out.println("El usuario ya esta bloqueado.");
            } else {
                writer.replace("src/DataBase/ModificableBases/BlockedUsers.txt", c.cuil + ",false", c.cuil + ",true");
                blockedUsers = arrayMaker.doubleStringMaker("src/DataBase/ModificableBases/BlockedUsers.txt");
                if (finder.doubleValueFinder(c.cuil, "true", blockedUsers)) {
                    c.setBlocked(true);
                } else {
                    System.out.println("Error. No se pudo bloquear al usuario.");
                }
            }
        }
    }
}
