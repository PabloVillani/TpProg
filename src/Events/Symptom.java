package Events;

import java.util.GregorianCalendar;

public class Symptom {
    String name;
    GregorianCalendar start;
    GregorianCalendar end;

    public Symptom(String nombre){
        this.name = nombre;
    }

    public Symptom(String nombre,GregorianCalendar inicio, GregorianCalendar finalizo){
        this.name = nombre;
        this.start = inicio;
        this.end = finalizo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
