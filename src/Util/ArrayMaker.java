package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Crea los diferentes ArrayList<String[]>
public class ArrayMaker {
    public ArrayMaker() {
    }

//    //-------------- Crea el ArrayList<String[]> de la base de datos de los archivos de tres valores.
//    public ArrayList<String[]> tripleStringMaker(String path) {
//        ArrayList<String[]> array = new ArrayList<String[]>();
//        String line; //Lee el txt.
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
//            String head = bufferedReader.readLine();
//            while ((line = bufferedReader.readLine()) != null) { //Hasta que la linea sea nula (o sea, sin texto)
//                String[] arr = line.split(","); //Copiara los datos en un String[]
//                array.add(arr);                  //Que luego agregara al  ArrayList<String[]>
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return array;
//    }

//    //-------------------- Crea el ArrayList<String[]> de la base de datos de 4 valores. -----------------------------
//    public ArrayList<String[]> fourValueStringMaker(String path) {
//        ArrayList<String[]> array = new ArrayList<String[]>();
//        String line; //Lee el txt
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
//            String head = bufferedReader.readLine();
//            while ((line = bufferedReader.readLine()) != null) { //Mientras que haya texto
//                String[] strings = line.split(",");     //Copiara los datos del txt a un String[]
//                array.add(strings);                       //Y los agrega al ArrayList<String[]>
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return array;
//    }

    //-------------- Crea el ArrayList<String[]> de la base de datos de los archivos de dos valores.
    public ArrayList<String[]> arrayListStringMaker(String path) {
        ArrayList<String[]> array = new ArrayList<String[]>();
        String line; //Lee el txt
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
            String head = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) { //Mientras que haya texto
                String[] strings = line.split(",");//Copiara los datos a un String[]
                array.add(strings);                           //Y los agrega al ArrayList<String[]>
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public List<String> singleStringMaker(String path) {
        List<String> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line); //Imprime la lista de String.
                line = br.readLine(); //lee la primer linea y despues pasa a la siguiente, si no hay más devuelve null, y se termina el while.
                list.add(line);//Crea el array de Strings.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
//    public ArrayList<String[]> quintupleStringMaker(String path) {
//        ArrayList<String[]> array = new ArrayList<String[]>();
//        String line; //Lee el txt
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
//            String head = bufferedReader.readLine();
//            while ((line = bufferedReader.readLine()) != null) { //Mientras que haya texto
//                String[] strings = line.split(",");//Copiara los datos a un String[]
//                array.add(strings);                           //Y los agrega al ArrayList<String[]>
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return array;
//    }

