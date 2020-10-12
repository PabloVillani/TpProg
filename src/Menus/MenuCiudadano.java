package Menus;
import Ciudadano.Ciudadano;
import util.Scanner;
public class MenuCiudadano {

    public static void Menu(String contra, String cuil, String celular) {
        int n = 0;
        Ciudadano c = new Ciudadano(cuil, celular);
        do {
            System.out.println("1. Registrar contacto.\n2. Solicitudes. \n3. Registrar Sintomas.\n4.Dar de baja sintomas.\n5. Centro de notificaciones \n6. Abrir mapa\n7. Cerrar sesion.");
            n = Scanner.getInt("Que operacion desea realizar?:");
            switch (n) {
                case 1:
                    c.registrarContacto();
                    System.out.println("");
                    break;
                case 2:
                    //Administrar solicitudes.
                    break;
                case 3:
                    c.reportarSintomas();
                    break;
                case 4:

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
        } while (n != 7);
    }
}