package Menus;

import Citizen.Citizen;
import UserGestion.Blocker;
import Util.Scanner;

public class CitizenMenu {
    Scanner scanner = new Scanner();
    //Despliega el menu del ciudadano en el Main.
    public void Menu(Citizen c) {
        int n = 0;
        do {
            //Blocker.blocker(c);
            if (!c.isBlocked()) {
                System.out.println("1.Registrar Contacto.\n2. Solicitudes.\n3. Reportar sintomas.\n4. Dar de baja sintoma.\n5. Centro de notificaciones.\n6. Abrir sesion.\n7. Cerrar Sesion.");
                n = scanner.getInt("Elija la operacion a realizar: ");
                switch (n) {
                    case 1:
                        //Registra contacto con otro ciudadano
                        c.ContactRequest();
                        break;
                    case 2:
                        //Administrar solicitudes.
                        break;
                    case 3:
                        //Reporta un sintoma, y lo agrega al UsersSymptoms.txt
                        c.symptomsReport(c.cuil);
                        break;
                    case 4:
                        //Dar de baja sintomas.
                        break;
                    case 5:
                        //Centro de notificaciones.
                        break;
                    case 6:
                        //Abrir mapa.
                        break;
                    case 7:
                        System.out.println("Gracias por usar TraceIT.");
                        //Salir.
                        break;
                    default:
                        System.out.println("Opcion invalida.");
                }
            }else{
                System.out.println("Su usuario esta bloqueado. Comuniquese con el equipo de TraceIT.");
            }
        }while (n != 7) ; //El menu se seguira inicializando hasta que n = 7, o sea, el usuario quiera salir.
    }
}