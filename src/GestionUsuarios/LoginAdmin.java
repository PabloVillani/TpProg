package GestionUsuarios;

import Menus.MenuAdmin;
import util.ArrayMaker;
import util.Finder;
import util.Scanner;
import java.util.ArrayList;

public class LoginAdmin {
    public static void loginAdmin(){
        ArrayList<String[]> admins = ArrayMaker.adminsMaker();
        String usuario = Scanner.getString("Usuario: ");
        String contra = Scanner.getString("Password: ");
        if(Finder.adminFinder(usuario,contra,admins)){ //Busca el usuario y la contraseña en el  ArrayList<String[]> admins.
            MenuAdmin.Menu(); //Si se encuentra, se ejecuta el menu.
        }
        else{
            System.out.println("El usuario o la contraseña es incorrecta.");
            loginAdmin(); //Recursion para que pueda iniciar sesion.
        }
    }

}
