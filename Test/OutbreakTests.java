import Citizen.Citizen;
import Events.Outbreak;
import Events.Symptom;
import EventsGestion.Location;
import EventsGestion.StatsManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class OutbreakTests {
    StatsManager statsManager = new StatsManager();

    @Test
    public void test01_OutbreakCreatedCorrectly(){
        Location derqui =  new Location("Derqui");
        Outbreak outbreak = statsManager.possibleOutbreak(new Citizen("20387654679","2","3",derqui),derqui,new Symptom("Fiebre"));
        Assert.assertNotNull(outbreak);
    }

}
