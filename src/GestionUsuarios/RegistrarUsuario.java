package GestionUsuarios;
import Validadores.ContraValidador;
import util.Scanner;

public class RegistrarUsuario {
    public static void registrarUsuario() { //Si no lo encontro en la base de datos de TraceIT, le pedira una contraseña.
        String contra = Scanner.getString("Ingrese una contraseña: ");
        if(ContraValidador.contraValidador(contra)){ //Verifica que la contraseña cumple con los requisitos.
            //ESCRIBIR EN EL USUARIO.TXT
        }
        else{
            registrarUsuario(); //La contraseña no cumple con los requisitos, entonces repite el proceso.
        }

    }
}


