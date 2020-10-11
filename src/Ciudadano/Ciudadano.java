package Ciudadano;

import java.util.ArrayList;

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

    public String getCuil() {
        return cuil;
    }

    public String getCelular() {
        return celular;
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
