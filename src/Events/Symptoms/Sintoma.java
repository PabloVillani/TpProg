package Events.Symptoms;

import Events.Diseases.Enfermedad;
import Util.Date;

public class Sintoma extends Enfermedad {
    String nombre;
    int numero;
    Date inicio;
    Date finalizo;

    public Sintoma(String nombre, int numero){
        this.nombre = nombre;
        this.numero = numero;
    }
}
