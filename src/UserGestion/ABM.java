package UserGestion;

import Admin.Admin;
import Util.*;
import Util.Writer;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


public class ABM {
    static ArrayList<Admin> admins = new ArrayList<Admin>();
    static ArrayList<String[]> stringedAdmins = ArrayMaker.doubleStringMaker("src/DataBase/ModificableBases/Admins.txt");
    public ABM(ArrayList<Admin> admins){
        this.admins = admins;
    }

    public static void add(String user, String password) throws IOException{
        Admin admin = new Admin(user,password);
        admins.add(admin);
        Writer.twoValueWriter(user, password, "src/DataBase/ModificableBases/Admins.txt");
    }

    public static void remove(Admin admin) throws IOException {
        admins.remove(admin);
        stringedAdmins.remove(admin.getUser());
        stringedAdmins.remove(admin.getPassword());
        File oldFile = new File("src/DataBase/ModificableBases/Admins.txt");
        Iterator i = stringedAdmins.iterator();
        for (String[] a : stringedAdmins) {
            for (String s : a) {
                Writer.twoValueWriter(s, a[1], "src/DataBase/ModificableBases/Admins.txt");
            }
        }
    }
        public void mod (String user, String password){

        }
    }

