package GestionUsuarios;

import Menus.MenuCiudadano;
import util.ArrayMaker;
import util.Finder;
import util.Scanner;
import java.util.ArrayList;

public class LoginUser {
    public static void loginUser(String cuil, String celular) {
        ArrayList<String[]> baseANSES = ArrayMaker.ansesMaker();
        if (Finder.finder(cuil, celular, baseANSES)) {
            ArrayList<String[]> usuarios = ArrayMaker.usuariosMaker();
            if (Finder.finder(cuil, celular, usuarios)) {
                String contra = Scanner.getString("Password: ");
                PasswordUsuario.passwordUsuario(cuil, celular, contra, usuarios);
            }
            else {
                System.out.println("No esta registrado.");
                String contra = Scanner.getString("Enter a password: ");
            }
            MenuCiudadano.Menu(cuil, celular);
        } else {
            System.out.println("CUIL/Celular incorrecto.");
            String cuil2 = Scanner.getString("CUIL: ");
            String celular2 = Scanner.getString("Celular: ");
            loginUser(cuil2, celular2);
        }
    }
    public static void loginAdmin(String usuario,String password){

    }

}