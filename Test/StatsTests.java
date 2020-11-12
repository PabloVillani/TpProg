import EventsGestion.StatsManager;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatsTests {
    StatsManager statsManager = new StatsManager();

    @Test
    public void test01_TopSymptomsShouldBeOrganized(){
        statsManager.topSymptoms("Derqui");
    }
}
