package Citizen;

import Events.Invite;
import EventsGestion.Location;
import Exceptions.SymptomsExceptions;
import Util.*;
import Util.Writer;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;


public class Citizen {

    public String cuil;
    private String mobile;
    private ArrayList<String> symptoms;
    int rejectedRequests;
    private boolean blocked;



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
    public ArrayList<String> getSymptoms() {return symptoms;}
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
    public void solveSymptoms() {
        ArrayList<String[]> userSymptoms = arrayMaker.fourValueStringMaker("src/DataBase/ModificableBases/UsersSymptoms.txt");
        List<String> mySymptoms = new ArrayList<String>();
        System.out.println("Estos son sus sintomas activos:");
        for (int i = 0; i < userSymptoms.size(); i++) {
            String[] line = userSymptoms.get(i);
            if(this.cuil.equals(line[0])){//Devuelve todos, esta funcionando mal
                System.out.println(line[1]);
                mySymptoms.add(line[1]);
            }
        }
        String symptom = scanner.getString("Ingrese su sintoma: ");
        if (finder.singleValueFinder(symptom, mySymptoms)){
            System.out.println("Fecha final del sintoma:");
            GregorianCalendar end = gcm.dateGenerator();
            int j = finder.indexOf2(this.cuil,symptom,userSymptoms); //Se frena en la primera linea (-,-,-,-)
            if(j != -1){
                System.out.println();
                String[] s = userSymptoms.get(j);
                String startDate = s[2];
                String location = s[3];
                writer.fourValueWriter(this.cuil,symptom,startDate,end.gCToString(end),"src/DataBase/ModificableBases/UserSymptomHistory.txt");
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
    public void meetingConfirmation() {

    }
}
