package Events;

import Util.Date;

public class Symptom {
    String name;
    Date start;
    Date end;

    public Symptom(String nombre){
        this.name = nombre;
    }
    Symptom(String nombre,Date inicio, Date finalizo){
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
