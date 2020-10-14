

import UserGestion.LoginAdmin;
import Util.Scanner;
import UserGestion.LoginUser;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido. Eres admin o ciudadano?:");
        int k = Scanner.getInt("1. Admin.Admin \n2. Ciudadano\n"); //Le pide que elija un inicio de sesion.
        if (k == 2) {
            LoginUser.loginUser(); //Corre el codigo para que un usuario inicie sesion.
        }
        if (k == 1) {
            LoginAdmin.loginAdmin(); //Corre el codigo para que un admin inicie sesion.
        }
        if(k != 1 && k != 2){
            System.out.println("Numero invalido.");
            Main.main(args); //Corre el main de vuelta.
        }

    }


}
