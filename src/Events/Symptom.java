package Events;

import java.time.LocalDateTime;

public class Symptom {
    String name;
    LocalDateTime start;
    LocalDateTime end;

    public Symptom(String nombre){
        this.name = nombre;
    }

    public Symptom(String nombre, LocalDateTime inicio, LocalDateTime finalizo){
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
