package Ciudadano;

import java.util.ArrayList;

public class Ciudadano {
    String contra;
    String cuil;
    String celular;
    ArrayList<String> sintomas;
    int solicitudesRechazadas;
    public boolean bloqueado;

    public Ciudadano(String contra, String cuil, String celular){
        this.contra = contra;
        this.cuil = cuil;
        this.celular = celular;
        sintomas = null;
        solicitudesRechazadas = 0;
        bloqueado = false;
    }

    public String getCuil() {
        return cuil;
    }

    public String getCelular() {
        return celular;
    }

    public String getContra() {
        return contra;
    }

    public void registrarContacto() {
        
    }
    public void reportarSintomas() {

    }
    public void darDeBajaSintomas() {

    }
    public void confirmacionDeEncuentro() {

    }
}
