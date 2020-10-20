package UserGestion;

import Util.*;
import Validators.CUILValidator;
import Validators.MobileValidator;
import Validators.PasswordValidator;

import java.util.ArrayList;

public class RegisterCitizen {
    public static void registerCitizen() {//Si no lo encontro en la base de datos de TraceIT, le pedira una contraseña.
        String cuil = Scanner.getString("CUIL: ");
        if (!CUILValidator.cuilValidator(cuil)) { //Valida que el CUIL cumpla con los requisitos
            registerCitizen(); //Recursion del inicio de sesion.
        }
        String mobile = Scanner.getString("Celular: ");
        if (!MobileValidator.mobileValidator(mobile)) { //Valida que el celular cumpla con los requisitos.
            registerCitizen(); //Recursion del inicio de sesion
        }
        String ubication = UbicationChooser.ubicationChooser();
        ArrayList<String[]> ANSESbase = ArrayMaker.ansesMaker(); //Crea el ArrayList<String[]> de la Base de datos del ANSES.
        if (Finder.tripleValueFinder(cuil, mobile, ubication, ANSESbase)) { //Busca el CUIL y el celular en la base de datos del ANSES.
            ArrayList<String[]> users = ArrayMaker.usuariosMaker(); //Crea el ArrayList<String[]> de Usuarios.
            if (Finder.tripleValueFinder(cuil, mobile, ubication, users)) { //Busca el CUIL y el celular en la base de datos de TraceIT.
                String password = Scanner.getString("Ingrese una contraseña: ");
                if (PasswordValidator.passwordValidator(password)) { //Verifica que la contraseña cumple con los requisitos.
                    Writer.userWriter(cuil, mobile, password, ubication); //Lo registra en la base de datos de Users.txt
                    Writer.singleValueWriter(cuil, "src/DataBase/ModificableBases/RejectedRequests.txt"); //Anota el CUIL en el RejectedRequests.txt
                    Writer.singleValueWriter(cuil, "src/DataBase/ModificableBases/UsersSymptoms.txt"); //Anota el CUIL en el UsersSymptoms.txt
                    Writer.twoValueWriter(cuil, "false", "src/DataBase/ModificableBases/BlockedUsers.txt");
                } else {
                    registerCitizen(); //La contraseña no cumple con los requisitos, entonces repite el proceso.
                }

            }
        }
    }
}




