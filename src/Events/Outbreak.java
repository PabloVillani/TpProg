package Events;

import Citizen.Citizen;
import EventsGestion.Location;
import Util.ArrayMaker;
import Util.Finder;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Outbreak {
    //Si 5 personas tienen el mismo sintoma, y estan relacionadas, es un brote
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    private Integer citizensInvolved;
    private Location location;
    private ArrayList<String> citizenCuils;
    private Symptom symptom;
    private LocalDateTime date;

    public Outbreak(){}

    public Outbreak(ArrayList<String> citizenCuils, Integer citizensInvolved, Location location, Symptom symptom, LocalDateTime date) {
        this.citizensInvolved = citizensInvolved;
        this.location = location;
        this.citizenCuils = citizenCuils;
        this.symptom = symptom;
        this.date = date;
    }

    public Integer getCitizensInvolved() {
        return citizensInvolved;
    }

    public Location getLocation() {
        return location;
    }

    public ArrayList<String> getCitizenCuils() {
        return citizenCuils;
    }

    public Symptom getSymptom() {
        return symptom;
    }

}
