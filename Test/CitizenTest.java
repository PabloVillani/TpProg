import Citizen.Citizen;
import Events.Symptom;
import EventsGestion.Location;
import org.junit.Test;

import java.util.ArrayList;

public class CitizenTest {

    Citizen citizen = new Citizen("1","2",new Location("Derqui"));


     @Test
    public void test01_YoushouldntReportASymptomThatYouAlreadyHave(){

    }
}
