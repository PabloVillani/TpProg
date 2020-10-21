package Util;

import java.io.*;

public class Writer {
    public static void singleValueWriter(String value1, String path){
        try{
            File archive = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
            bw.write("\n" + value1);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void twoValueWriter(String value1, String value2, String path) {
        try {
            File archive = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
            bw.write("\n" + value1 + "," + value2);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void userWriter(String cuil, String mobile, String password, String ubication){
        try{
            File archive = new File("src/DataBase/ModificableBases/Users.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
            bw.write("\n" + cuil + "," + mobile + "," + password + "," + ubication);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
