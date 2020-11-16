package Menus;

import Citizen.Citizen;
import Events.Outbreak;
import Events.Symptom;
import EventsGestion.Location;
import EventsGestion.NotificateSymptomAtoB;
import EventsGestion.PossibleDiseases;
import EventsGestion.StatsManager;
import Exceptions.InputException;
import UserGestion.Blocker;
import UserGestion.ConfirmContact;
import Util.ArrayMaker;
import Util.DateManager;
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
    DateManager dm = new DateManager();
    StatsMenu statsMenu = new StatsMenu();
    ArrayList<String[]> citizensStrings = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/Users.txt");
    ArrayList<Citizen> citizens = arrayMaker.stringsToCitizen(citizensStrings);
    List<String> symptomsStrings = arrayMaker.singleStringMaker("src/DataBase/PreexistingBases/SymptomsBase.txt");
    ArrayList<Symptom> symptoms = arrayMaker.stringToSymptoms(symptomsStrings);

    //Despliega el menu del ciudadano en el Main.
    //Funciona tambien para correr repetidas veces diferentes codigos que pueden cambiar dependiendo del tiempo
    public void Menu(Citizen c) {
        c.yourSymptomsBegin();
        blocker.blocker(c);
        if (!c.isBlocked()) {
            for (int i = 0; i < citizens.size(); i++) {
                for (int j = 0; j < symptoms.size(); j++) {
                    Outbreak outbreak = statsManager.possibleOutbreak(citizens.get(i), citizens.get(i).getCitizenLocation(), symptoms.get(j));
                }
            }
            ArrayList<String[]> outbreaks = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/OutbreaksInLocation/Outbreaks" + c.getCitizenLocation().getName() + ".txt");
            for (int i = 0; i < outbreaks.size(); i++) {
                String[] line = outbreaks.get(i);
                Outbreak outbreak = new Outbreak(new Symptom(line[0]), Integer.parseInt(line[1]), new Location(line[2]), dm.stringToDate(line[3]));
                System.out.println("\n");
                System.out.println("BROTE REPORTADO!\nSINTOMA: " + outbreak.getSymptom().getName() + "\nCIUDADANOS AFECTADOS: " + outbreak.getCitizensInvolved() + "\nUBICACION: " + outbreak.getLocation().getName() + "\nFecha reportado: " + dm.dateToString(outbreak.getDate()));
            }
            int n = 0;
            do {
                confirmContact.confirmContact(c);
                notificateSymptomAtoB.notificateSymptomAtoB(c);
                possibleDiseases.possibleDiseases(c);
                System.out.println("1.Registrar Contacto.\n2. Reportar sintomas\n3. Dar de baja sintoma. \n4. Ver mis sintomas\n5. Estadisticas\n6. Cerrar Sesion.");
                n = scanner.getInt("Elija la operacion a realizar: ");
                switch (n) {
                    case 1:
                        //Registra contacto con otro ciudadano
                        c.ContactRequest();
                        break;
                    case 2:
                        //Reporta un sintoma, y lo agrega al UsersSymptoms.txt
                        c.symptomsReport();
                        for (int j = 0; j < citizens.size(); j++) {
                            for (int k = 0; k < symptoms.size(); k++) {
                                Outbreak outbreak = statsManager.possibleOutbreak(citizens.get(j), citizens.get(j).getCitizenLocation(), symptoms.get(k));
                            }
                        }
                        ArrayList<String[]> outbreaks2 = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/OutbreaksInLocation/Outbreaks" + c.getCitizenLocation().getName() + ".txt");
                        for (int l = 0; l < outbreaks2.size(); l++) {
                            String[] line3 = outbreaks2.get(l);
                            Outbreak outbreak = new Outbreak(new Symptom(line3[0]), Integer.parseInt(line3[1]), new Location(line3[2]), dm.stringToDate(line3[3]));
                            System.out.println("BROTE REPORTADO!\nSINTOMA: " + outbreak.getSymptom().getName() + "\nCIUDADANOS AFECTADOS: " + outbreak.getCitizensInvolved() + "\nUBICACION: " + outbreak.getLocation().getName() + "\nFecha reportado: " + dm.dateToString(outbreak.getDate()));
                        }
                        break;
                    case 3:
                        //Dar de baja sintomas.
                        c.solveSymptoms();
                        break;
                    case 4:
                        //Mostrar los sintomas del usuario
                        System.out.println("Estos son sus sintomas:");
                        c.yourSymptoms();
                        break;
                    case 5:
                        //Estadisticas
                        statsMenu.Menu(c.getCitizenLocation());
                        break;
                    case 6:
                        System.out.println("Gracias por usar TraceIT.");
                        //Salir.
                        break;
                    default:
                        try {
                            throw new InputException(81);
                        } catch (InputException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            } while (n != 6); //El menu se seguira inicializando hasta que n = 5, o sea, el usuario quiera salir.
        }else{
            System.out.println("Su usuario esta bloqueado. Comuniquese con el equipo de TraceIT.");
            System.exit(0);
        }
    }
}