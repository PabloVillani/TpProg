import Citizen.Citizen;
import Events.Outbreak;
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
        Outbreak outbreak = statsManager.possibleOutbreak(new Citizen("1","2",derqui),derqui );
        Assert.assertNotNull(outbreak);
    }

}
