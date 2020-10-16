package UserGestion;

import Util.Writers.UserSymptomCUILRegister;
import Util.Writers.UserWriter;
import Validators.PasswordValidator;
import Util.Scanner;

public class RegisterUser {
    public static void RegisterUser(String cuil, String mobile, String ubication) { //Si no lo encontro en la base de datos de TraceIT, le pedira una contraseña.
        String password = Scanner.getString("Ingrese una contraseña: ");
        if (PasswordValidator.passwordValidator(password)) { //Verifica que la contraseña cumple con los requisitos.
            UserSymptomCUILRegister.CuilWriter(cuil);
            UserWriter.userWriter(cuil, mobile, password, ubication); //Lo registra en la base de datos de Users.txt
        } else {
            RegisterUser(cuil, mobile, ubication); //La contraseña no cumple con los requisitos, entonces repite el proceso.
        }

    }
}




