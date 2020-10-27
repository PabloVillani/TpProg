package Citizen;

import Events.Invite;
import EventsGestion.Location;
import Exceptions.SymptomsExceptions;
import Util.*;
import Util.Writer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Citizen {

    public String cuil;
    public String mobile;
    ArrayList<String> symptoms;
    int rejectedRequests;
    public boolean blocked;
    ArrayMaker arrayMaker = new ArrayMaker();
    Scanner scanner = new Scanner();
    Invite invite = new Invite();
    Writer writer = new Writer();
    Location location = new Location();
    HashMapMaker hashMapMaker = new HashMapMaker();
    GregorianCalendar gc = new GregorianCalendar();
    GregorianCalendar gcm = new GregorianCalendar();
    Finder finder = new Finder();
    public Citizen(String cuil, String mobile){ //Un Ciudadano Base, recien registrado al sistema.
        this.cuil = cuil;
        this.mobile = mobile;
        symptoms = null;
        rejectedRequests = 0;
        blocked = false;
    }
    public Citizen(String cuil, String mobile, ArrayList<String>symptoms, int rejectedRequests, boolean blocked){ //Un ciudadano con todas las variables.
        this.cuil = cuil;
        this.mobile = mobile;
        this.symptoms = symptoms;
        this.rejectedRequests = rejectedRequests;
        this.blocked = blocked;
    }
    //----------------------------------------GETTERS Y SETTERS---------------------------
    public String getCuil() {
        return cuil;
    }

    public String getMobile() {
        return mobile;
    }
    public boolean isBlocked() {
        return blocked;
    }
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    //-------------------------------------------------------------------------------------
    public void ContactRequest() {
        String contactCitizenCUIL = scanner.getString("Ingrese el CUIL del ciudadano con el que ha tenido contacto: ");
        System.out.println("Inicio del contacto:");
        GregorianCalendar start = gcm.dateGenerator();
        System.out.println("Fin del contacto:");
        GregorianCalendar end = gcm.dateGenerator();
        String locationName = location.locationChooser();
        writer.fiveValueWriter(this.cuil, contactCitizenCUIL, start.gCToString(start), end.gCToString(end), locationName,"src/DataBase/ModificableBases/AwaitingContacts.txt");
    }

    public void symptomsReport() {
        List<String> activeSymptoms = arrayMaker.singleStringMaker("src/DataBase/ModificableBases/ActiveSymptoms.txt");
        String line;
        try{
            String symptom = scanner.getString("Ingrese su sintoma: ");
            if(finder.singleValueFinder(symptom,activeSymptoms)){
                ArrayList<String[]> userSymptoms = arrayMaker.fourValueStringMaker("src/DataBase/ModificableBases/UsersSymptoms.txt");
                if (!finder.doubleValueFinder(this.cuil, symptom, userSymptoms)) {
                    System.out.println("Inicio del sintoma:");
                    GregorianCalendar start = gcm.dateGenerator();
                    String locationName = location.locationChooser();
                    writer.fourValueWriter(this.cuil, symptom, start.gCToString(start), locationName, "src/DataBase/ModificableBases/UsersSymptoms.txt");
                    writer.singleValueWriter(symptom, "src/DataBase/ModificableBases/" + locationName + "Symptoms.txt");
                } else {
                    throw new SymptomsExceptions(35);
                }
            }else{
                throw new SymptomsExceptions(34);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void SolveSymptoms() {

    }
    public void meetingConfirmation() {

    }
}
