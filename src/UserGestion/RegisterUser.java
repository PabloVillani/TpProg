package UserGestion;

import Util.ArrayMaker;
import Validators.PasswordValidator;
import Util.Scanner;
import java.util.List;

public class RegisterUser {
    public static void RegisterUser() { //Si no lo encontro en la base de datos de TraceIT, le pedira una contraseña.
        String password = Scanner.getString("Ingrese una contraseña: ");
        if (PasswordValidator.passwordValidator(password)) { //Verifica que la contraseña cumple con los requisitos.
            String ubication = ubicationChooser(); //Pide la ubicacion
            //ANOTA AL USUARIO EN USERS.TXT
            //ANOTAR SOLO EL CUIL EN EL USERSYMPTOMS.TXT
        } else {
            RegisterUser(); //La contraseña no cumple con los requisitos, entonces repite el proceso.
        }

    }

    public static String ubicationChooser() {
        List<String> ubications = ArrayMaker.ubicationMaker();
        System.out.println();
        String linea = "";
        int i = Scanner.getInt("Elija su ubicacion.");
        if (i < 0 || i > 5) {
            System.out.println("Numero Invalido."); //Recursion en caso de ingresar un numero invalido.
            ubicationChooser();
        } else {
            if (i == 1) {
                linea = "Escobar";
            }
            if (i == 2) {
                linea = "Gral. Rodriguez";
            }
            if (i == 3) {
                linea = "Pilar";
            }
            if (i == 4) {
                linea = "Tigre";
            }
            if (i == 5) {
                linea = "Zarate";
            }
        }
        return linea;
    }
}


