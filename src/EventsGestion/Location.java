package EventsGestion;

import Events.Disease;
import Events.Symptom;
import java.util.ArrayList;

public class Location {
    String name;
    ArrayList<Symptom> symptoms;
    ArrayList<Disease> diseases;

    public Location(String name, ArrayList<Symptom> symptoms, ArrayList<Disease> diseases){
        this.name = name;
        this.symptoms = symptoms;
        this.diseases = diseases;
    }
}
