import Events.Symptom;
import EventsGestion.ABMSymptoms;
import Util.Writer;
import org.junit.Test;

public class ABMSymptomsTest {
    ABMSymptoms ABMSymptoms = new ABMSymptoms();
    Writer writer = new Writer();



    @Test
    public void test01_addSymptomShouldAddANewSymptom(){
        Symptom symptom = new Symptom("Tos seca");
        writer.singleValueWriter("Tos seca", "src/DataBase/ModificableBases/ActiveSymptoms.txt");
        ABMSymptoms.addSymptom(symptom);

    }

    @Test
    public void test02_ModHasToChangeTheSymptomsName(){

    }

    @Test
    public void test03_RemoveShouldDeleteAnExcistingSymptom(){

    }
}
