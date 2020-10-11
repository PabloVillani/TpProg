import Menus.MenuAdmin;
import Menus.MenuCiudadano;
import util.Scanner;
import java.io.*;
import BaseDeDatos.Usuarios;
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido. Eres admin o ciudadano?:");
        int k = Scanner.getInt("1. Admin \n2. Ciudadano");
        if (k == 2) {
            String cuil = Scanner.getString("CUIL: ");
            String contra = Scanner.getString("Contraseña: ");
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(Usuarios.txt)));
            MenuCiudadano.Menu();
        }
        if (k == 1) {
            String usuario = Scanner.getString("Usuario: ");
            String contra = Scanner.getString("Contraseña: ");
            //Inicio sesion implementar
            MenuAdmin.Menu();
        }
        else{
            System.out.println("Numero invalido.");
            new Main();
        }

    }
}
