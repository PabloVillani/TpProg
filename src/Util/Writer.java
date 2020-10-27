package Util;

import java.io.*;

public class Writer {
    public Writer(){}
    public void singleValueWriter(String value1, String path){
        try{
            File archive = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
            bw.write("\n" + value1);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void twoValueWriter(String value1, String value2, String path) {
        try {
            File archive = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
            bw.write("\n" + value1 + "," + value2);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fourValueWriter(String value1, String value2, String value3, String value4, String path){
        try{
            File archive = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
            bw.write("\n" + value1 + "," + value2 + "," + value3 + "," + value4);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fiveValueWriter(String value1, String value2, String value3, String value4, String value5, String path){
        try{
            File archive = new File(path);
            BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
            bw.write("\n" + value1 + "," + value2 + "," + value3 + "," + value4 + "," + value5);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void replace(String path, String oldString, String newString){
        File file = new File(path);
        StringBuilder oldContent = new StringBuilder();
        BufferedReader br = null;
        FileWriter fw = null;
        try
        {
            br = new BufferedReader(new FileReader(file));
            // Lectura de todas las líneas del archivo de texto de entrada en oldContent
            String line = br.readLine();
            while (line != null)
            {
                oldContent.append(line).append(System.lineSeparator());
                line = br.readLine();
            }
            //Remplaza oldString con newString en OldContent
            String newContent = oldContent.toString().replaceAll(oldString, newString);
            // Resscribe el archivo de texto de entrada con newContent
            fw = new FileWriter(file);
            fw.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                // Cierre de ciclo
                br.close();
                fw.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
