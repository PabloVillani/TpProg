package UserGestion;
import Validators.PasswordValidator;
import Util.Scanner;

public class RegisterUser {
    public static void registrarUsuario() { //Si no lo encontro en la base de datos de TraceIT, le pedira una contraseña.
        String contra = Scanner.getString("Ingrese una contraseña: ");
        if(PasswordValidator.contraValidador(contra)){ //Verifica que la contraseña cumple con los requisitos.
            //ESCRIBIR EN EL USUARIO.TXT
        }
        else{
            registrarUsuario(); //La contraseña no cumple con los requisitos, entonces repite el proceso.
        }

    }
}


