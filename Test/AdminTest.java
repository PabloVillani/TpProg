import Admin.Admin;
import Events.Symptom;
import org.junit.Test;


import java.util.ArrayList;

public class AdminTest {

    @Test
    public void test01_TheRemovedSymptomShouldBeEliminated(){
        Admin admin = new Admin();
        admin.deactivateSymptom("Cansancio");

    }

    @Test
    public void test02_IfSomeoneTriesToRemoveASymptomTheyDontHaveAnExceptionHasToBeThrown(){

    }

    @Test
    public void test03_WhenASymptomIsActivatedTheUsersSymptomsShouldNotBeNull(){

    }

    @Test
    public void test04_WhenModifyingASymptomsNameTheNewNameAndTheOldOneShouldBeDiferent(){

    }


}
