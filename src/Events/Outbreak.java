package Events;

import EventsGestion.Location;
import java.time.LocalDateTime;

public class Outbreak {
    //Si 5 personas tienen el mismo sintoma, y estan relacionadas, es un brote
    private Integer citizensInvolved;
    private Location location;
    private Symptom symptom;
    private LocalDateTime date;

    public Outbreak(){}

    public Outbreak(Symptom symptom, Integer citizensInvolved, Location location,LocalDateTime date) {
        this.citizensInvolved = citizensInvolved;
        this.location = location;
        this.symptom = symptom;
        this.date = date;
    }

    public Integer getCitizensInvolved() {
        return citizensInvolved;
    }

    public Location getLocation() {
        return location;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public LocalDateTime getDate(){
        return date;
    }
}
