package Util;

import java.io.*;

public class Writer {
    public static void singleValueWriter(String cuil, String path){
        try{
            File archive = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
            BufferedReader br = new BufferedReader(new FileReader(path));
            String n = br.readLine();
            int j = n.length();
            br.skip(j+1);//Skippea la 1ra linea del archivo
            bw.write(cuil + "\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void twoValueWriter(String value1, String value2, String path) {
        try {
            File archive = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
            BufferedReader br = new BufferedReader(new FileReader(path));
            String n = br.readLine();
            int j = n.length();
            br.skip(j + 1);//Skippea la 1ra linea del archivo
            bw.write(value1 + "," + value2 + "\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void userWriter(String cuil, String mobile, String password, String ubication){
        try{
            File archive = new File("src/DataBase/ModificableBases/Users.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
            BufferedReader br = new BufferedReader(new FileReader("src/DataBase/ModificableBases/Users.txt"));
            String n = br.readLine();
            int j = n.length();
            br.skip(j); //Skippea la 1ra de Users.txt
            bw.write(cuil + "," + mobile + "," + password + "," + ubication + "\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
