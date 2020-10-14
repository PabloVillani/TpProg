package GestionUsuarios;

import Menus.MenuCiudadano;
import Validadores.CUILValidador;
import Validadores.CeluValidador;
import util.ArrayMaker;
import util.Finder;
import util.Scanner;
import java.util.ArrayList;

public class LoginUser {
    public static void loginUser() {
        String cuil = Scanner.getString("CUIL: ");
        if(!CUILValidador.cuilValidador(cuil)){ //Valida que el CUIL cumpla con los requisitos
            loginUser(); //Recursion del inicio de sesion.
        }
        String celular = Scanner.getString("Celular: ");
        if(!CeluValidador.celuValidador(celular)){ //Valida que el celular cumpla con los requisitos.
            loginUser(); //Recursion del inicio de sesion
        }
        ArrayList<String[]> baseANSES = ArrayMaker.ansesMaker(); //Crea el ArrayList<String[]> de la Base de datos del ANSES.
        if (Finder.userFinder(cuil, celular, baseANSES)) { //Busca el CUIL y el celular en la base de datos del ANSES.
            ArrayList<String[]> usuarios = ArrayMaker.usuariosMaker(); //Crea el ArrayList<String[]> de Usuarios.
            if (Finder.userFinder(cuil, celular, usuarios)) { //Busca el CUIL y el celular en la base de datos de TraceIT.
                String contra = Scanner.getString("Password: "); //Si existe, le pide la contraseña.
                PasswordUsuario.passwordUsuario(cuil, celular, contra, usuarios); //Verifica la contraseña.
            }
            else {
                System.out.println("No esta registrado."); //Si no lo encuentra, le pide que se registre.
                RegistrarUsuario.registrarUsuario();
            }
            MenuCiudadano.Menu(cuil, celular); //Abre el Menu del ciudadano.
        } else {
            System.out.println("CUIL/Celular incorrecto."); //Si no se encuentra en la base ANSES, recursion del inicio de sesion.
            loginUser();
        }
    }
}