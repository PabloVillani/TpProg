package UserGestion;

import Admin.Admin;
import Exceptions.InputException;
import Util.*;
import Util.Writer;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;


public class ABM {
    Writer writer = new Writer();
    ArrayMaker arrayMaker = new ArrayMaker();
    ArrayList<Admin> admins = new ArrayList<Admin>();
    Scanner scanner = new Scanner();
    Finder finder = new Finder();

    public ABM() {
    }

    public void add(String user, String password){
        Admin admin = new Admin(user, password);
        admins.add(admin);
        writer.twoValueWriter(user, password, "src/DataBase/ModificableBases/Admins.txt");
    }

    public void remove(String user, String password){
        Admin admin = new Admin(user, password);
        admins.remove(admin);
        writer.replace("src/DataBase/ModificableBases/Admins.txt", user + "," + password, "-,-");
    }

    public void mod(String user, String password) {
        int i = scanner.getInt("Elija que desea cambiar:\n1. Usuario\n2. Contraseña\n3. Cancelar");
        if (i == 1) {
            String newUser = scanner.getString("Ingrese su nuevo usuario: ");
            ArrayList<String[]> admins = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/Admins.txt");
            if (!finder.singleValueFinderArray(newUser, admins, 0)) {
                writer.replace("src/DataBase/ModificableBases/Admins.txt", user + "," + password, newUser + "," + password);
            }
        }
        if (i == 2) {
            String newPassword = scanner.getString("Ingrese su nueva contraseña: ");
            writer.replace("src/DataBase/ModificableBases/Admins.txt", user + "," + password, user + "," + newPassword);
        }
        if(i == 3){
            System.out.println("Volviendo al menu principal");
        }else{
            try {
                throw new InputException(81);
            } catch (InputException e) {
                e.printStackTrace();
            }
            mod(user,password);
        }

    }
}

