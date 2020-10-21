package UserGestion;

import Admin.Admin;
import Util.*;
import Util.Writer;
import java.io.*;
import java.nio.channels.FileChannel;
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

    public static void remove(String user, String password) throws IOException {
        Admin admin = new Admin(user, password);
        admins.remove(admin);
        Replacer.replace("src/DataBase/ModificableBases/Admins.txt",user + "," + password, "");
        FileChannel src = new FileInputStream("src/DataBase/ModificableBases/Admins.txt").getChannel();
        FileChannel dest = new FileOutputStream("src/DataBase/ModificableBases/Admins2.txt").getChannel();
        dest.transferFrom(src, 0, src.size());
        try (BufferedReader inputFile = new BufferedReader(new FileReader("src/DataBase/ModificableBases/Admins2.txt"));
             PrintWriter outputFile = new PrintWriter(new FileWriter("src/DataBase/ModificableBases/Admins.txt"))) {
             String lineOfText;
             while ((lineOfText = inputFile.readLine()) != null) {
                 lineOfText = lineOfText.trim();
                 if (!lineOfText.isEmpty()) {
                    outputFile.println(lineOfText);
                 }
             }
        }
    }
        public void mod (String user, String password){
     }
}

