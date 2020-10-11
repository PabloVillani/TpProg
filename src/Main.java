import Ciudadano.Ciudadano;
import Menus.MenuAdmin;
import Menus.MenuCiudadano;
import util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();
        String line;
        System.out.println("Bienvenido. Eres admin o ciudadano?:");
        int k = Scanner.getInt("1. Admin \n2. Ciudadano");
        if (k == 2) {
            String cuil = Scanner.getString("CUIL: ");
            String celular = Scanner.getString("Celular: ");
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/BaseDeDatos/BaseANSES.txt"));){
                String look = bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null){
                    String[] CUILsYCelular = look.split(",");
                    ciudadanos.add(new Ciudadano(CUILsYCelular[0], (CUILsYCelular[1])));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int indexOfCuil = indexOf(cuil, ciudadanos);
            System.out.println(indexOfCuil);
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

        }

    }
    public static int indexOf(String a, List<Ciudadano> ciudadanos) {
        for(int i= 0; i< ciudadanos.size(); i++){
            if(a != null && a.equals(ciudadanos.get(i).getCuil()) || a==null && ciudadanos.get(i).getCuil() == null){
                return i;
            }
        } return -1;
    }
}
