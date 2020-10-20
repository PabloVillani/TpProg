package Events;

import Util.Date;

public class Sintoma extends Disease {
    String nombre;
    int numero;
    Date inicio;
    Date finalizo;

    public Sintoma(String nombre, int numero){
        this.nombre = nombre;
        this.numero = numero;
    }
}
