package Util;

import java.io.*;

public class Replacer {
    public static void replace(String path, String oldString, String newString)
    {
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
