package Menus;

import Citizen.Citizen;
import Events.Outbreak;
import Events.Symptom;
import EventsGestion.NotificateSymptomAtoB;
import EventsGestion.PossibleDiseases;
import EventsGestion.StatsManager;
import UserGestion.Blocker;
import UserGestion.ConfirmContact;
import Util.ArrayMaker;
import Util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class CitizenMenu {
    Scanner scanner = new Scanner();
    Blocker blocker = new Blocker();
    ArrayMaker arrayMaker = new ArrayMaker();
    ConfirmContact confirmContact = new ConfirmContact();
    NotificateSymptomAtoB notificateSymptomAtoB = new NotificateSymptomAtoB();
    PossibleDiseases possibleDiseases = new PossibleDiseases();
    StatsManager statsManager = new StatsManager();
    ArrayList<String[]> citizensStrings = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/Users.txt");
    ArrayList<Citizen> citizens = arrayMaker.stringsToCitizen(citizensStrings);
    List<String> symptomsStrings = arrayMaker.singleStringMaker("src/DataBase/PreexistingBases/SymptomsBase.txt");
    ArrayList<Symptom> symptoms = arrayMaker.stringToSymptoms(symptomsStrings);
    //Despliega el menu del ciudadano en el Main.
    //Funciona tambien para correr repetidas veces diferentes codigos que pueden cambiar dependiendo del tiempo
    public void Menu(Citizen c){
        int n = 0;
        do {
            blocker.blocker(c);
            if (!c.isBlocked()) {
                confirmContact.confirmContact(c);
                notificateSymptomAtoB.notificateSymptomAtoB(c);
                possibleDiseases.possibleDiseases(c);
            for (int i = 0; i < citizens.size(); i++) {
                for (int j = 0; j < symptoms.size(); j++) {
                    Outbreak outbreak = statsManager.possibleOutbreak(citizens.get(i),citizens.get(i).getCitizenLocation(),symptoms.get(j));
                }
            }
            ArrayList<String[]> outbreaks = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/Outbreaks.txt");
                for (int i = 0; i < outbreaks.size(); i++) {
                    String[] line = outbreaks.get(i);
                    System.out.println("BROTE REPORTADO!\nSINTOMA: " + line[0] + "\nCIUDADANOS AFECTADOS: " + line[1] + "\nUBICACION: " + line[2]);
                }
            System.out.println("1.Registrar Contacto.\n2. Reportar sintomas\n3. Dar de baja sintoma. \n4. Abrir Mapa\n5. Cerrar Sesion.");
            n = scanner.getInt("Elija la operacion a realizar: ");
            switch (n) {
                case 1:
                    //Registra contacto con otro ciudadano
                    c.ContactRequest();
                    break;
                case 2:
                    //Reporta un sintoma, y lo agrega al UsersSymptoms.txt
                    c.symptomsReport();
                    break;
                case 3:
                    //Dar de baja sintomas.
                    c.solveSymptoms();
                    break;
                case 4:
                    //Abrir mapa.
                    break;
                case 5:
                    System.out.println("Gracias por usar TraceIT.");
                    //Salir.
                    break;
                default:
                    System.out.println("Opcion invalida.");
                }
            }else{
                System.out.println("Su usuario esta bloqueado. Comuniquese con el equipo de TraceIT.");
            }
        }while (n != 5) ; //El menu se seguira inicializando hasta que n = 5, o sea, el usuario quiera salir.
    }
}