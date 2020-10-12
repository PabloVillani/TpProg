package GestionUsuarios;
import Validadores.ContraValidador;
import util.Scanner;

public class RegistrarUsuario {
    public static void registrarUsuario() {
        String contra = Scanner.getString("Ingrese una contraseña: ");
        if(ContraValidador.contraValidador(contra)){
            //ESCRIBIR EN EL USUARIO.TXT
        }
        else{
            registrarUsuario();
        }

    }
}


