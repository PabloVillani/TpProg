package UserGestion;
import Validators.PasswordValidator;
import Util.Scanner;

public class RegisterUser {
    public static void RegisterUser() { //Si no lo encontro en la base de datos de TraceIT, le pedira una contraseña.
        String password = Scanner.getString("Enter a password: ");
        if(PasswordValidator.passwordValidator(password)){ //Verifica que la contraseña cumple con los requisitos.
            //ESCRIBIR EN EL USUARIO.TXT
        }
        else{
            RegisterUser(); //La contraseña no cumple con los requisitos, entonces repite el proceso.
        }

    }
}


