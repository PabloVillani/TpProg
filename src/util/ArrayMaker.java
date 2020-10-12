package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayMaker {
    ArrayList<String[]> baseANSES = new ArrayList<String[]>();
    ArrayList<String[]> usuarios = new ArrayList<String[]>();
    String line;
    public static ArrayList<String[]> ansesMaker() {
        ArrayList<String[]> baseANSES = new ArrayList<String[]>();
        String line;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/BaseDeDatos/BaseANSES.txt"));){
            String head = bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null){
                String[] ciudadano = line.split(",");
                baseANSES.add(ciudadano);
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return baseANSES;
    }
    public static ArrayList<String[]> usuariosMaker(){
        ArrayList<String[]> usuarios = new ArrayList<String[]>();
        String line;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/BaseDeDatos/Usuarios.txt"));){
            String head = bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null){
                String[] usuario = line.split(",");
                usuarios.add(usuario);
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
