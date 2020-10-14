package Menus;
import Citizen.Citizen;
import Util.Scanner;
public class CitizenMenu {
//Despliega el menu del ciudadano en el Main.
    public static void Menu(String cuil, String celular) {
        int n = 0;
        Citizen c = new Citizen(cuil, celular);
        do {
            System.out.println("1. Registrar contacto.\n2. Solicitudes. \n3. Registrar Sintomas.\n4.Dar de baja sintomas.\n5. Centro de notificaciones \n6. Abrir mapa\n7. Cerrar sesion.");
            n = Scanner.getInt("Que operacion desea realizar?:");
            switch (n) {
                case 1:
                    //Registra contacto con otro ciudadano
                    c.registrarContacto();
                    break;
                case 2:
                    //Administrar solicitudes.
                    break;
                case 3:
                    //Reporta un sintoma, y lo agrega al UsersSymptoms.txt
                    c.reportarSintomas();
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
                    System.out.println("Lo siento, eso no es una opcion valida. Intente con un numero del 1-7.");
            }
        } while (n != 7); //El menu se seguira inicializando hasta que n = 7, o sea, el usuario quiera salir.
    }
}