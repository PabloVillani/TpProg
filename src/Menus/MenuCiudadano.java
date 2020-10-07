package Menus;

import util.Scanner;

public class MenuCiudadano {
    public static void Menu() {
        int n = 0;
        do {
            System.out.println("1. Registrar contacto.\n2. Solicitudes. \n 3. Registrar Sintomas.\n 4.Dar de baja sintomas.\n 5. Centro de notificaciones \n6. Abrir mapa\n7. Cerrar sesion.");
            n = Scanner.getInt("Que operacion desea realizar?:");
            switch (n) {
                case 1:
                    //Registrar contacto.
                    break;
                case 2:
                    //Administrar solicitudes.
                    break;
                case 3:
                    //Registrar sintomas.
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
                    //Salir.
                    break;
                default:
                    System.out.println("Lo siento, eso no es una opcion valida. Intente con un numero del 1-7.");
            }
        } while (n != 7);
    }
}