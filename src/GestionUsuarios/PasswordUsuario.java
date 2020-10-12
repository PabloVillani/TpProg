package GestionUsuarios;

import util.Finder;
import util.Scanner;

import java.util.ArrayList;

public class PasswordUsuario {
    public static boolean passwordUsuario(String cuil, String celular, String contra, ArrayList<String[]> usuarios) {
        boolean passStart;
        if (Finder.password(cuil, celular, contra, usuarios)) {
            passStart = true;
        } else {
            passStart = false;
            System.out.println("Incorrect password.");
            String contra2 = Scanner.getString("Password: ");
            passwordUsuario(cuil,celular,contra2,usuarios);
        }
        return passStart;
    }
}
