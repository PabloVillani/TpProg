package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayMaker {
    ArrayList<String[]> baseANSES = new ArrayList<String[]>();
    ArrayList<String[]> usuarios = new ArrayList<String[]>();
    ArrayList<String[]> admins = new ArrayList<String[]>();
    String line;
    public static ArrayList<String[]> ansesMaker() {
        ArrayList<String[]> baseANSES = new ArrayList<String[]>();
        String line;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/BaseDeDatos/BasesPreexistentes/BaseANSES.txt"));){
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
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/BaseDeDatos/BasesModificables/Usuarios.txt"));){
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

    public static ArrayList<String[]> adminsMaker() {
        ArrayList<String[]> admins = new ArrayList<String[]>();
        String line;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/BaseDeDatos/BasesModificables/Admins.txt"));){
            String head = bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null){
                String[] admin = line.split(",");
                admins.add(admin);
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return admins;
    }
}
