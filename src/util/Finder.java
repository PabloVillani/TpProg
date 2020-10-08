package util;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import Ciudadano.Ciudadano;
public class Finder {
    public static void main(String[] args) {
        List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Guido\\Desktop\\austral\\archivo\\src\\Covid\\datos.txt"));) {
            String cabecera = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] Ciudadano = line.split(",");
                ciudadanos.add(new Ciudadano(Ciudadano[0], (Ciudadano[1]), (Ciudadano[2])));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
