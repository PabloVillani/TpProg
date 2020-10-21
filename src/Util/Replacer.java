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
            //Reading all the lines of input text file into oldContent
            String line = br.readLine();
            while (line != null)
            {
                oldContent.append(line).append(System.lineSeparator());
                line = br.readLine();
            }
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.toString().replaceAll(oldString, newString);
            //Rewriting the input text file with newContent
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
                //Closing the resources
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
