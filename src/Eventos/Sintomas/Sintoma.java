package Eventos.Sintomas;

import Eventos.Enfermedades.Enfermedad;
import util.Fecha;

public class Sintoma extends Enfermedad {
    String nombre;
    int numero;
    Fecha inicio;
    Fecha finalizo;

    public Sintoma(String nombre, int numero){
        this.nombre = nombre;
        this.numero = numero;
    }
}
