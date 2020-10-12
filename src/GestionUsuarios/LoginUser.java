package GestionUsuarios;

import Menus.MenuCiudadano;
import Validadores.CUILValidador;
import util.ArrayMaker;
import util.Finder;
import util.Scanner;
import java.util.ArrayList;

public class LoginUser {
    public static void loginUser() {
        String cuil = Scanner.getString("CUIL: ");
        if(!CUILValidador.cuilValidador(cuil)){
            loginUser();
        }
        String celular = Scanner.getString("Celular: ");
        ArrayList<String[]> baseANSES = ArrayMaker.ansesMaker();
        if (Finder.finder(cuil, celular, baseANSES)) {
            ArrayList<String[]> usuarios = ArrayMaker.usuariosMaker();
            if (Finder.finder(cuil, celular, usuarios)) {
                String contra = Scanner.getString("Password: ");
                PasswordUsuario.passwordUsuario(cuil, celular, contra, usuarios);
            }
            else {
                System.out.println("No esta registrado.");
                RegistrarUsuario.registrarUsuario();
            }
            MenuCiudadano.Menu(cuil, celular);
        } else {
            System.out.println("CUIL/Celular incorrecto.");
            loginUser();
        }
    }
}