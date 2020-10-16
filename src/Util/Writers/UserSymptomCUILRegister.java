package Util.Writers;

import java.io.*;

public class UserSymptomCUILRegister {
    public static void CuilWriter(String cuil){
        try{
            File archive = new File("src/DataBase/ModificableBases/UsersSymptoms.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(archive, true));
            BufferedReader br = new BufferedReader(new FileReader("src/DataBase/ModificableBases/UsersSymptoms.txt"));
            String n = br.readLine();
            int j = n.length();
            br.skip(j+1); //Skippea la 1ra de UsersSymptoms.txt
            pw.println(cuil);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
