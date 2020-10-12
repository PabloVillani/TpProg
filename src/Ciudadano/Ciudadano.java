package Ciudadano;

import util.Scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ciudadano {
    String cuil;
    String celular;
    ArrayList<String> sintomas;
    int solicitudesRechazadas;
    public boolean bloqueado;

    public Ciudadano(String cuil, String celular){ //Un Ciudadano Base, recien registrado al sistema.
        this.cuil = cuil;
        this.celular = celular;
        sintomas = null;
        solicitudesRechazadas = 0;
        bloqueado = false;
    }
    public Ciudadano(String cuil, String celular, ArrayList<String>sintomas, int solicitudesRechazadas, boolean bloqueado){ //Un ciudadano con todas las variables.
        this.cuil = cuil;
        this.celular = celular;
        this.sintomas = sintomas;
        this.solicitudesRechazadas = solicitudesRechazadas;
        this.bloqueado = bloqueado;
    }
    //----------------------------------------GETTERS Y SETTERS---------------------------
    public String getCuil() {
        return cuil;
    }

    public String getCelular() {
        return celular;
    }
    public boolean isBloqueado() {
        return bloqueado;
    }
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    //-------------------------------------------------------------------------------------
    public static void registrarContacto() {
        String cuilCiudadanoContactado = Scanner.getString("Ingrese el cuil del ciudadano con el que tuvo contacto: ");
        //Tendremos que comparar el cuil de ciudadanoContactado con la lista de cuils de Usuarios.txt, si encuentra una coincidencia debe enviar una solicitud
        //todo
    }

    public static void reportarSintomas() {
        try {
            FileReader fr = new FileReader("src/BaseDeDatos/BaseSintomas.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line); //Imprime la lista de sintomas.
                line = br.readLine(); //lee la primer linea y despues pasa a la siguiente, si no hay más devuelve null, y se termina el while.
            }
            List<String> sintomas = new ArrayList<>(); //Crea el array de sintomas.
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        int i = Scanner.getInt("Ingrese su sintoma: "); //Pide el numero del sintoma.
        if(i < 1 || i > 9) {
            System.out.println("Numero invalido"); //Recursion en caso de ingresar un numero invalido.
            reportarSintomas();
        } else {
            try {
                File archivo = new File("src/BaseDeDatos/BasesModificables/SintomasUsuarios.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
                BufferedReader br = new BufferedReader(new FileReader("src/BaseDeDatos/BasesModificables/SintomasUsuarios.txt"));
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
    public void darDeBajaSintomas() {

    }
    public void confirmacionDeEncuentro() {

    }
}
