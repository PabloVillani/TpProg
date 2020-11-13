package EventsGestion;

import Citizen.Citizen;
import Util.*;

import java.util.ArrayList;

public class NotificateSymptomAtoB {
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    Scanner scanner = new Scanner();
    Writer writer = new Writer();
    DateManager dm = new DateManager();
    public void notificateSymptomAtoB(Citizen c) {
        int symptomsReported = 0;
        String symptoms = "";
        ArrayList<String[]> symptomsReports = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/UsersSymptoms.txt");
        ArrayList<String[]> confirmedContacts = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/ConfirmedContacts.txt");
        for (int i = 0; i < symptomsReports.size(); i++) {
            for (int j = 0; j < confirmedContacts.size(); j++) {
                String[] symptomsLine = symptomsReports.get(i);
                String[] contactsLine = confirmedContacts.get(j);
                if ((symptomsLine[0].equals(contactsLine[0]) || symptomsLine[0].equals(contactsLine[1])) && !c.getCuil().equals(symptomsLine[0])){
                    symptoms += symptomsLine[1] + ", ";
                    symptomsReported++;
                    if(dm.fourtyEightHoursBetweenDates(dm.stringToDate(symptomsLine[2]), dm.stringToDate(contactsLine[3])) && symptomsReported >= 2){
                        if(c.getCuil().equals(contactsLine[0]) || c.getCuil().equals(contactsLine[1]) && symptomsReported >= 2){
                            System.out.println("Una persona con quien ha tenido contacto en los ultimos 2 dias ha reportado el siguiente sintoma: " + symptoms);
                        }
                    }
                }
            }
        }
    }
}