package Menus;

import Citizen.Citizen;
import EventsGestion.NotificateSymptomAtoB;
import UserGestion.Blocker;
import UserGestion.ConfirmContact;
import Util.Scanner;

public class CitizenMenu {
    Scanner scanner = new Scanner();
    Blocker blocker = new Blocker();
    ConfirmContact confirmContact = new ConfirmContact();
    NotificateSymptomAtoB notificateSymptomAtoB = new NotificateSymptomAtoB();
    //Despliega el menu del ciudadano en el Main.
    public void Menu(Citizen c){
        int n = 0;
        do {
            blocker.blocker(c);
            confirmContact.confirmContact(c);
            notificateSymptomAtoB.notificateSymptomAtoB(c);
            if (!c.isBlocked()) {
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
        }while (n != 5) ; //El menu se seguira inicializando hasta que n = 7, o sea, el usuario quiera salir.
    }
}