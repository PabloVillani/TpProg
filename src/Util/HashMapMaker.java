package Util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
public class HashMapMaker {
    public  HashMap<String, String> cuilAndSymptomsMaker(String path) {
        HashMap<String, String> map = new HashMap<String, String>();
        String line; //Lee el txt.
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String head = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {//Hasta que la linea sea nula (o sea, sin texto)
                String key = line.substring(0, 11);
                String data = ""; //Copiara los datos en un String[]
                map.put(key, data); //Que luego agregara al HashMap<String,String[]>
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
