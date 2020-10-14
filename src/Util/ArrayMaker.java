package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//Crea los diferentes ArrayList<String[]>
public class ArrayMaker {
//------------------------------Crea el ArrayList<String[]> del ANSES -----------------------------------------
    public static ArrayList<String[]> ansesMaker() {
        ArrayList<String[]> ANSESbase = new ArrayList<String[]>();
        String line; //Lee la ANSESBase.txt
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/BaseDeDatos/BasesPreexistentes/ANSESBase.txt"));){
            String head = bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null){ //Hasta que la linea sea nula (o sea, sin texto)
                String[] citizen = line.split(","); //Copiara los ciudadanos en un String[]
                ANSESbase.add(citizen);                  //Que luego agregara al  ArrayList<String[]> del ANSES.
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return ANSESbase;
    }

//-------------------- Crea el ArrayList<String[]> de la base de datos de usuarios de TraceIT. -----------------------------
    public static ArrayList<String[]> usuariosMaker(){
        ArrayList<String[]> users = new ArrayList<String[]>();
        String line; //Lee el Users.txt
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/BaseDeDatos/BasesModificables/Users.txt"));){
            String head = bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null){ //Mientras que haya texto
                String[] user = line.split(",");     //Copiara los datos de los usuarios a un String[]
                users.add(user);                       //Y los agrega al ArrayList<String[]>
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return users;
    }

//-------------- Crea el ArrayList<String[]> de la base de datos de los administradores de TraceIT.
    public static ArrayList<String[]> adminsMaker() {
        ArrayList<String[]> admins = new ArrayList<String[]>();
        String line; //Lee el Admins.txt
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/BaseDeDatos/BasesModificables/Admins.txt"));){
            String head = bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null){ //Mientras que haya texto
                String[] admin = line.split(",");       //Copiara los datos de los usuarios a un String[]
                admins.add(admin);                           //Y los agrega al ArrayList<String[]>
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return admins;
    }
}
