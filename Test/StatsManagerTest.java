import EventsGestion.Location;
import EventsGestion.StatsManager;
import org.junit.Test;
import java.util.HashMap;

public class StatsManagerTest {
    StatsManager statsManager = new StatsManager();

    @Test
    public void test01_AllTheSymptomsShouldBeCounted(){
        HashMap<String,Integer> hm = statsManager.countSymptoms(new Location("Derqui"));
    }

    @Test
    public void test02_Top3SymptomsPrintedCorrectly(){
        String s = statsManager.top3Symptoms(new Location("Derqui"));
        System.out.println(s);
    }
}
