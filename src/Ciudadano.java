import java.util.ArrayList;

public class Ciudadano {
    String contraseña;
    String cuil;
    String celular;
    ArrayList<String> sintomas;
    int solicitudesRechazadas;
    boolean bloqueado;

    public Ciudadano(String contraseña, String cuil, String celular, ArrayList<String> sintomas, int solicitudesRechazadas, boolean bloqueado){
        this.contraseña = contraseña;
        this.cuil = cuil;
        this.celular = celular;
        this.sintomas = sintomas;
        this.solicitudesRechazadas = solicitudesRechazadas;
        this.bloqueado = bloqueado;
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
