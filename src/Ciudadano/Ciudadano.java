package Ciudadano;

import util.Scanner;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Ciudadano {
    String cuil;
    String celular;
    ArrayList<String> sintomas;
    int solicitudesRechazadas;
    public boolean bloqueado;

    public Ciudadano(String cuil, String celular){
        this.cuil = cuil;
        this.celular = celular;
        sintomas = null;
        solicitudesRechazadas = 0;
        bloqueado = false;
    }
    public Ciudadano(String cuil, String celular, ArrayList<String>sintomas, int solicitudesRechazadas, boolean bloqueado){
        this.cuil = cuil;
        this.celular = celular;
        this.sintomas = sintomas;
        this.solicitudesRechazadas = solicitudesRechazadas;
        this.bloqueado = bloqueado;
    }

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

    public void registrarContacto() {
        String cuilCiudadanoContactado = Scanner.getString("Ingrese el cuil del ciudadano con el que tuvo contacto: ");
        //Tendremos que comparar el cuil de ciudadanoContactado con la lista de cuils de Usuarios.txt, si encuentra una coincidencia debe enviar una solicitud

    }
    public void reportarSintomas() {
        try {
            FileReader fr = new FileReader("src/BaseDeDatos/BaseSintomas");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine(); //lee la primer linea y despues pasa a la siguiente, si no hay más tira null
            }
            List<String> sintomas = new ArrayList<>();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        int i = Scanner.getInt("Ingrese su sintoma: ");
        if(i < 1 || i > 9) {
            System.out.println("Numero invalido");
            reportarSintomas();
        } else {
            try {
                File archivo = new File("src/BaseDeDatos/Ciudadanos.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
                bw.write("ola");
                bw.close();
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
