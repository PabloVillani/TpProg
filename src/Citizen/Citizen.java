package Citizen;

import Events.Invite;
import EventsGestion.Location;
import Util.*;
import Util.Writer;

import java.util.ArrayList;


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

  /*  public void symptomsReport(String cuil) {
        List<String> symptoms = arrayMaker.singleStringMaker("src/DataBase/ModificableBases/ActiveSymptoms.txt");
        String line;
        try {
            String symptom = Scanner.getString("Ingrese su sintoma: "); //Pide el nombre del sintoma.
            String archive1 = "src/DataBase/PreexistingBases/SymptomsBase.txt";
            BufferedReader br = new BufferedReader(new FileReader(archive1));
            while ((line = br.readLine()) != null) {
                if (symptom.toLowerCase().equals(line.toLowerCase())) {
                    System.out.println(line); // de prueba
                    try {
                        String archive = "src/DataBase/ModificableBases/UsersSymptoms.txt";
                        File file = new File("src/DataBase/ModificableBases/UsersSymptoms.txt");
                        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                        BufferedReader br2 = new BufferedReader(new FileReader(archive));
                        HashMap<String, String> uS = HashMapMaker.cuilAndSymptomsMaker(archive);
                        System.out.println(uS); // de prueba
                        while ((line = br2.readLine()) != null) {
                            if (line.equals(cuil))  {
                                uS.put(cuil, symptom);
                                bw.write( "," + symptom.toUpperCase());
                                bw.close();
                            }
                            // if (uS.get(cuil).equals(symptom)) {


                        }
                        //Anota el sintoma en el .txt, junto al CUIL del usuario.
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

//                } else {
//                    throw new SymptomExceptions(34); //Recursion en caso de ingresar un string invalido.
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
//        } catch (SymptomExceptions symptomExceptions) {
//            symptomExceptions.printStackTrace();
        }
 }   */
    public void SolveSymptoms() {

    }
    public void meetingConfirmation() {

    }
}
