package UserGestion;

import Citizen.Citizen;
import EventsGestion.Location;
import Menus.CitizenMenu;
import Util.*;
import Validators.CUILValidator;
import Validators.MobileValidator;
import Validators.PasswordValidator;

import java.util.ArrayList;

public class RegisterCitizen {
    Writer writer = new Writer();
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    CitizenMenu menu = new CitizenMenu();
    Scanner scanner = new Scanner();
    Location location = new Location();

    public void registerCitizen() {//Si no lo encontro en la base de datos de TraceIT, le pedira una contraseña.
        String cuil = scanner.getString("CUIL: ");
        if (!CUILValidator.cuilValidator(cuil)) { //Valida que el CUIL cumpla con los requisitos
            registerCitizen(); //Recursion del inicio de sesion.
        }
        String mobile = scanner.getString("Celular: ");
        if (!MobileValidator.mobileValidator(mobile)) { //Valida que el celular cumpla con los requisitos.
            registerCitizen(); //Recursion del inicio de sesion
        }
        String ubication = location.locationChooser();
        ArrayList<String[]> ANSESbase = arrayMaker.tripleStringMaker("src/DataBase/PreexistingBases/ANSESBase.txt"); //Crea el ArrayList<String[]> de la Base de datos del ANSES.
        if (finder.tripleValueFinder(cuil, mobile, ubication, ANSESbase)) { //Busca el CUIL y el celular en la base de datos del ANSES.
            ArrayList<String[]> users = arrayMaker.usuariosMaker(); //Crea el ArrayList<String[]> de Usuarios.
            if (!finder.tripleValueFinder(cuil, mobile, ubication, users)) { //Busca el CUIL y el celular en la base de datos de TraceIT.
                String password = scanner.getString("Ingrese una contraseña: ");
                if (PasswordValidator.passwordValidator(password)) { //Verifica que la contraseña cumple con los requisitos.
                    writer.fourValueWriter(cuil, mobile, password, ubication,"src/DataBase/ModificableBases/Users.txt"); //Lo registra en la base de datos de Users.txt
                    writer.twoValueWriter(cuil,"0","src/DataBase/ModificableBases/RejectedRequests.txt"); //Anota el CUIL en el RejectedRequests.txt
                    writer.singleValueWriter(cuil,"src/DataBase/ModificableBases/UsersSymptoms.txt"); //Anota el CUIL en el UsersSymptoms.txt
                    writer.singleValueWriter(cuil,"src/DataBase/ModificableBases/UserSymptomHistory.txt");
                    writer.singleValueWriter(cuil,"src/DataBase/ModificableBases/CuilOnlyDataBase.txt");
                    writer.twoValueWriter(cuil,"false","src/DataBase/ModificableBases/BlockedUsers.txt");
                    Citizen c = new Citizen(cuil,mobile);
                    menu.Menu(c);
                } else {
                    registerCitizen(); //La contraseña no cumple con los requisitos, entonces repite el proceso.
                }

            }
            else{
                System.out.println("Esta cuenta ya existe.");
                String password = scanner.getString("Ingrese una contraseña: ");
                if(userPassword(cuil,mobile,password,ubication,users)){
                    Citizen c = new Citizen(cuil,mobile);
                    menu.Menu(c);
                }
            }

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




