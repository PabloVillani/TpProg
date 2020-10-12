
import Menus.MenuAdmin;

import util.Scanner;
import GestionUsuarios.LoginUser;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido. Eres admin o ciudadano?:");
        int k = Scanner.getInt("1. Admin \n2. Ciudadano\n");
        if (k == 2) {
            LoginUser.loginUser();
        }
        if (k == 1) {
            String usuario = Scanner.getString("Usuario: ");
            String contra = Scanner.getString("Contraseña: ");
            MenuAdmin.Menu();
        }
        if(k != 1 && k != 2){
            System.out.println("Numero invalido.");
        }

    }


}
