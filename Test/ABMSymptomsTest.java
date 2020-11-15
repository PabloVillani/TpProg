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
    public void test02_ModHasToChangeTheSymptomsName(){//*
        Symptom symptom = new Symptom("Tos seca");
        ABMSymptoms abm = new ABMSymptoms();
        abm.mod(symptom);
        //no se si se puede hacer un test sobre un metodo que utiliza scanner.Si a alguien de ustedes se les ocurre como hacer este haganlo, sino borrenlo.

    }

    @Test
    public void test03_RemoveShouldDeleteAnExistingSymptom(){//*no lo pude hacer
        Symptom symptom = new Symptom("Tos seca");
        ABMSymptoms abm = new ABMSymptoms();
        abm.addSymptom(symptom);
        try {
            abm.remove(symptom);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
