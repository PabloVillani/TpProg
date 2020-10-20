package Menus;

import Util.Scanner;

//Despliega el menu del administrador en el Main.
public class AdminMenu {
    public static void Menu() {
        int i = 0;
        do { //Presenta las opciones a realizar:
            System.out.println("1. Dar de alta sintoma.\n2. Dar de baja un sintoma\n 3. Modificar sintomas\n4. Desbloquear usuario\n5. Cerrar sesion.");
            i = Scanner.getInt("Que operacion desea realizar?:"); //Pregunta que opcion realizar
            switch (i) {
                case 1:
                    //Notificar sintoma.
                    break;
                case 2:
                    //Dar de baja sintoma.
                    break;
                case 3:
                    //Modificar sintomas.
                    break;
                case 4:
                    //Desbloquear usuario.
                    break;
                case 5:
                    System.out.println("Gracias por usar TraceIT.");
                    //Salir.
                    break;
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        }while (i != 5); //No saldra del sistema hasta que introduzca el valor de 5.
    }
}