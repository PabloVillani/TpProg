package Events;

import Util.Date;

public class Symptom {
    String nombre;
    int numero;
    Date inicio;
    Date finalizo;

    public Symptom(String nombre, int numero){
        this.nombre = nombre;
        this.numero = numero;
    }
    Symptom(String nombre, int numero, Date inicio, Date finalizo){
        this.nombre = nombre;
        this.numero = numero;
        this.inicio = inicio;
        this.finalizo = finalizo;
    }
}
