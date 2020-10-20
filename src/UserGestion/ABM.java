package UserGestion;

import Admin.Admin;
import Util.*;

import java.io.IOException;
import java.util.ArrayList;

public class ABM {
    static ArrayList<Admin> admins;
    ArrayList<String[]> stringedAdmins = ArrayMaker.doubleStringMaker("src/DataBase/ModificableBases/Admins.txt");
    public ABM(){
        this.admins = new ArrayList<Admin>();
    }

    public void add(String user, String password) throws IOException{
        Admin admin = new Admin(user,password);
        admins.add(admin);
        Writer.twoValueWriter(user, password, "src/DataBase/ModificableBases/Admins.txt");
    }

    public static void remove(Admin admin) throws IOException {
        admins.remove(admin);
    }
        public void mod (String user, String password){

        }
    }

