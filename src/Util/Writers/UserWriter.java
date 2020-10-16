package Util.Writers;


import java.io.*;

public class UserWriter {
    public static void userWriter(String cuil, String mobile, String password, String ubication){
        try{
            File archive = new File("src/DataBase/ModificableBases/Users.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(archive, true));
            BufferedReader br = new BufferedReader(new FileReader("src/DataBase/ModificableBases/Users.txt"));
            String n = br.readLine();
            int j = n.length();
            br.skip(j); //Skippea la 1ra de Users.txt
            pw.println(cuil + "," + mobile + "," + password + "," + ubication);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
