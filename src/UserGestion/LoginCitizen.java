package UserGestion;

import Citizen.Citizen;
import EventsGestion.Location;
import Menus.CitizenMenu;
import Validators.CUILValidator;
import Validators.MobileValidator;
import Util.ArrayMaker;
import Util.Finder;
import Util.Scanner;
import java.util.ArrayList;

public class LoginCitizen {
    CitizenMenu menu = new CitizenMenu();
    Scanner scanner = new Scanner();
    Location location = new Location();
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    RegisterCitizen registerCitizen = new RegisterCitizen();
    public void loginCitizen() {
        String cuil = scanner.getString("CUIL: ");
        if (!CUILValidator.cuilValidator(cuil)) { //Valida que el CUIL cumpla con los requisitos
            loginCitizen(); //Recursion del inicio de sesion.
        }
        String mobile = scanner.getString("Celular: ");
        if (!MobileValidator.mobileValidator(mobile)) { //Valida que el celular cumpla con los requisitos.
            loginCitizen(); //Recursion del inicio de sesion
        }
        String ubication = location.locationChooser();
        ArrayList<String[]> ANSESbase = arrayMaker.tripleStringMaker("src/DataBase/PreexistingBases/ANSESBase.txt"); //Crea el ArrayList<String[]> de la Base de datos del ANSES.
        if (finder.tripleValueFinder(cuil, mobile, ubication, ANSESbase)) { //Busca el CUIL y el celular en la base de datos del ANSES.
            ArrayList<String[]> users = arrayMaker.usuariosMaker(); //Crea el ArrayList<String[]> de Usuarios.
            if (finder.tripleValueFinder(cuil, mobile, ubication, users)) { //Busca el CUIL y el celular en la base de datos de TraceIT.
                String password = scanner.getString("Contraseña: "); //Si existe, le pide la contraseña.
                userPassword(cuil, mobile, password, ubication, users); //Verifica la contraseña.
            } else {
                System.out.println("No esta registrado."); //Si no lo encuentra, le pide que se registre.
                registerCitizen.registerCitizen();
            }
            System.out.println("Bienvenido.");
            Citizen c = new Citizen(cuil, mobile);
            menu.Menu(c); //Abre el Menu del ciudadano.
        } else {
            System.out.println("CUIL/Celular/Ubicacion incorrecto."); //Si no se encuentra en la base ANSES, recursion del inicio de sesion.
            loginCitizen();
        }
    }

    public boolean userPassword(String cuil, String mobile, String password, String ubication, ArrayList<String[]> users) {
        boolean passStart; //Crea un booleano, y busca la contraseña con el Finder.fourValueFinder.
        if (finder.fourValueFinder(cuil, mobile, password, ubication, users)) {
            passStart = true; //Si lo encuentra, devuelve true y termina el proceso de PasswordUsuario.
        } else {
            passStart = false;
            System.out.println("Contraseña incorrecta.");
            String secondPassword = scanner.getString("Contraseña: "); //No lo encuentra, pide un nuevo string.
            userPassword(cuil, mobile, secondPassword, ubication, users); //Recursion con el nuevo String.
        }
        return passStart; //Devuelve el booleano
    }
}