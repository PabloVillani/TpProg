package Admin;

import Events.Symptom;
import EventsGestion.ABMSymptoms;
import Util.ArrayMaker;
import Util.Finder;
import Util.Replacer;
import Util.Writer;

import java.io.IOException;

//Objeto de admin, con sus capacidades de trabajo.
public class Admin  {
    String user;
    String password;

    public Admin(String user, String password){
        this.password = password;
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public static void unlock(String cuil) { //Desbloquea el usuario.
        if (Finder.doubleValueFinder(cuil, "true", ArrayMaker.doubleStringMaker("src/DataBase/ModificableBases/BlockedUsers.txt"))) {
            Replacer.replace("src/DataBase/ModificableBases/BlockedUsers.txt", cuil + ",true", cuil + ",false");
            System.out.println("Ciudadano desbloqueado.");
        }
        else {
            System.out.println("El ciudadano ya esta desbloqueado.");
        }
    }

    public static void deactivateSymptom(String symptom) { //Dar de baja sintomas
        Symptom s = new Symptom(symptom);
        try {
            ABMSymptoms.remove(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void activateSymptom(String symptom) { //Agrega sintomas
        Symptom s = new Symptom(symptom);
        try {
            ABMSymptoms.add(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void modificateSymptom(String symptom){//Modifica el nombre de un sintoma
    Symptom s = new Symptom(symptom);
    try {
        ABMSymptoms.mod(s);
    } catch (Exception e) {
        e.printStackTrace();
    }
    }


}
