import Ciudadano.Ciudadano;
import Menus.MenuAdmin;
import Menus.MenuCiudadano;
import util.Finder;
import util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import util.ArrayMaker;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido. Eres admin o ciudadano?:");
        int k = Scanner.getInt("1. Admin \n2. Ciudadano\n");
        if (k == 2) {
            String cuil = Scanner.getString("CUIL: ");
            String celular = Scanner.getString("Celular: ");
            ArrayList<String[]> baseANSES = ArrayMaker.ansesMaker();
            if(Finder.finder(cuil, celular, baseANSES)){
                ArrayList<String[]> usuarios = ArrayMaker.usuariosMaker();
                if (Finder.finder(cuil, celular, usuarios)) {
                    String contra = Scanner.getString("Password: ");
                }
                else{
                    System.out.println("No esta registrado.");
                    String contra = Scanner.getString("Enter a password: ");
                    
                }
            }
            else{
                System.out.println("El CUIL no esta registrado en el ANSES.");
            }
            MenuCiudadano.Menu(cuil, cuil, celular);
        }
        if (k == 1) {
            String usuario = Scanner.getString("Usuario: ");
            String contra = Scanner.getString("Contraseña: ");
            //Inicio sesion implementar
            MenuAdmin.Menu();
        }
        else{
            System.out.println("Numero invalido.");

        }

    }


}
