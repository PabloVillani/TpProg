import Citizen.Citizen;
import EventsGestion.Location;
import EventsGestion.PossibleDiseases;
import org.junit.Assert;
import org.junit.Test;

public class PossibleDiseasesTest {

    @Test
    public void test01_PossibleDiseases(){
        Location derqui = new Location("Derqui");
        Citizen citizen = new Citizen("20387654679","15436782","1234",derqui);
        PossibleDiseases pos = new PossibleDiseases();
        pos.possibleDiseases(citizen);
        Assert.assertNotNull(pos);


    }
}
