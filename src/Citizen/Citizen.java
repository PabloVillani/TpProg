package Citizen;

import Util.ArrayMaker;
import Util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Citizen {
    public String cuil;
    public String mobile;
    ArrayList<String> symptoms;
    int rejectedRequests;
    public boolean blocked;
    ArrayMaker arrayMaker = new ArrayMaker();
    Scanner scanner = new Scanner();

    public Citizen(String cuil, String mobile){ //Un Ciudadano Base, recien registrado al sistema.
        this.cuil = cuil;
        this.mobile = mobile;
        symptoms = null;
        rejectedRequests = 0;
        blocked = false;
    }
    public Citizen(String cuil, String mobile, ArrayList<String>symptoms, int rejectedRequests, boolean blocked){ //Un ciudadano con todas las variables.
        this.cuil = cuil;
        this.mobile = mobile;
        this.symptoms = symptoms;
        this.rejectedRequests = rejectedRequests;
        this.blocked = blocked;
    }
    //----------------------------------------GETTERS Y SETTERS---------------------------
    public String getCuil() {
        return cuil;
    }

    public String getMobile() {
        return mobile;
    }
    public boolean isBlocked() {
        return blocked;
    }
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    //-------------------------------------------------------------------------------------
    public void ContactRequest() {
        String contactCitizenCUIL = scanner.getString("Ingrese el CUIL del ciudadano con el que ha tenido contacto: ");
        System.out.println("Inicio del contacto:");
        Date start = new Date();
        System.out.println("Fin del contacto:");
        Date end = new Date();
        //Util.Writer.fourValueWriter(this.cuil, contactCitizenCUIL, start, end);
    }

    public void symptomsReport(String cuil) {
        List<String> symptoms = arrayMaker.singleStringMaker("src/DataBase/ModificableBases/ActiveSymptoms.txt");
        System.out.println();
        int i = scanner.getInt("Ingrese su sintoma: "); //Pide el numero del sintoma.
        if(i < 1 || i > 9) {
            System.out.println("Numero Invalido."); //Recursion en caso de ingresar un numero invalido.
            symptomsReport(cuil);
        } else {
            try {
                File archive = new File("src/DataBase/ModificableBases/UsersSymptoms.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(archive, true));
                BufferedReader br = new BufferedReader(new FileReader("src/DataBase/ModificableBases/UsersSymptoms.txt"));
                String n = br.readLine();
                int j = n.length();
                br.skip(j+1);
                String w = br.readLine();
                int e = n.length();
                br.skip(e);
                String linea = "";
                if(i == 1) {
                    linea = "Fiebre";
                }if(i == 2) {
                    linea = "Tos seca";
                }if(i == 3) {
                    linea = "Cansancio";
                }if(i == 4) {
                    linea = "Sarpullidos";
                }if(i == 5) {
                    linea = "Inflamacion de los Ojos";
                }if(i == 6) {
                    linea = "Tos con flema";
                }if(i == 7) {
                    linea = "Escalofrios";
                }if(i == 8) {
                    linea = "Dificultad para respirar";
                }if(i == 9) {
                    linea = "Perdida de olfato/gusto";
                }
                bw.write(linea);
                bw.close(); //Anota el sintoma en el .txt, junto al CUIL del usuario.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void SolveSymptoms() {

    }
    public void meetingConfirmation() {

    }
}
