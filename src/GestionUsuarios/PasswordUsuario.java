package GestionUsuarios;

import util.Finder;
import util.Scanner;
import java.util.ArrayList;
//Verifica la contraseña.
public class PasswordUsuario {
    public static boolean passwordUsuario(String cuil, String celular, String contra, ArrayList<String[]> usuarios) {
        boolean passStart; //Crea un booleano, y busca la contraseña con el Finder.password.
        if (Finder.password(cuil, celular, contra, usuarios)) {
            passStart = true; //Si lo encuentra, devuelve true y termina el proceso de PasswordUsuario.
        } else {
            passStart = false;
            System.out.println("Incorrect password.");
            String contra2 = Scanner.getString("Password: "); //No lo encuentra, pide un nuevo string.
            passwordUsuario(cuil,celular,contra2,usuarios); //Recursion con el nuevo String.
        }
        return passStart; //Devuelve el booleano
    }
}
