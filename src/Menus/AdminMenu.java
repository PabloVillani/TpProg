package Menus;

import Util.Scanner;

//Despliega el menu del administrador en el Main.
public class AdminMenu {
    public static void Menu() {
        int i = 0;
        do { //Presenta las opciones a realizar:
            System.out.println("1. Dar de alta sintoma.\n2. Cancel a Symptom\n 3. Modify Symptom\n4. Unblock User\n5. Close Session.");
            i = Scanner.getInt("What operation do you want to perform?:"); //Pregunta que opcion realizar
            switch (i) {
                case 1:
                    //Dar de alta sintoma.
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
                    System.out.println("Thanks for working whit TraceIT.");
                    //Salir.
                    break;
                default:
                    System.out.println("Invalid Option.");
                    break;
            }

        }while (i != 5); //No saldra del sistema hasta que introduzca el valor de 5.
    }
}