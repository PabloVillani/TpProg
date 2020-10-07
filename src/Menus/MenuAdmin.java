package Menus;

import util.Scanner;

public class MenuAdmin {
    public static void Menu() {
        int i = 0;
        do {
            System.out.println("1. Dar de alta sintoma.\n2. Dar de baja\n 3. Modificar sintomas\n4. Desbloquear usuario\n5. Cerrar sesion.");
            i = Scanner.getInt("Que operacion desea realizar?:");
            switch (i) {
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
                default:
                    System.out.println("invalido.");
                    break;
            }

        }while (i != 5) ;
    }
}