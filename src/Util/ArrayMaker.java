package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Crea los diferentes ArrayList<String[]>
public class ArrayMaker {
    //-------------- Crea el ArrayList<String[]> de la base de datos de los archivos de tres valores.
    public static ArrayList<String[]> tripleStringMaker(String path) {
        ArrayList<String[]> ANSESbase = new ArrayList<String[]>();
        String line; //Lee el txt.
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
            String head = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) { //Hasta que la linea sea nula (o sea, sin texto)
                String[] citizen = line.split(","); //Copiara los datos en un String[]
                ANSESbase.add(citizen);                  //Que luego agregara al  ArrayList<String[]>
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ANSESbase;
    }

    //-------------------- Crea el ArrayList<String[]> de la base de datos de usuarios de TraceIT. -----------------------------
    public static ArrayList<String[]> usuariosMaker() {
        ArrayList<String[]> users = new ArrayList<String[]>();
        String line; //Lee el Users.txt
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/DataBase/ModificableBases/Users.txt"));) {
            String head = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) { //Mientras que haya texto
                String[] user = line.split(",");     //Copiara los datos de los usuarios a un String[]
                users.add(user);                       //Y los agrega al ArrayList<String[]>
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    //-------------- Crea el ArrayList<String[]> de la base de datos de los archivos de dos valores.
    public static ArrayList<String[]> doubleStringMaker(String path) {
        ArrayList<String[]> array = new ArrayList<String[]>();
        String line; //Lee el txt
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
            String head = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) { //Mientras que haya texto
                String[] strings = line.split(",");//Copiara los datos de los usuarios a un String[]
                array.add(strings);                           //Y los agrega al ArrayList<String[]>
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static List<String> singleStringMaker(String path) {
        List<String> symptoms = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line); //Imprime la lista de String.
                line = br.readLine(); //lee la primer linea y despues pasa a la siguiente, si no hay más devuelve null, y se termina el while.
            }
            symptoms.add(line);//Crea el array de Strings.
        } catch (IOException e) {
            e.printStackTrace();
        }
        return symptoms;
    }

}
