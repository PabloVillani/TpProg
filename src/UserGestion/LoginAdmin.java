package UserGestion;

import Menus.AdminMenu;
import Util.ArrayMaker;
import Util.Finder;
import Util.Scanner;
import java.util.ArrayList;

public class LoginAdmin {
    AdminMenu menu = new AdminMenu();
    ArrayMaker arrayMaker = new ArrayMaker();
    Scanner scanner = new Scanner();
    Finder finder = new Finder();
    public void loginAdmin(){
        ArrayList<String[]> admins = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/Admins.txt");
        String user = scanner.getString("Usuario: ");
        String password = scanner.getString("Contraseña: ");
        if(finder.doubleValueFinder(user,password,admins)){ //Busca el usuario y la contraseña en el  ArrayList<String[]> admins.
            menu.Menu(); //Si se encuentra, se ejecuta el menu.
        }
        else{
            System.out.println("El usuario o la contraseña es incorrecta.");
            loginAdmin(); //Recursion para que pueda iniciar sesion.
        }
    }

}
