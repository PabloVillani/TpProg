package UserGestion;

import Util.Scanner;
import Validators.PasswordValidator;
import Util.Writer;

public class RegisterCitizen {
    public static void RegisterUser(String cuil, String mobile, String ubication) { //Si no lo encontro en la base de datos de TraceIT, le pedira una contraseña.
        String password = Scanner.getString("Ingrese una contraseña: ");
        if (PasswordValidator.passwordValidator(password)) { //Verifica que la contraseña cumple con los requisitos.
            Writer.userWriter(cuil, mobile, password, ubication); //Lo registra en la base de datos de Users.txt
            Writer.singleValueWriter(cuil,"src/DataBase/ModificableBases/RejectedRequests.txt"); //Anota el CUIL en el RejectedRequests.txt
            Writer.singleValueWriter(cuil,"src/DataBase/ModificableBases/UsersSymptoms.txt"); //Anota el CUIL en el UsersSymptoms.txt
            Writer.twoValueWriter(cuil,"false","src/DataBase/ModificableBases/BlockedUsers.txt");
        } else {
            RegisterUser(cuil, mobile, ubication); //La contraseña no cumple con los requisitos, entonces repite el proceso.
        }

    }
}




