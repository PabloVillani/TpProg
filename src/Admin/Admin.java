package Admin;

import Util.ArrayMaker;
import Util.Finder;
import Util.Replacer;
import Util.Writer;

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

    public void deactivateSymptom() { } //Dar de baja sintomas

    public void ActivateSymptom() { } //Agrega-Notifica sintomas


}
