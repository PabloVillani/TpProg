package Menus;
import util.Scanner;
import Ciudadano.Ciudadano;
import java.io.*;
public class MenuAdmin {
    public static void Menu() {
        int i = 0;
        do {
            System.out.println("1. Dar de alta sintoma.\n2. Dar de baja\n 3. Modificar sintomas\n4. Desbloquear usuario\n5. Cerrar sesion.");
            i = Scanner.getInt("Que operacion desea realizar?:");
            switch (i) {
                case 1:
                    //Dar de alta sintoma
                    break;
                case 2:
                    //Dar de baja sintoma
                    break;
                case 3:
                    //Modificar sintomas.
                    break;
                case 4:
                    //Desbloquear usuario.
                    break;
                case 5:
                    //Salir.
                    break;
                default:
                    System.out.println("invalido.");
                    break;
            }

        }while (i != 5) ;
    }
}