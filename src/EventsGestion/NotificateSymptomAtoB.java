package EventsGestion;

import Citizen.Citizen;
import Util.*;
import java.util.ArrayList;

public class NotificateSymptomAtoB {
    ArrayMaker arrayMaker = new ArrayMaker();
    DateManager dm = new DateManager();
    Writer writer = new Writer();
    Finder finder = new Finder();
    public void notificateSymptomAtoB(Citizen c) {
       ArrayList<String[]> symptomsReported = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/UsersSymptoms.txt");
       ArrayList<String[]> confirmedContacts = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/ConfirmedContacts.txt");
        for (int i = 0; i < symptomsReported.size(); i++) {
            for (int j = 0; j < symptomsReported.size(); j++) {
               String[] line1 = symptomsReported.get(i);
               String[] line2 = symptomsReported.get(j);
               if(i != j && line1[0].equals(line2[0]) && dm.twentyFourHoursBetweenDates(dm.stringToDate(line1[2]),dm.stringToDate(line2[2]))){
                   for (int k = 0; k < confirmedContacts.size(); k++) {
                       String[] contactsLine = confirmedContacts.get(k);
                       if((line1[0].equals(contactsLine[0]) || line1[0].equals(contactsLine[1])) && !c.getCuil().equals(line1[0])) {
                           if (contactsLine[0].equals(c.getCuil()) || contactsLine[1].equals(c.getCuil())) {
                               if (dm.fourtyEightHoursBetweenDates(dm.stringToDate(contactsLine[3]), dm.stringToDate(line1[2]))) {
                                   System.out.println("Una persona (CUIL: " + line1[0] + ") con la quien ha tenido contacto recientemente ha reportado los siguientes sintomas:\n" + line1[1] + "\n" + line2[1]);
                                   ArrayList<String[]> possibleContagion = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/PossibleContagionInLocation/PossibleContagion" + c.getCitizenLocation().getName() + ".txt");
                                   if (!line1[0].equals(contactsLine[0])) {
                                       if (!finder.fourValueFinder(line1[0], contactsLine[0], line1[1], line1[2], possibleContagion)) {
                                           writer.fourValueWriter(line1[0], contactsLine[0], line1[1], line1[2], "src/DataBase/ModificableBases/PossibleContagionInLocation/PossibleContagion" + c.getCitizenLocation().getName() + ".txt");
                                       }
                                       if (!finder.fourValueFinder(line1[0], contactsLine[0], line2[1], line1[2], possibleContagion)) {
                                           writer.fourValueWriter(line1[0], contactsLine[0], line2[1], line1[2], "src/DataBase/ModificableBases/PossibleContagionInLocation/PossibleContagion" + c.getCitizenLocation().getName() + ".txt");
                                       }
                                   }
                                   if (line1[0].equals(contactsLine[0])) {
                                       if (!finder.fourValueFinder(line1[0], contactsLine[1], line1[1], line1[2], possibleContagion)) {
                                           writer.fourValueWriter(line1[0], contactsLine[1], line1[1], line1[2], "src/DataBase/ModificableBases/PossibleContagionInLocation/PossibleContagion" + c.getCitizenLocation().getName() + ".txt");
                                       }
                                       if (!finder.fourValueFinder(line1[0], contactsLine[1], line2[1], line1[2], possibleContagion)) {
                                           writer.fourValueWriter(line1[0], contactsLine[1], line2[1], line1[2], "src/DataBase/ModificableBases/PossibleContagionInLocation/PossibleContagion" + c.getCitizenLocation().getName() + ".txt");
                                       }
                                   }
                               }
                           }
                       }
                   }
               }
            }
        }
    }
}