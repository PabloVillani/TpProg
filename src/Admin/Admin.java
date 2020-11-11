package Admin;

import Events.Symptom;
import EventsGestion.ABMSymptoms;
import Util.ArrayMaker;
import Util.Finder;
import Util.Writer;

import java.io.IOException;
import java.util.ArrayList;

//Objeto de admin, con sus capacidades de trabajo.
public class Admin  {
    String user;
    String password;
    ArrayMaker arrayMaker = new ArrayMaker();
    Finder finder = new Finder();
    Writer writer = new Writer();
    ABMSymptoms abmSymptoms = new ABMSymptoms();

    public Admin(String user, String password){
        this.password = password;
        this.user = user;
    }

    public Admin() {
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void unlock(String cuil) {//Desbloquea el usuario.
        if (finder.doubleValueFinder(cuil, "true", arrayMaker.arrayListStringMaker("src/DataBase/ModificableBases/BlockedUsers.txt"))) {
            writer.replace("src/DataBase/ModificableBases/BlockedUsers.txt", cuil + ",true", cuil + ",false");
            System.out.println("Ciudadano desbloqueado.");
        }
        else {
            System.out.println("El ciudadano ya esta desbloqueado.");
        }
    }

    public void deactivateSymptom(String symptom){ //Dar de baja sintomas
        ArrayList<Symptom> symptoms;
        Symptom s = new Symptom(symptom);
        try {
            abmSymptoms.remove(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void activateSymptom(String symptom) { //Agrega sintomas

        Symptom s = new Symptom(symptom);
        abmSymptoms.addSymptom(s);
    }

    public void modificateSymptom(String symptom){//Modifica el nombre de un sintoma
        Symptom s = new Symptom(symptom);
        try {
            abmSymptoms.mod(s);
        }   catch (Exception e) {
            e.printStackTrace();
            }
    }
}
