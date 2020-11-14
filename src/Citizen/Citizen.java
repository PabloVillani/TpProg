package Citizen;

import Events.Disease;
import Events.Invite;
import Events.Symptom;
import EventsGestion.Location;
import Exceptions.InputException;
import Exceptions.SymptomsExceptions;
import Util.*;
import Util.Writer;
import java.io.*;
import java.nio.channels.FileChannel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Citizen {

    ArrayMaker arrayMaker = new ArrayMaker();
    Scanner scanner = new Scanner();
    Invite invite = new Invite();
    Writer writer = new Writer();
    Location location = new Location();
    HashMapMaker hashMapMaker = new HashMapMaker();
    DateManager gcm = new DateManager();
    Finder finder = new Finder();

    public String cuil;
    private String mobile;
    private ArrayList<Symptom> symptoms;
    private ArrayList<Disease> diseases;
    private int rejectedRequests;
    private boolean blocked;
    private Location citizenLocation;



    public Citizen(String cuil){
        this.cuil = cuil;
    }
    public Citizen(String cuil, String mobile, Location citizenLocation){ //Un Ciudadano Base, recien registrado al sistema.
        this.cuil = cuil;
        this.mobile = mobile;
        this.citizenLocation = citizenLocation;
        symptoms = null;
        rejectedRequests = 0;
        blocked = false;
    }

    public Citizen(String cuil, String mobile, ArrayList<Symptom> symptoms, ArrayList<Disease> diseases, int rejectedRequests, boolean blocked, Location citizenLocation) {
        this.cuil = cuil;
        this.mobile = mobile;
        this.symptoms = symptoms;
        this.diseases = diseases;
        this.rejectedRequests = rejectedRequests;
        this.blocked = blocked;
        this.citizenLocation = citizenLocation;
    }

    //----------------------------------------GETTERS Y SETTERS---------------------------
    public String getCuil() {
        return cuil;
    }
    public String getMobile() {
        return mobile;
    }
    public ArrayList<Symptom> getSymptoms() {return symptoms;}
    public ArrayList<Disease> getDiseases() {return diseases;}
    public boolean isBlocked() {
        return blocked;
    }
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    public Location getCitizenLocation(){ return location;}
    //-------------------------------------------------------------------------------------
    public void ContactRequest() {
        String contactCitizenCUIL = scanner.getString("Ingrese el CUIL del ciudadano con el que ha tenido contacto: ");
        ArrayList<String[]> users = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/Users.txt");
        try {
        if (finder.singleValueFinderArray(contactCitizenCUIL, users,0)) {
            int i = finder.indexOf(contactCitizenCUIL, users, 0);
            String[] line = users.get(i);
            int j = finder.indexOf(this.cuil, users, 0);
            String[] c = users.get(j);
            if (line[3].equals(c[3])) {
                System.out.println("Inicio del contacto:");
                LocalDateTime start = gcm.dateGenerator();
                System.out.println("Fin del contacto:");
                LocalDateTime end = gcm.dateGenerator();
                String locationName = location.locationChooser();
                writer.fiveValueWriter(this.cuil, contactCitizenCUIL, gcm.dateToString(start), gcm.dateToString(end), locationName, "src/DataBase/ModificableBases/AwaitingContacts.txt");
            }else {
                throw new InputException(81);
            }
        }
        } catch (InputException e) {
            e.printStackTrace();
        }
    }

    public void symptomsReport() {
        List<String> activeSymptoms = arrayMaker.singleStringMaker("src/DataBase/ModificableBases/ActiveSymptoms.txt");
        String line;
        try{
            String symptom = scanner.getString("Ingrese su sintoma: ");
            if(finder.singleValueFinder(symptom,activeSymptoms)){
                ArrayList<String[]> userSymptoms = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/UsersSymptoms.txt");
                if (!finder.doubleValueFinder(this.cuil, symptom, userSymptoms)) {
                    System.out.println("Inicio del sintoma:");
                    LocalDateTime start = gcm.dateGenerator();
                    String locationName = location.locationChooser();
                    writer.fourValueWriter(this.cuil, symptom, gcm.dateToString(start), locationName, "src/DataBase/ModificableBases/UsersSymptoms.txt");
                    writer.singleValueWriter(symptom, "src/DataBase/ModificableBases/LocationsSymptoms/" + locationName + "Symptoms.txt");
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
    public void solveSymptoms() {
        ArrayList<String[]> userSymptoms = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/UsersSymptoms.txt");
        List<String> mySymptoms = new ArrayList<String>();
        System.out.println("Estos son sus sintomas activos:");
        for (int i = 0; i < userSymptoms.size(); i++) {
            String[] line = userSymptoms.get(i);
            if(this.cuil.equals(line[0])){ //Busca solo los sintomas del usuario y se los imprime para elegir.
                System.out.println(line[1]);
                mySymptoms.add(line[1]);
            }
        }
        String symptom = scanner.getString("Ingrese su sintoma: ");
        if (finder.singleValueFinder(symptom, mySymptoms)){ //Crea el fin del sintoma para imprimirlo en el historial.
            System.out.println("Fecha final del sintoma:");
            LocalDateTime end = gcm.dateGenerator();
            int j = finder.indexOf2(this.cuil,symptom,userSymptoms);
            if(j != -1){
                System.out.println();
                String[] s = userSymptoms.get(j);
                String startDate = s[2];
                String location = s[3];
                writer.fiveValueWriter(this.cuil,symptom,startDate,gcm.dateToString(end),location,"src/DataBase/ModificableBases/UserSymptomHistory.txt");
                writer.replace("src/DataBase/ModificableBases/UsersSymptoms.txt",this.cuil + "," + symptom + "," + startDate + "," + location,"");
                FileChannel src = null;
                try {
                    src = new FileInputStream("src/DataBase/ModificableBases/UsersSymptoms.txt").getChannel();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                FileChannel dest = null;
                try {
                    dest = new FileOutputStream("src/DataBase/ModificableBases/UsersSymptomsSupport.txt").getChannel();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    dest.transferFrom(src, 0, src.size());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (BufferedReader inputFile = new BufferedReader(new FileReader("src/DataBase/ModificableBases/UsersSymptomsSupport.txt"));
                     PrintWriter outputFile = new PrintWriter(new FileWriter("src/DataBase/ModificableBases/UsersSymptoms.txt"))) {
                    String lineOfText;
                    while ((lineOfText = inputFile.readLine()) != null) {
                        lineOfText = lineOfText.trim();
                        if (!lineOfText.isEmpty()) {
                            outputFile.println(lineOfText);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            try {
                throw new SymptomsExceptions(36);
            } catch (SymptomsExceptions symptomsExceptions) {
                symptomsExceptions.printStackTrace();
            }
        }
    }
    public void yourSymptoms(){
        ArrayList<String[]> userSymptoms = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/UsersSymptoms.txt");
        for (int i = 0; i < userSymptoms.size(); i++) {
            String[] line = userSymptoms.get(i);
            if(line[0].equals(getCuil())){
                getSymptoms().add(new Symptom(line[1]));
            }
        }
    }
}
