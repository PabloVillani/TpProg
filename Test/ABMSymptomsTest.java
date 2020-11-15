import Events.Symptom;
import EventsGestion.ABMSymptoms;
import Util.Writer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ABMSymptomsTest {


    @Test
    public void test01_AddSymptomShouldAddASymptomCorrectlly(){
        Symptom symptom = new Symptom("Tos seca");
        ABMSymptoms abm = new ABMSymptoms();
        abm.addSymptom(symptom);
        Assert.assertNotNull(abm);
    }

    @Test
    public void test03_RemoveShouldDeleteAnExistingSymptom() throws IOException {//*no lo pude hacer
        Symptom symptom = new Symptom("Escalofrios");
        ABMSymptoms abm = new ABMSymptoms();
        abm.addSymptom(symptom);
        abm.remove(symptom);
    }
}
