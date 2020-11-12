package Events;

import Util.ArrayMaker;
import Util.Finder;

import java.util.ArrayList;

public class Outbreak {
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    //Si 5 personas tienen el mismo sintoma, y estan relacionadas, es un brote
    public void outbreak(){
        ArrayList<String[]> confirmedSymptoms = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/UsersSymptoms.txt");
        ArrayList<String[]> confirmedContacts = arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/ConfirmedContacts.txt");

    }
}
