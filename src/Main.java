

import UserGestion.LoginAdmin;
import UserGestion.RegisterCitizen;
import Util.Scanner;
import UserGestion.LoginCitizen;

public class Main {
    public static void main(String[] args) {
        int o = Scanner.getInt("Bienvenido a TraceIt: \n 1. Iniciar sesión. \n 2. Registrarse. \n");
        if (o == 1) {
            System.out.println("Bienvenido. Eres Admin o Ciudadano:");
            int k = Scanner.getInt("1. Admin \n2. Ciudadano\n"); //Le pide que elija un inicio de sesion.
            int a = chooser(k);
            if (a == 2) {
                LoginCitizen.loginCitizen(); //Corre el codigo para que un usuario inicie sesion.
            }
            if (a == 1) {
                LoginAdmin.loginAdmin(); //Corre el codigo para que un admin inicie sesion.
            }
        }
        if(o == 2){
            RegisterCitizen.registerCitizen();
        }
    }
    public static int chooser(int k){
        int a;
        if (k != 1 && k != 2) {
            System.out.println("Numero Invalido.");
            System.out.println("Bienvenido. Eres Admin o Ciudadano:");
            a = Scanner.getInt("1. Admin \n2. Ciudadano\n");
            chooser(a);
        }else{
            a = k;
        }
        return a;
    }
}
