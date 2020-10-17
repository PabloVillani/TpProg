package UserGestion;

import Citizen.Citizen;
import Menus.CitizenMenu;
import Util.UbicationChooser;
import Validators.CUILValidator;
import Validators.MobileValidator;
import Util.ArrayMaker;
import Util.Finder;
import Util.Scanner;
import java.util.ArrayList;

public class LoginUser {
    public static void loginUser() {
        String cuil = Scanner.getString("CUIL: ");
        if(!CUILValidator.cuilValidator(cuil)){ //Valida que el CUIL cumpla con los requisitos
            loginUser(); //Recursion del inicio de sesion.
        }
        String mobile = Scanner.getString("Celular: ");
        if(!MobileValidator.mobileValidator(mobile)){ //Valida que el celular cumpla con los requisitos.
            loginUser(); //Recursion del inicio de sesion
        }
        String ubication = UbicationChooser.ubicationChooser();
        ArrayList<String[]> ANSESbase = ArrayMaker.ansesMaker(); //Crea el ArrayList<String[]> de la Base de datos del ANSES.
        if (Finder.tripleValueFinder(cuil, mobile, ubication, ANSESbase)) { //Busca el CUIL y el celular en la base de datos del ANSES.
            ArrayList<String[]> users = ArrayMaker.usuariosMaker(); //Crea el ArrayList<String[]> de Usuarios.
            if (Finder.tripleValueFinder(cuil, mobile, ubication, users)) { //Busca el CUIL y el celular en la base de datos de TraceIT.
                String password = Scanner.getString("Contraseña: "); //Si existe, le pide la contraseña.
                UserPassword.userPassword(cuil, mobile, password, ubication, users); //Verifica la contraseña.
            }
            else {
                System.out.println("No esta registrado."); //Si no lo encuentra, le pide que se registre.
                RegisterUser.RegisterUser(cuil, mobile, ubication);
            }
            System.out.println("Bienvenido.");
            Citizen c = new Citizen(cuil, mobile);
            CitizenMenu.Menu(c); //Abre el Menu del ciudadano.
        } else {
            System.out.println("CUIL/Celular/Ubicacion incorrecto."); //Si no se encuentra en la base ANSES, recursion del inicio de sesion.
            loginUser();
        }
    }
}