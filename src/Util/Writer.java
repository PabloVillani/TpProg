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
    public static void fourValueWriter(String value1, String value2, String value3, String value4, String path){
        try{
            File archive = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
            bw.write("\n" + value1 + "," + value2 + "," + value3 + "," + value4);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
