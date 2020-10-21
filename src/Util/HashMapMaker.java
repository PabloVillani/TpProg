//package Util;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//
//public class HashMapMaker {
//    public static HashMap<String, String> cuilAndSymptomsMaker(String path) {
//        HashMap<String, String> cuilAndSymptoms = new HashMap<String, String>();
//        String line; //Lee el txt.
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
//            String head = bufferedReader.readLine();
//            while ((line = bufferedReader.readLine()) != null) { //Hasta que la linea sea nula (o sea, sin texto)
//                String cuil = head.substring(0, ); //Copiara los datos en un String[]
//                String[] symptoms = line.split(",");
//                cuilAndSymptoms.put(cuil, symptoms);                  //Que luego agregara al  ArrayList<String[]>
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return cuilAndSymptoms;
//    }
//}
