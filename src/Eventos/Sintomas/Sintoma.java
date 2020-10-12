package Eventos.Sintomas;

import Eventos.Enfermedades.Enfermedad;

public class Sintoma extends Enfermedad {
    String nombre;
    int numero;
    public Sintoma(String nombre, int numero){
        this.nombre = nombre;
        this.numero = numero;
    }
}
