package UserGestion;

import Util.Finder;
import Util.Scanner;
import java.util.ArrayList;
//Verifica la contraseña.
public class UserPassword {
    public static boolean userPassword(String cuil, String mobile, String password, String ubication, ArrayList<String[]> users) {
        boolean passStart; //Crea un booleano, y busca la contraseña con el Finder.password.
        if (Finder.password(cuil, mobile, password, ubication, users)) {
            passStart = true; //Si lo encuentra, devuelve true y termina el proceso de PasswordUsuario.
        } else {
            passStart = false;
            System.out.println("Contraseña incorrecta.");
            String secondPassword = Scanner.getString("Contraseña: "); //No lo encuentra, pide un nuevo string.
            userPassword(cuil,mobile,secondPassword, ubication, users); //Recursion con el nuevo String.
        }
        return passStart; //Devuelve el booleano
    }
}
