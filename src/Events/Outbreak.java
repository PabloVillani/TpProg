package Events;

import Citizen.Citizen;
import EventsGestion.Location;
import Util.ArrayMaker;
import Util.Finder;

import java.util.ArrayList;

public class Outbreak {
    //Si 5 personas tienen el mismo sintoma, y estan relacionadas, es un brote
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    Integer citizensInvolved;
    Location location;

    public Outbreak(Integer citizensInvolved, Location location) {
        this.citizensInvolved = citizensInvolved;
        this.location = location;
    }
}