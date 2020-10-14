package UserGestion;

import Util.Finder;
import Util.Scanner;
import java.util.ArrayList;
//Verifica la contraseña.
public class UserPassword {
    public static boolean userPassword(String cuil, String mobile, String password, ArrayList<String[]> users) {
        boolean passStart; //Crea un booleano, y busca la contraseña con el Finder.password.
        if (Finder.password(cuil, mobile, password, users)) {
            passStart = true; //Si lo encuentra, devuelve true y termina el proceso de PasswordUsuario.
        } else {
            passStart = false;
            System.out.println("Incorrect password.");
            String secondPassword = Scanner.getString("Password: "); //No lo encuentra, pide un nuevo string.
            userPassword(cuil,mobile,secondPassword,users); //Recursion con el nuevo String.
        }
        return passStart; //Devuelve el booleano
    }
}
