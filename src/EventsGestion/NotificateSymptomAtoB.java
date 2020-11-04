package EventsGestion;

import Citizen.Citizen;
import Util.*;

import java.util.ArrayList;

public class NotificateSymptomAtoB {
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    Scanner scanner = new Scanner();
    Writer writer = new Writer();
    GregorianCalendar gc = new GregorianCalendar();
    public void notificateSymptomAtoB(Citizen c) {
        ArrayList<String[]> symptomsReported = arrayMaker.fourValueStringMaker("src/DataBase/ModificableBases/UsersSymptoms.txt");
        ArrayList<String[]> confirmedContacts = arrayMaker.quintupleStringMaker("src/DataBase/ModificableBases/ConfirmedContacts.txt");
        for (int i = 0; i < symptomsReported.size(); i++) {
            for (int j = 0; j < confirmedContacts.size(); j++) {
                String[] symptomsLine = symptomsReported.get(i);
                String[] contactsLine = confirmedContacts.get(j);
                if ((symptomsLine[0].equals(contactsLine[0]) || symptomsLine[0].equals(contactsLine[1])) && !c.getCuil().equals(symptomsLine[0])){
                    if(gc.fourtyEightHoursBetweenDates(gc.stringToGc(symptomsLine[3]),gc.stringToGc(contactsLine[4]))){
                        if(c.getCuil().equals(contactsLine[0]) || c.getCuil().equals(contactsLine[1])){
                            System.out.println("Una persona con quien ha tenido contacto en los ultimos 2 dias ha reportado el siguiente sintoma: " + symptomsLine[1]);
                        }
                    }
                }
            }
        }
    }
}