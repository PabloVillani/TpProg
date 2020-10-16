package UserGestion;

import Menus.AdminMenu;
import Util.ArrayMaker;
import Util.Finder;
import Util.Scanner;
import java.util.ArrayList;

public class LoginAdmin {
    public static void loginAdmin(){
        ArrayList<String[]> admins = ArrayMaker.adminsMaker();
        String user = Scanner.getString("Usuario: ");
        String password = Scanner.getString("Contraseña: ");
        if(Finder.adminFinder(user,password,admins)){ //Busca el usuario y la contraseña en el  ArrayList<String[]> admins.
            AdminMenu.Menu(); //Si se encuentra, se ejecuta el menu.
        }
        else{
            System.out.println("El usuario o la contraseña es incorrecta.");
            loginAdmin(); //Recursion para que pueda iniciar sesion.
        }
    }

}
