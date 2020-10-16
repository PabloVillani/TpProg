package Menus;
import Citizen.Citizen;
import Util.Scanner;
public class CitizenMenu {
//Despliega el menu del ciudadano en el Main.
    public static void Menu(String cuil, String mobile) {
        int n = 0;
        Citizen c = new Citizen(cuil, mobile);
        do {
            System.out.println("1.Registrar Contacto.\n2. Solicitudes.\n3. Reportar sintomas.\n4. Dar de baja sintoma.\n5. Centro de notificaciones.\n6. Abrir sesion.\n7. Cerrar Sesion.");
            n = Scanner.getInt("What operation do you want to perform?:");
            switch (n) {
                case 1:
                    //Registra contacto con otro ciudadano
                    c.registerContact();
                    break;
                case 2:
                    //Administrar solicitudes.
                    break;
                case 3:
                    //Reporta un sintoma, y lo agrega al UsersSymptoms.txt
                    c.symptomsReport();
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
        } while (n != 7); //El menu se seguira inicializando hasta que n = 7, o sea, el usuario quiera salir.
    }
}